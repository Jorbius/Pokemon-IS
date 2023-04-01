package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListaPokemons {
	private ArrayList<Pokemon> lista = new ArrayList<>();
	
	public void añadirPokemon(Pokemon pPokemon) {
		this.lista.add(pPokemon);
	}
	public void eliminarPokemon(Pokemon pPokemon) {
		this.lista.remove(pPokemon);
	}
	private Iterator<Pokemon> getIterator() {
		return this.lista.iterator();
	}
	public Pokemon getPosicionPokemon(int pPosicion) {
		return this.lista.get(pPosicion);
	}
	public int getSize() {
		return this.lista.size();
	}
	public List<Pokemon> getPokemonVivos() {
		return (List<Pokemon>)this.lista.stream().filter(p -> !p.getDerrotado()).collect(Collectors.toList());
	}
	public boolean todosDerrotados() {
		return this.lista.stream().allMatch(p -> p.getDerrotado());
	}
	public void actualizarPokemons() {
		Iterator<Pokemon> iterator = getIterator();
		while(iterator.hasNext()) {
			Pokemon p = iterator.next();
			p.actualizarStats();
		}
	}


}
