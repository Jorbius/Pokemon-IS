package Modelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Juego extends Observable {
	private static Juego juego = null;
	private Timer temporizador = null;

	// Iniciar instancia unica del juego si no hay una
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}

	// Cargar jugadores y NPCs
	public void cargarJugadores(int pJugador, int pNPC, int pPokemon) {
		int cantidad = 0;
		// Cargar jugadores
		for (int i = 0; i < pJugador; i++) {
			cantidad++;
			Jugador jugador = new Jugador(pPokemon, cantidad);
			ListaJugadores.getListaJugadores().añadirJugador(jugador);
			setChanged();
			notifyObservers(
					new Object[] { Integer.valueOf(cantidad - 1), jugador.getNombre(), Integer.valueOf(pPokemon) });
		}
		// Cargar NPCs
		for (int j = 0; j < pNPC; j++) {
			cantidad++;
			NPC npc = new NPC(pPokemon, cantidad);
			ListaJugadores.getListaJugadores().añadirJugador(npc);
			setChanged();
			notifyObservers(new Object[] { Integer.valueOf(cantidad - 1), npc.getNombre(), Integer.valueOf(pPokemon) });
		}
	}

	// Iniciar partida
	public void iniciarJuego() {
		TimerTask timer = new TimerTask() {
			public void run() {
				ListaJugadores.getListaJugadores().turno();
			}
		};
		this.temporizador = new Timer();
		this.temporizador.scheduleAtFixedRate(timer, 0L, 2000);
	}

	// Parar partida
	public void pararJuego() {
		this.temporizador.cancel();
		this.temporizador.purge();
	}
}
