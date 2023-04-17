package Modelo;

public class ControladorPartida {
	private static ControladorPartida controladorPartida = null;
	private Jugador jAtacante;
	private Jugador jDefensor;
	private Pokemon pAtacante;
	private Pokemon pDefensor;

	// Iniciar instancia única de la lista de jugadores si no hay una
	public static ControladorPartida getControladorPartida() {
		if (controladorPartida == null) {
			controladorPartida = new ControladorPartida();
		}
		return controladorPartida;
	}

	// Devuelve el jugador atacante
	public Jugador getJugadorAtacante() {
		return this.jAtacante;
	}

	// Cambia el jugador atacante al indicado
	public void setJugadorAtacante(Jugador pJAtacante) {
		this.jAtacante = pJAtacante;
	}

	// Devuelve el pokemon atacante
	public Pokemon getPokemonAtacante() {
		return this.pAtacante;
	}

	// Cambia el pokemon atacante al indicado
	public void setPokemonAtacante(Pokemon pPAtacante) {
		this.pAtacante = pPAtacante;
	}

	// Devuelve el jugador defensor
	public Jugador getJugadorDefensor() {
		return this.jDefensor;
	}

	// Cambia el jugador defensor al indicado
	public void setJugadorDefensor(Jugador pJDefensor) {
		this.jDefensor = pJDefensor;
	}

	// Devuelve el pokemon defensor
	public Pokemon getPokemonDefensor() {
		return this.pDefensor;
	}

	// Cambia el pokemon defensor al indicado
	public void setPokemonDefensor(Pokemon pPDefensor) {
		this.pDefensor = pPDefensor;
	}

	// Reseta los jugadores y pokemons atacantes y defensores
	private void resetear() {
		this.jAtacante = null;
		this.pAtacante = null;
		this.jDefensor = null;
		this.pDefensor = null;
	}

	// Devuelve true si todo está preparado y ataca al pokemon defensor con el
	// ataque del atacante
	// y resetea todos los atacantes y defensores, si todos los pokemons estan
	// derrotados,
	// cambia el estado del jugador a derrotado y si solo queda 1 jugador lo pone
	// como ganador, para la partida
	public boolean atacar() {
		boolean todoListo = true;
		if (this.jAtacante != null && this.pAtacante != null && this.jDefensor != null && this.pDefensor != null) {
			if (!pAtacante.getDerrotado()) {
				this.pDefensor.atacar(this.pAtacante.getAtaque(), this.pAtacante.getTipo());
			}
			if (this.jDefensor.getListaPokemons().todosDerrotados()) {
				this.jDefensor.setDerrotado(true);
			}
			this.pAtacante.sinFuria();
			if (ListaJugadores.getListaJugadores().ganador()) {
				this.jAtacante.setDerrotado(false);
				Juego.getJuego().pararJuego();
			}
			resetear();
		} else {
			todoListo = false;
		}
		return todoListo;
	}
}
