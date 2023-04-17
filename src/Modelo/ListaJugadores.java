package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;

public class ListaJugadores {
	private static ListaJugadores listaJugadores = null;
	private ArrayList<Jugador> lista = new ArrayList<>();

	// Iniciar instancia única de la lista de jugadores si no hay una
	public static ListaJugadores getListaJugadores() {
		if (listaJugadores == null) {
			listaJugadores = new ListaJugadores();
		}
		return listaJugadores;
	}

	// Añade un jugador a la lista
	public void añadirJugador(Jugador pJugador) {
		this.lista.add(pJugador);
	}

	// Eliminia un jugador de la lista
	public void eliminarJugador(Jugador pJugador) {
		this.lista.remove(pJugador);
	}

	// Iterador de jugadores de la lista
	public Iterator<Jugador> getIterator() {
		return this.lista.iterator();
	}

	// Devuelve el jugador buscado mediante su nombre
	public Jugador buscarJugador(String pNombre) {
		Iterator<Jugador> iterator = getIterator();
		boolean encontrado = true;
		Jugador j = null;
		while (iterator.hasNext() && encontrado) {
			j = iterator.next();
			if (j.getNombre().equals(pNombre)) {
				encontrado = false;
			}
		}
		return j;
	}

	// Devuelve el jugador buscado mediante la posición en la lista
	public Jugador getPosicionJugador(int i) {
		return this.lista.get(i);
	}

	// Devuelve un jugador aleatorio de la lista
	// que no sea el mismo introducido y no esté derrotado
	public Jugador jugadorRandom(Jugador pJugador) {
		boolean encontrar = false;
		Jugador j = null;
		while (!encontrar) {
			Random random = new Random();
			j = this.lista.get(random.nextInt(this.lista.size()));
			if (!j.equals(pJugador) && !j.getDerrotado()) {
				encontrar = true;
			}
		}
		return j;
	}

	// Devuelve True si solo queda un jugador y todos los demas
	// han sido derrotados y es el ganador
	public boolean ganador() {
		return ((int) this.lista.stream().filter(j -> j.getDerrotado()).count() == this.lista.size() - 1);
	}

	// Cambia de turno al jugador actual y hace que juegue,
	// si hay un ganador se acaba el juego
	public boolean turno() {
		boolean finTurno = false;
		Iterator<Jugador> iterator = getIterator();
		while (iterator.hasNext()) {
			Jugador j = iterator.next();
			j.setTurno(false);
		}
		Jugador actual = jugadorRandom(null);
		actual.setTurno(true);
		actual.jugar();
		if (!(actual instanceof NPC)) {
			Juego.getJuego().pararJuego();
		}
		if (ganador()) {
			System.out.println((new StringBuilder()).append(this.lista.stream().filter(j -> !j.getDerrotado())
					.map(j -> j.getNombre()).collect(Collectors.toList())).append(" es el ganador!").toString());
			finTurno = true;
			actual.setDerrotado(false);
			Juego.getJuego().pararJuego();
		}
		return finTurno;
	}
}
