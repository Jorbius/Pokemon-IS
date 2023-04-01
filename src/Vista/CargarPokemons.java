package Vista;

import java.util.HashMap;
import java.util.Random;

public class CargarPokemons {
	//Clase singleton
	private static CargarPokemons cargarPokemos = null;
	// Almacena los nombres de los pokemons junto con la ruta de la imagen
	private HashMap<String, String> pokemons;
	//Variable ramdon para despues elegir aleatoriamente el pokemon
	private Random random = new Random();
	
	public static CargarPokemons getCargarPokemons() {
		if(cargarPokemos == null) {
			cargarPokemos = new CargarPokemons();
		}
		return cargarPokemos;
	}
	
	//Insertar los pokemons
	private CargarPokemons() {
		this.pokemons = new HashMap<>();
		this.pokemons.put("NORMAL0", "/fotos/abra.png");
		//this.pokemons.put("", "/fotos/alakazam.png");
		//this.pokemons.put("", "/fotos/blastoise.png");
		this.pokemons.put("NORMAL1", "/fotos/bulbasaur.png");
		//this.pokemons.put("", "/fotos/butterfree.png");
		this.pokemons.put("NORMAL2", "/fotos/caterpie.png");
		//this.pokemons.put("", "/fotos/charizard.png");
		this.pokemons.put("NORMAL3", "/fotos/charmander.png");
		//this.pokemons.put("", "/fotos/charmeleon.png");
		//this.pokemons.put("", "/fotos/dragonair.png");
		//this.pokemons.put("", "/fotos/dragonite.png");
		this.pokemons.put("NORMAL4", "/fotos/dratini.png");
		this.pokemons.put("NORMAL5", "/fotos/gastly.png");
		//this.pokemons.put("", "/fotos/gengar.png");
		this.pokemons.put("NORMAL6", "/fotos/geodude.png");
		//this.pokemons.put("", "/fotos/golem.png");
		//this.pokemons.put("", "/fotos/graveler.png");
		//this.pokemons.put("", "/fotos/haunter.png");
		//this.pokemons.put("", "/fotos/ivysaur.png");
		//this.pokemons.put("", "/fotos/kadabra.png");
		//this.pokemons.put("", "/fotos/machamp.png");
		//this.pokemons.put("", "/fotos/machoke.png");
		this.pokemons.put("NORMAL7", "/fotos/machop.png");
		//this.pokemons.put("", "/fotos/metapod.png");
		//this.pokemons.put("", "/fotos/pidgeot.png");
		//this.pokemons.put("", "/fotos/pidgeotto.png");
		this.pokemons.put("NORMAL8", "/fotos/pidgey.png");
		this.pokemons.put("NORMAL9", "/fotos/pikachu.png");
		//this.pokemons.put("", "/fotos/raichu.png");
		//this.pokemons.put("", "/fotos/raichu2.png");
		this.pokemons.put("NORMAL10", "/fotos/squirtle.png");
		this.pokemons.put("Entrenador0", "/fotos/trainer0.png");
		this.pokemons.put("Entrenador1", "/fotos/trainer1.png");
		this.pokemons.put("Entrenador2", "/fotos/trainer2.png");
		this.pokemons.put("Entrenador3", "/fotos/trainer3.png");
		this.pokemons.put("Entrenador4", "/fotos/trainer4.png");
		this.pokemons.put("Entrenador5", "/fotos/trainer5.png");
		//this.pokemons.put("", "/fotos/venusaur.png");
		//this.pokemons.put("", "/fotos/wartortle.png");
	}

	//El méteodo devuelve una ruta de la imagen aleatoria de uno de los pokemons.
	//Se usa un objeto Random para elegir una ruta de archivo aleatoria de entre 
	//todas las rutas de archivo almacenadas en el mapa.
	public String getRandom() {
		Object[] values = this.pokemons.values().toArray();
		String random = (String)values[this.random.nextInt(values.length)];
		return random;
	}
	public String buscarTipo(String tipo) {
		return this.pokemons.get(tipo);
	}
}
