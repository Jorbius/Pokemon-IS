package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonPsiquico extends Pokemon{

	public PokemonPsiquico(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.PSIQUICO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.FANTASMA) || tipo.equals(Tipo.SINIESTRO)) {
			aumento = this.random.nextInt(2)+2;
		}
		return aumento;
	}
}
