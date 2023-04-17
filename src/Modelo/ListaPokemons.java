package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListaPokemons {
	private ArrayList<Pokemon> lista = new ArrayList<>();

	// Añade un pokemon a la lista
	public void añadirPokemon(Pokemon pPokemon) {
		this.lista.add(pPokemon);
	}

	// Elimina un pokemon de la lista
	public void eliminarPokemon(Pokemon pPokemon) {
		this.lista.remove(pPokemon);
	}

	// Iterador de pokemons de la lista
	private Iterator<Pokemon> getIterator() {
		return this.lista.iterator();
	}

	// Devuelve el pokemon en la posición indicada
	public Pokemon getPosicionPokemon(int pPosicion) {
		return this.lista.get(pPosicion);
	}

	// Devuelve el tamaño de la lista de pokemons
	public int getSize() {
		return this.lista.size();
	}

	// Devuelve una lista con los pokemons vivos
	public List<Pokemon> getPokemonVivos() {
		return (List<Pokemon>) this.lista.stream().filter(p -> !p.getDerrotado()).collect(Collectors.toList());
	}

	// Devuelve true si todos los pokemons están derrotados y false si queda alguno
	// vivo
	public boolean todosDerrotados() {
		return this.lista.stream().allMatch(p -> p.getDerrotado());
	}

	// Actualiza los stats de todos los pokemons de la lista
	public void actualizarPokemons() {
		Iterator<Pokemon> iterator = getIterator();
		while (iterator.hasNext()) {
			Pokemon p = iterator.next();
			p.actualizarStats();
		}
	}

}
