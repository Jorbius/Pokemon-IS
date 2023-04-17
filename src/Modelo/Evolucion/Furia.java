package Modelo.Evolucion;

public class Furia implements InterfazEvolucion{
	private int evolucion = 3;
	private int bonoAtaque = 100;
	private int bonoDefensa = 100;
	
	public int numEvolucion() {
		return this.evolucion;
	}
	public int aumentoAtaque() {
		return this.bonoAtaque;
	}
	public int aumentoDefensa() {
		return this.bonoDefensa;
	}
}
