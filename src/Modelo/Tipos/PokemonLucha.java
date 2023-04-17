package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonLucha extends Pokemon{

	public PokemonLucha(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.LUCHA;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.PSIQUICO) || tipo.equals(Tipo.VOLADOR)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}