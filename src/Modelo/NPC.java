package Modelo;

import java.util.Random;
import Modelo.Pokemon;

public class NPC extends Jugador{

	public NPC(int pPokemon, int cant) {
		super(pPokemon, cant);
		setNombre("NPC " + cant);
	}
	public void jugar() {
		for (Pokemon pAtacante : getListaPokemons().getPokemonVivos()) {
			Jugador jDefensor = ListaJugadores.getListaJugadores().jugadorRandom(this);
			Pokemon pDefensor = jDefensor.getListaPokemons().getPokemonVivos().get((new Random()).nextInt(jDefensor.getListaPokemons().getPokemonVivos().size()));
			ControladorPartida.getControladorPartida().setPokemonAtacante(pAtacante);
			ControladorPartida.getControladorPartida().setPokemonDefensor(pDefensor);
			ControladorPartida.getControladorPartida().setJugadorAtacante(this);
			ControladorPartida.getControladorPartida().setJugadorDefensor(jDefensor);
			ControladorPartida.getControladorPartida().atacar();
		}
	}
}
