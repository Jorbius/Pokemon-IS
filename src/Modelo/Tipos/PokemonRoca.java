package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonRoca extends Pokemon{

	public PokemonRoca(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.ROCA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.VOLADOR)|| tipo.equals(Tipo.FUEGO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
