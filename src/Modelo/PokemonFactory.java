package Modelo;

import Modelo.Tipos.PokemonAcero;
import Modelo.Tipos.PokemonAgua;
import Modelo.Tipos.PokemonBicho;
import Modelo.Tipos.PokemonDragon;
import Modelo.Tipos.PokemonElectrico;
import Modelo.Tipos.PokemonFantasma;
import Modelo.Tipos.PokemonFuego;
import Modelo.Tipos.PokemonHada;
import Modelo.Tipos.PokemonHielo;
import Modelo.Tipos.PokemonLucha;
import Modelo.Tipos.PokemonNormal;
import Modelo.Tipos.PokemonPlanta;
import Modelo.Tipos.PokemonVolador;
import Modelo.Tipos.PokemonPsiquico;
import Modelo.Tipos.PokemonRoca;
import Modelo.Tipos.PokemonSiniestro;
import Modelo.Tipos.PokemonTierra;
import Modelo.Tipos.PokemonVeneno;
import Modelo.Tipos.Tipo;

public class PokemonFactory {
	private static PokemonFactory pokemonFactory = null;
	
	public static PokemonFactory getPokemonFactory() {
		if (pokemonFactory == null) {
			pokemonFactory = new PokemonFactory();
		}
		return pokemonFactory;
	}
	public Pokemon createPokemon(Tipo tipo, int pos) {
		Pokemon pokemon = null;
		if (tipo == Tipo.AGUA ) {
			pokemon = new PokemonAgua(pos);
		}
		if (tipo == Tipo.BICHO ) {
			pokemon = new PokemonBicho(pos);
		}
		if (tipo == Tipo.DRAGON ) {
			pokemon = new PokemonDragon(pos);
		}
		if (tipo == Tipo.ELECTRICO ) {
			pokemon = new PokemonElectrico(pos);
		}
		if (tipo == Tipo.FANTASMA ) {
			pokemon = new PokemonFantasma(pos);
		}
		if (tipo == Tipo.FUEGO ) {
			pokemon = new PokemonFuego(pos);
		}
		if (tipo == Tipo.LUCHA ) {
			pokemon = new PokemonLucha(pos);
		}
		if (tipo == Tipo.PLANTA ) {
			pokemon = new PokemonPlanta(pos);
		}
		if (tipo == Tipo.PSIQUICO ) {
			pokemon = new PokemonPsiquico(pos);
		}
		if (tipo == Tipo.ROCA ) {
			pokemon = new PokemonRoca(pos);
		}
		if (tipo == Tipo.VOLADOR ) {
			pokemon = new PokemonVolador(pos);
		}
		if (tipo == Tipo.HIELO ) {
			pokemon = new PokemonHielo(pos);
		}
		if (tipo == Tipo.TIERRA ) {
			pokemon = new PokemonTierra(pos);
		}
		if (tipo == Tipo.ACERO ) {
			pokemon = new PokemonAcero(pos);
		}
		if (tipo == Tipo.VENENO ) {
			pokemon = new PokemonVeneno(pos);
		}
		if (tipo == Tipo.HADA ) {
			pokemon = new PokemonHada(pos);
		}
		if (tipo == Tipo.NORMAL ) {
			pokemon = new PokemonNormal(pos);
		}
		if (tipo == Tipo.SINIESTRO ) {
			pokemon = new PokemonSiniestro(pos);
		}
		
		return pokemon;
	}
}
