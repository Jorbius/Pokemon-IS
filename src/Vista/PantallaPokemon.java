package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;

import Modelo.ControladorPartida;
import Modelo.ListaJugadores;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class PantallaPokemon extends JPanel implements Observer {
	private JPanel panelVida;
	private JProgressBar barraVida;
	private JLabel labelPokemon;
	private Controler controler = null;
	private int idJugador;
	private int idPokemon;
	private JTextArea textArea;
	private String stats = "";
	private boolean derrotado = false;
	private String foto;
	private Random random = new Random();

	public PantallaPokemon(int pIdJugador, int pIdPokemon) {
		this.idJugador = pIdJugador;
		this.idPokemon = pIdPokemon;
		setLayout(new BorderLayout(0, 0));
		add(getPanelVida(), BorderLayout.NORTH);
		add(getLabelPokemon(), BorderLayout.CENTER);
		add(getTextArea(), BorderLayout.WEST);
		addMouseListener(getControler());

	}

	private JPanel getPanelVida() {
		if (panelVida == null) {
			panelVida = new JPanel();
			panelVida.setLayout(new GridLayout(1, 0, 0, 0));
			panelVida.add(getBarraVida());
		}
		return panelVida;
	}

	private JProgressBar getBarraVida() {
		if (barraVida == null) {
			barraVida = new JProgressBar();
			barraVida.setValue(100);
			barraVida.setForeground(new Color(51, 118, 48));
			barraVida.setString("Vida");
			barraVida.setStringPainted(true);
		}
		return barraVida;
	}

	private JLabel getLabelPokemon() {
		if (labelPokemon == null) {
			labelPokemon = new JLabel();
			labelPokemon.setHorizontalAlignment(0);
			labelPokemon.addMouseListener(getControler());
		}
		return labelPokemon;
	}

	public void setLabelEnabled() {
		labelPokemon.setEnabled(true);
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.addMouseListener(getControler());
			textArea.setText("\r\n Vida: ??\r\n Ataque: ??\r\n Defensa: ??");
		}
		return textArea;
	}

	public boolean Derrotado() {
		return this.derrotado;
	}

	private class Controler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(PantallaPokemon.this.labelPokemon) && PantallaPokemon.this.labelPokemon.isEnabled()
					&& ListaJugadores.getListaJugadores().getPosicionJugador(PantallaPokemon.this.idJugador).getTurno()
					&& !(ListaJugadores.getListaJugadores()
							.getPosicionJugador(PantallaPokemon.this.idJugador) instanceof Modelo.NPC)) {
				ControladorPartida.getControladorPartida().setJugadorAtacante(
						ListaJugadores.getListaJugadores().getPosicionJugador(PantallaPokemon.this.idJugador));
				ControladorPartida.getControladorPartida().setPokemonAtacante(
						ListaJugadores.getListaJugadores().getPosicionJugador(PantallaPokemon.this.idJugador)
								.getListaPokemons().getPosicionPokemon(PantallaPokemon.this.idPokemon));
				PantallaPokemon.this.labelPokemon.setEnabled(false);
			} else {
				ControladorPartida.getControladorPartida().setJugadorDefensor(
						ListaJugadores.getListaJugadores().getPosicionJugador(PantallaPokemon.this.idJugador));
				ControladorPartida.getControladorPartida().setPokemonDefensor(
						ListaJugadores.getListaJugadores().getPosicionJugador(PantallaPokemon.this.idJugador)
								.getListaPokemons().getPosicionPokemon(PantallaPokemon.this.idPokemon));
				ControladorPartida.getControladorPartida().atacar();
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	private Controler getControler() {
		if (this.controler == null) {
			this.controler = new Controler();
		}
		return this.controler;
	}

	public void update(Observable arg0, Object arg1) {
		String[] datos = (String[]) arg1;
		int vida = (int) (100.0F * Float.parseFloat(datos[2]) / Integer.parseInt(datos[3]));
		barraVida.setValue(vida);
		if (vida <= 45) {
			barraVida.setForeground(Color.YELLOW);
		}
		if (vida <= 15) {
			barraVida.setForeground(Color.RED);
		}
		if (Integer.parseInt(datos[2]) >= 1) {
			this.textArea.setForeground(Color.BLACK);
		} else {
			this.derrotado = true;
			this.textArea.setForeground(Color.WHITE);
			this.labelPokemon.setEnabled(false);
		}
		this.stats = "\n Ataque: " + datos[0] + "\n Defensa: " + datos[1] + "\n Vida: " + datos[2] + "/" + datos[3];
		this.textArea.setText(this.stats);
		this.foto = CargarPokemons.getCargarPokemons().buscarTipo(String.valueOf(datos[4]) + datos[5]);
		this.labelPokemon.setIcon(new ImageIcon(PantallaPokemon.class.getResource(this.foto)));

	}
}
