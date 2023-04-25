package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonHielo extends Pokemon{

	public PokemonHielo(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.HIELO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.FUEGO)|| tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.ACERO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
