package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Juego;
import Modelo.ListaJugadores;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame implements Observer {

	private static PantallaPrincipal frame;
	private JPanel contentPane;
	private JPanel panelBotones;
	private JPanel panelFotos;
	private JLabel labelLogo1;
	private JLabel labelLogo2;
	private JLabel labelJugadores;
	private JTextField numJugadores;
	private JLabel labelNPCs;
	private JTextField numNPCs;
	private JLabel labelPokemons;
	private JTextField numPokemons;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton botonJugar;
	private Controler controler = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal.frame = new PantallaPrincipal();
					PantallaPrincipal.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setTitle("P0KEM0N BATTLE ARENA");
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelBotones(), BorderLayout.EAST);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
		Juego.getJuego().addObserver(this);
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
			panelBotones.add(getLabelJugadores());
			panelBotones.add(getNumJugadores());
			panelBotones.add(getLabelNPCs());
			panelBotones.add(getTextField_1());
			panelBotones.add(getLabelPokemons());
			panelBotones.add(getTextField_2());
			panelBotones.add(getPanel());
			panelBotones.add(getPanel_1_1());
			panelBotones.add(getPanel_2());
			panelBotones.add(getBotonJugar());
		}
		return panelBotones;
	}

	private JPanel getPanel_1() {
		if (panelFotos == null) {
			panelFotos = new JPanel();
			panelFotos.setLayout(new GridLayout(0, 1, 0, 0));
			panelFotos.add(getLabelLogo1());
			panelFotos.add(getLabelLogo2());
		}
		return panelFotos;
	}

	private JLabel getLabelLogo1() {
		if (labelLogo1 == null) {
			labelLogo1 = new JLabel();
			labelLogo1.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/Fotos/pokemon3.png")));
			this.labelLogo1.setHorizontalAlignment(0);
		}
		return labelLogo1;
	}

	private JLabel getLabelLogo2() {
		if (labelLogo2 == null) {
			labelLogo2 = new JLabel();
			labelLogo2.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/Fotos/logo7.jpg")));
			this.labelLogo2.setHorizontalAlignment(0);
		}
		return labelLogo2;
	}

	private JLabel getLabelJugadores() {
		if (labelJugadores == null) {
			labelJugadores = new JLabel("Jugadores");
		}
		return labelJugadores;
	}

	private JTextField getNumJugadores() {
		if (numJugadores == null) {
			numJugadores = new JTextField();
			numJugadores.setText("1");
			numJugadores.setColumns(10);
		}
		return numJugadores;
	}

	private JLabel getLabelNPCs() {
		if (labelNPCs == null) {
			labelNPCs = new JLabel("NPCs");
		}
		return labelNPCs;
	}

	private JTextField getTextField_1() {
		if (numNPCs == null) {
			numNPCs = new JTextField();
			numNPCs.setText("1");
			numNPCs.setColumns(10);
		}
		return numNPCs;
	}

	private JLabel getLabelPokemons() {
		if (labelPokemons == null) {
			labelPokemons = new JLabel("Pokemons");
		}
		return labelPokemons;
	}

	private JTextField getTextField_2() {
		if (numPokemons == null) {
			numPokemons = new JTextField();
			numPokemons.setText("3");
			numPokemons.setColumns(10);
		}
		return numPokemons;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}

	private JButton getBotonJugar() {
		if (botonJugar == null) {
			botonJugar = new JButton("Jugar");
			botonJugar.addActionListener(getControler());
		}
		return botonJugar;
	}

	private Controler getControler() {
		if (this.controler == null) {
			this.controler = new Controler();
		}
		return this.controler;
	}

	private class Controler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(PantallaPrincipal.this.botonJugar)) {
				Juego.getJuego().cargarJugadores(Integer.parseInt(PantallaPrincipal.this.numJugadores.getText()),
						Integer.parseInt(PantallaPrincipal.this.numNPCs.getText()),
						Integer.parseInt(PantallaPrincipal.this.numPokemons.getText()));
				Juego.getJuego().iniciarJuego();
				PantallaPrincipal.frame.setVisible(false);
			}
		}
	}

	public void update(Observable arg0, Object arg1) {
		Object[] datos = (Object[]) arg1;
		PantallaJugador pj = new PantallaJugador(((Integer) datos[0]).intValue(), (String) datos[1],
				((Integer) datos[2]).intValue());
		String nombre = (String) datos[1];
		ListaJugadores.getListaJugadores().buscarJugador(nombre).addObserver(pj);
		for (int i = 0; i < Integer.parseInt(this.numPokemons.getText()); i++) {
			ListaJugadores.getListaJugadores().buscarJugador(nombre).getListaPokemons().getPosicionPokemon(i)
					.addObserver((Observer) pj.getPanelPokemon().getComponent(i));
			ListaJugadores.getListaJugadores().buscarJugador(nombre).actualizarPokemons();
		}
		pj.setVisible(true);
	}
}
