package Vista;

import java.util.HashMap;
import java.util.Random;

public class CargarPokemons {
	// Clase singleton
	private static CargarPokemons cargarPokemos = null;
	// Almacena los nombres de los pokemons junto con la ruta de la imagen
	private HashMap<String, String> pokemons;
	// Variable ramdon para despues elegir aleatoriamente el pokemon
	private Random random = new Random();

	public static CargarPokemons getCargarPokemons() {
		if (cargarPokemos == null) {
			cargarPokemos = new CargarPokemons();
		}
		return cargarPokemos;
	}

	// Insertar los pokemons
	private CargarPokemons() {
		this.pokemons = new HashMap<>();
		this.pokemons.put("PSIQUICO0", "/Fotos/abra.png");
		this.pokemons.put("PSIQUICO2", "/Fotos/alakazam.png");
		this.pokemons.put("AGUA2", "/Fotos/blastoise.png");
		this.pokemons.put("PLANTA0", "/Fotos/bulbasaur.png");
		this.pokemons.put("BICHO2", "/Fotos/butterfree.png");
		this.pokemons.put("BICHO0", "/Fotos/caterpie.png");
		this.pokemons.put("FUEGO2", "/Fotos/charizard.png");
		this.pokemons.put("FUEGO0", "/Fotos/charmander.png");
		this.pokemons.put("FUEGO2", "/Fotos/charmeleon.png");
		this.pokemons.put("DRAGON1", "/Fotos/dragonair.png");
		this.pokemons.put("DRAGON2", "/Fotos/dragonite.png");
		this.pokemons.put("DRAGON0", "/Fotos/dratini.png");
		this.pokemons.put("FANTASMA0", "/Fotos/gastly.png");
		this.pokemons.put("FANTASMA2", "/Fotos/gengar.png");
		this.pokemons.put("ROCA0", "/Fotos/geodude.png");
		this.pokemons.put("ROCA2", "/Fotos/golem.png");
		this.pokemons.put("ROCA1", "/Fotos/graveler.png");
		this.pokemons.put("FANTASMA1", "/Fotos/haunter.png");
		this.pokemons.put("PLANTA1", "/Fotos/ivysaur.png");
		this.pokemons.put("PSIQUICO1", "/Fotos/kadabra.png");
		this.pokemons.put("LUCHA2", "/Fotos/machamp.png");
		this.pokemons.put("LUCHA1", "/Fotos/machoke.png");
		this.pokemons.put("LUCHA0", "/Fotos/machop.png");
		this.pokemons.put("BICHO1", "/Fotos/metapod.png");
		this.pokemons.put("VOLADOR2", "/Fotos/pidgeot.png");
		this.pokemons.put("VOLADOR1", "/Fotos/pidgeotto.png");
		this.pokemons.put("VOLADOR0", "/Fotos/pidgey.png");
		this.pokemons.put("ELECTRICO0", "/Fotos/pikachu.png");
		this.pokemons.put("ELECTRICO1", "/Fotos/raichu.png");
		this.pokemons.put("ELECTRICO2", "/Fotos/raichu2.png");
		this.pokemons.put("AGUA0", "/Fotos/squirtle.png");
		this.pokemons.put("Entrenador0", "/Fotos/trainer0.png");
		this.pokemons.put("Entrenador1", "/Fotos/trainer1.png");
		this.pokemons.put("Entrenador2", "/Fotos/trainer2.png");
		this.pokemons.put("Entrenador3", "/Fotos/trainer3.png");
		this.pokemons.put("Entrenador4", "/Fotos/trainer4.png");
		this.pokemons.put("Entrenador5", "/Fotos/trainer5.png");
		this.pokemons.put("PLANTA2", "/Fotos/venusaur.png");
		this.pokemons.put("AGUA1", "/Fotos/wartortle.png");
	}

	// El méteodo devuelve una ruta de la imagen aleatoria de uno de los pokemons.
	// Se usa un objeto Random para elegir una ruta de archivo aleatoria de entre
	// todas las rutas de archivo almacenadas en el mapa.
	public String getRandom() {
		Object[] values = this.pokemons.values().toArray();
		String random = (String) values[this.random.nextInt(values.length)];
		return random;
	}

	public String buscarTipo(String tipo) {
		return this.pokemons.get(tipo);
	}
}
