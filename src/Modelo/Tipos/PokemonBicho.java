package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonBicho extends Pokemon{

	public PokemonBicho(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.BICHO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.VOLADOR) || tipo.equals(Tipo.ROCA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}