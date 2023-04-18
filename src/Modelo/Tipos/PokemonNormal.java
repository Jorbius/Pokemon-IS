package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonNormal extends Pokemon{

	public PokemonNormal(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.NORMAL;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.ELECTRICO) || tipo.equals(Tipo.PLANTA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
