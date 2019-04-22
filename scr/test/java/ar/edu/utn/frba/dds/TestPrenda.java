package ar.edu.utn.frba.dds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPrenda {
	
	private Prenda unPantalon;
	private Prenda unaRemera;
	private Prenda unaCampera;
	private Prenda parZapatillas;
	private Prenda unaGorra;
	private Set<Prenda> unConjunto;
	private Consejero unConsejero;
	private Set<Prenda> otroConjunto;
	
	@Before
	public void init() {
		unPantalon = new Prenda(TipoPrenda.Pierna);
		unaRemera = new Prenda(TipoPrenda.Torso);
		unaCampera = new Prenda(TipoPrenda.Torso);
		parZapatillas = new Prenda(TipoPrenda.Pie);
		unaGorra = new Prenda(TipoPrenda.Accesorio);
		Prenda[] prendas = {unPantalon,unaCampera, unaRemera,parZapatillas,unaGorra};
		unConjunto = new HashSet<Prenda>(Arrays.asList(prendas));
		unConsejero = new Consejero();
		otroConjunto = new HashSet<Prenda>();
		otroConjunto.add(unPantalon);
		otroConjunto.add(unaCampera);
		otroConjunto.add(parZapatillas);
		//unaSugerencia.add(unaRemera);
	}
	
	@Test
	public void testTipo() {
		Assert.assertEquals(unPantalon.getTipo(),TipoPrenda.Pierna);
	}
	
	@Test
	public void testSugerencia() {
		Assert.assertEquals(unConjunto.size(),5);
		Assert.assertEquals(unConsejero.todasCombinaciones(otroConjunto).size(),7);
		Assert.assertTrue(unConsejero.esValida(unConjunto));
		Assert.assertEquals(unConsejero.darSugerenciasPara(otroConjunto).size(),1);
		Assert.assertTrue(unConsejero.todasCombinaciones(unConjunto).contains(unConjunto));
	}
}
