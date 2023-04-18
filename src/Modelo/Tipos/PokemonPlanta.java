package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonPlanta extends Pokemon{

	public PokemonPlanta(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.PLANTA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.TIERRA) || tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.AGUA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
