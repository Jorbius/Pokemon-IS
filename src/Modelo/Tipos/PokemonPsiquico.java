package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonPsiquico extends Pokemon{

	public PokemonPsiquico(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.PSIQUICO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.VENENO)) {
			aumento = this.random.nextInt(2)+2;
		}
		if (tipo.equals(Tipo.SINIESTRO) ) {
			aumento = 0;
		}
		return aumento;
	}
}
