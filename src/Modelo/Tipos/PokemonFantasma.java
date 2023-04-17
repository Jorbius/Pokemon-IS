package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonFantasma extends Pokemon{

	public PokemonFantasma(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.FANTASMA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.FANTASMA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}