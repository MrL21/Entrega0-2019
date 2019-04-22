package ar.edu.utn.frba.dds;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Consejero {
	
	public Set<Set<Prenda>> darSugerenciasPara(Set<Prenda> unConjunto) {
		return this.todasCombinaciones(unConjunto).stream().filter( sugerencia -> this.esValida(sugerencia)).collect(Collectors.toSet());
	}

	 public HashSet<Set<Prenda>> todasCombinaciones(Set<Prenda> prendas) {
		HashSet<Set<Prenda>> combinaciones = new HashSet<>();
		HashSet<Prenda> unaCombinacion;
		HashSet<HashSet<Prenda>> setBase = new HashSet<>();
		for(Prenda prenda:prendas) {
			unaCombinacion = new HashSet<>();
			unaCombinacion.add(prenda);
			combinaciones.add(unaCombinacion);
			setBase.add(unaCombinacion);
		}
		for(Set<Prenda> set: setBase) {
			for(Prenda prenda:prendas){
			set.add(prenda);
			combinaciones.add(set);
			}
		}
		return combinaciones;
	}
	
	public Boolean esValida(Set<Prenda> combinacion){
		return this.tieneTipo(combinacion,TipoPrenda.Pie) 
				 && this.tieneTipo(combinacion,TipoPrenda.Pierna)
				&& this.tieneTipo(combinacion,TipoPrenda.Torso) ;
	}

	private Boolean tieneTipo(Set<Prenda> combinacion,TipoPrenda tipo) {
		return combinacion.stream().anyMatch(prenda->prenda.getTipo() == tipo);
	}

	
}
