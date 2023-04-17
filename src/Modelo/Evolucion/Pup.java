package Modelo.Evolucion;

public class Pup implements InterfazEvolucion{
	private int evolucion = 0;
	private int bonoAtaque = 0;
	private int bonoDefensa = 0;
	
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
