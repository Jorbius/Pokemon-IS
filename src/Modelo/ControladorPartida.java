package Modelo;

public class ControladorPartida {
	private static ControladorPartida controladorPartida = null;
	private Jugador jAtacante;
	private Jugador jDefensor;
	private Pokemon pAtacante;
	private Pokemon pDefensor;
	
	public static ControladorPartida getControladorPartida() {
		if (controladorPartida == null) {
			controladorPartida = new ControladorPartida();
		}
		return controladorPartida;
	}
	public Jugador getJugadorAtacante() {
		return this.jAtacante;
	}
	public void setJugadorAtacante(Jugador pJAtacante) {
		this.jAtacante = pJAtacante;
	}
	public Pokemon getPokemonAtacante() {
		return this.pAtacante;
	}
	public void setPokemonAtacante(Pokemon pPAtacante) {
		this.pAtacante = pPAtacante;
	}
	public Jugador getJugadorDefensor() {
		return this.jDefensor;
	}
	public void setJugadorDefensor(Jugador pJDefensor) {
		this.jDefensor = pJDefensor;
	}
	public Pokemon getPokemonDefensor() {
		return this.pDefensor;
	}
	public void setPokemonDefensor(Pokemon pPDefensor) {
		this.pDefensor = pPDefensor;
	}
	private void resetear() {
		this.jAtacante = null;
		this.pAtacante = null;
		this.jDefensor = null;
		this.pDefensor = null;
	}
	public boolean atacar() {
		boolean todoListo = true;
		if (this.jAtacante != null && this.pAtacante != null && this.jDefensor != null && this.pDefensor != null){
			this.pDefensor.atacar(this.pAtacante.getAtaque());
			if (this.jDefensor.getListaPokemons().todosDerrotados()) {
				this.jDefensor.setDerrotado(true);
			}
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
