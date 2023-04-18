package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonElectrico extends Pokemon{

	public PokemonElectrico(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.ELECTRICO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.AGUA)||tipo.equals(Tipo.VOLADOR) ) {
			aumento = this.random.nextInt(2)+2;
		}
		if (tipo.equals(Tipo.TIERRA) ) {
			aumento = 0;
		}
		return aumento;
	}
}
