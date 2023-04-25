package Modelo.Tipos;

import Modelo.Pokemon;

public class PokemonSiniestro extends Pokemon{

	public PokemonSiniestro(int pPosicion) {
		super(pPosicion);
		this.tipo = Tipo.SINIESTRO;
	}
	
	protected int aumentarAtaque(Tipo tipo) {
		int aumento = 1;
		if (tipo.equals(Tipo.BICHO)||tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.HADA)) {
			aumento = this.random.nextInt(2)+2;
		}
		if (tipo.equals(Tipo.PSIQUICO) ) {
			aumento = 0;
		}
		return aumento;
	}
}
