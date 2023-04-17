package Modelo.Evolucion;

public class Colt implements InterfazEvolucion{
	private int evolucion = 1;
	private int bonoAtaque = 5;
	private int bonoDefensa = 3;
	
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
