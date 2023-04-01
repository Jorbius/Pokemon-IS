package Modelo;

import java.util.Observable;
import java.util.Random;

public class Pokemon extends Observable{
	private int ataque;
	private int defensa;
	private int vida;
	private int vidaMax;
	private int posicion;
	private boolean derrotado = false; // True = derrotado, False = vivo
	protected Random random = new Random();
	private int random1;
	
	// Constructora
	public Pokemon(int pPosicion) {
		this.ataque = 11 + this.random.nextInt(7)+1;
		this.defensa = 3 + this.random.nextInt(3)+1;
		this.vida = 200 + this.random.nextInt(21)+1;
		this.vidaMax = this.vida;
		this.posicion = pPosicion;
		this.random1  = this.random.nextInt(11);
	}
	// Devuelve el ataque del pokemon
	public int getAtaque() {
		return this.ataque;
	}
	// Devuelve la defensa del pokemon
	public int getDefensa() {
		return this.defensa;
	}
	// Devuelve la vida actual del pokemon
	public int getVida() {
		return this.vida;
	}
	// Devuelve la vida maxima del pokemon
	public int getVidaMax() {
		return this.vidaMax;
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
	// Calcula el daño que le inflinge un pokemon a otro y le resta vida,
	// si la vida llega a 0, es derrotado
	public int atacar(int pAtaque) {
		int daño = pAtaque - getDefensa();
		if (daño < 0) {
			daño = 0;
		}
		this.vida-=daño;
		if (this.vida < 1) {
			derrotado = true;
		}
		actualizarStats();
		return this.vida;
	}
	// Notifica a los observers que los campos han sido actualizados
	public void actualizarStats() {
		setChanged();
		notifyObservers( new String[] { String.valueOf(Integer.toString(this.ataque)), String.valueOf(Integer.toString(this.defensa)), Integer.toString(this.vida), Integer.toString(this.vidaMax), "NORMAL" , Integer.toString(this.random1)});
	}
	
}
