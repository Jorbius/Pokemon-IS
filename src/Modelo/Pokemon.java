package Modelo;

import java.util.Observable;
import java.util.Random;

import Modelo.Evolucion.Colt;
import Modelo.Evolucion.Furia;
import Modelo.Evolucion.InterfazEvolucion;
import Modelo.Evolucion.Max;
import Modelo.Evolucion.Pup;
import Modelo.Tipos.Tipo;

public abstract class Pokemon extends Observable {
	private int ataque;
	private int defensa;
	private int vida;
	private int vidaMax;
	protected Tipo tipo;
	private int furiaMaxima;
	private int furiaActual;
	private InterfazEvolucion evolucion = (InterfazEvolucion)new Pup();
	private int posicion;
	private boolean derrotado = false; // True = derrotado, False = vivo
	protected Random random = new Random();

	// Constructora
	public Pokemon(int pPosicion) {
		this.ataque = 11 + this.random.nextInt(7) + 1;
		this.defensa = 3 + this.random.nextInt(3) + 1;
		this.vida = 200 + this.random.nextInt(21) + 1;
		this.vidaMax = this.vida;
		this.furiaMaxima = this.random.nextInt(3)+4;
		this.furiaActual = 0;
		this.posicion = pPosicion;
	}

	// Devuelve el ataque del pokemon
	public int getAtaque() {
		return this.ataque + this.evolucion.aumentoAtaque();
	}

	// Devuelve la defensa del pokemon
	public int getDefensa() {
		return this.defensa + this.evolucion.aumentoDefensa();
	}

	// Devuelve la vida actual del pokemon
	public int getVida() {
		return this.vida;
	}

	// Devuelve la vida maxima del pokemon
	public int getVidaMax() {
		return this.vidaMax;
	}
	
	// Devuelve el tipo del pokemon
	public Tipo getTipo() {
		return this.tipo;
	}
	
	// Hace evolucionar al pokemon
	public void evolucionar(InterfazEvolucion pEvolucion) {
		this.evolucion = pEvolucion;
	}
	
	// Devuelve la posicion
	public int getPosicion() {
		return this.posicion;
	}

	// Devuelve si el pokemon ha sido derrotado o no
	public boolean getDerrotado() {
		return this.derrotado;
	}

	// Cambia el estado del pokemon a derrotado
	public void setDerrotado(boolean derrotado) {
		this.derrotado = derrotado;
	}
	
	protected abstract int aumentarAtaque(Tipo pTipo);

	// Calcula el daño que le inflinge un pokemon a otro y le resta vida,
	// si la vida llega a 0, es derrotado
	public int atacar(int pAtaque, Tipo pTipo) {
		int tipoA = aumentarAtaque(pTipo);
		int daño = tipoA * pAtaque - getDefensa();
		if (daño < 0) {
			daño = 0;
		}
		this.vida -= daño;
		if (this.vida < 1) {
			derrotado = true;
		}
		if (this.furiaActual < this.furiaMaxima) {
			this.furiaActual++;
		} else {
			this.furiaActual = this.furiaMaxima;
		}
		estado();
		actualizarStats();
		return this.vida;
	}
	
	// Comprueba el estado del pokemon
	public void estado() {
		if (this.vida > this.vidaMax / 2) {
			evolucionar((InterfazEvolucion)new Pup());
		}
		if (this.vida <= this.vidaMax / 2) {
			evolucionar((InterfazEvolucion)new Colt());
		}
		if (this.vida <= this.vidaMax / 4) {
			evolucionar((InterfazEvolucion)new Max());
		}
		if (this.furiaActual == this.furiaMaxima) {
			evolucionar((InterfazEvolucion)new Furia());
		}
	}
	
	// Pone la furia del pokemon a 0
	public void sinFuria() {
		if (this.evolucion instanceof Furia) {
			this.furiaActual = 0;
			estado();
			actualizarStats();
		}
	}

	// Notifica a los observers que los campos han sido actualizados
	public void actualizarStats() {
		setChanged();
		notifyObservers(new String[] { String.valueOf(Integer.toString(this.ataque))+"+"+ Integer.toString(this.evolucion.aumentoAtaque()), String.valueOf(Integer.toString(this.defensa))+"+"+ Integer.toString(this.evolucion.aumentoDefensa()), Integer.toString(this.vida), Integer.toString(this.vidaMax), this.tipo.toString(), Integer.toString(this.evolucion.numEvolucion()), Integer.toString(this.furiaMaxima), Integer.toString(this.furiaActual) });
	}

}
