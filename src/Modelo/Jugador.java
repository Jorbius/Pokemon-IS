package Modelo;

import java.util.Observable;

public class Jugador extends Observable{
	private String nombre;
	private ListaPokemons lista = new ListaPokemons();
	private boolean turno = false; // True = turno activado, False = esperando turno
	private boolean derrotado = false; // True = derrotado, False = vivo
	
	// Constructora del jugador
	public Jugador(int pPokemon, int cant) {
		this.nombre = "Jugador " + cant;
		for (int i = 0; i < pPokemon; i++) {
			Pokemon pokemon = new Pokemon(i);
			this.lista.añadirPokemon(pokemon);
		}
	}
	// Devuelve el nombre del jugador
	public String getNombre() {
		return this.nombre;
	}
	// Cambia el nombre del jugador
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	// Devuelve la lista de pokemons del jugador
	public ListaPokemons getListaPokemons() {
		return this.lista;
	}
	public void actualizarPokemons() {
		this.lista.actualizarPokemons();
	}
	public int getTamañoListaPokemons() {
		return getListaPokemons().getSize();
	}
	// Devuelve el turno del jugador
	public boolean getTurno() {
		return this.turno;
	}
	// Cambia el turno del jugador
	public void setTurno(boolean pTurno) {
		this.turno = pTurno;
		setChanged();
		notifyObservers(new Object[] { Boolean.valueOf(this.turno) });
	}
	// Devuelve el estado del jugador
	public boolean getDerrotado() {
		return this.derrotado;
	}
	// Cambia el estado del jugador
	public void setDerrotado(boolean pEstado) {
		this.derrotado = pEstado;
		setChanged();
		notifyObservers(new Object[] { Boolean.valueOf(this.turno) });
	}
	public void jugar() {
		
	}
}
