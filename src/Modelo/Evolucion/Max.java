package Modelo.Evolucion;

public class Max implements InterfazEvolucion{
	private int evolucion = 2;
	private int bonoAtaque = 7;
	private int bonoDefensa = 5;
	
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
