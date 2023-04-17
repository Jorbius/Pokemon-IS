package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonDragon extends Pokemon{

	public PokemonDragon(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.DRAGON;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.DRAGON)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}