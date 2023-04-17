package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonVolador extends Pokemon{

	public PokemonVolador(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.VOLADOR;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.ELECTRICO) || tipo.equals(Tipo.ROCA)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}