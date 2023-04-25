package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonPlanta extends Pokemon{

	public PokemonPlanta(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.PLANTA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.VOLADOR) || tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.VENENO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
