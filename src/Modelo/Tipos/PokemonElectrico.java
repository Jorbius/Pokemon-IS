package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonElectrico extends Pokemon{

	public PokemonElectrico(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.ELECTRICO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.ROCA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}