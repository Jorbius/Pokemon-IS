package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonFuego extends Pokemon{

	public PokemonFuego(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.FUEGO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.ROCA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}