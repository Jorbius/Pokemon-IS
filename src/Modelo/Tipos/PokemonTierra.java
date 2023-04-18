package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonTierra extends Pokemon{

	public PokemonTierra(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.TIERRA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.ELECTRICO) || tipo.equals(Tipo.ROCA)||tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.VENENO)|| tipo.equals(Tipo.ACERO)) {
			aumento = this.random.nextInt(2)+2;
		}
		if (tipo.equals(Tipo.VOLADOR)) {
			aumento = 0;
		}
		return aumento;
	}
}
