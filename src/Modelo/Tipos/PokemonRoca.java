package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonRoca extends Pokemon{

	public PokemonRoca(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.ROCA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.LUCHA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}