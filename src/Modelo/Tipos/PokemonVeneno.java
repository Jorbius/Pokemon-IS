package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonVeneno extends Pokemon{

	public PokemonVeneno(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.VENENO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.HADA) || tipo.equals(Tipo.PLANTA)) {
			aumento = this.random.nextInt(2)+2;
		}
		if (tipo.equals(Tipo.ACERO)) {
			aumento = 0;
		}
		return aumento;
	}
}
