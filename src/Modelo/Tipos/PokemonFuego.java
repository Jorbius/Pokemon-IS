package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonFuego extends Pokemon{

	public PokemonFuego(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.FUEGO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.PLANTA)||tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.ACERO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
