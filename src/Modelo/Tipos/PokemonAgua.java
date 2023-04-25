package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonAgua extends Pokemon{

	public PokemonAgua(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.AGUA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.ELECTRICO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
