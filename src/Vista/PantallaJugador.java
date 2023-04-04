package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Juego;
import Modelo.ListaJugadores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PantallaJugador extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel panelPokemon;
	private JPanel panelJugador;
	private int idJugador;
	private String nombre;
	private static int xPos = 200;
	private static int yPos = 200;
	private JLabel labelTurno;
	private JLabel labelFoto;
	private Random random = new Random();
	private ArrayList<PantallaPokemon> listaPokemons = new ArrayList<>();
	private Controler controler = null;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJugador frame = new PantallaJugador(0, "Jugador", 3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaJugador(int pIdJugador, String pNombre, int pNumPokemons) {
		this.idJugador = pIdJugador;
		this.nombre = pNombre;
		setTitle(pNombre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(xPos, yPos, 80 + pNumPokemons * 150, 450);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelPokemon(), BorderLayout.CENTER);
		contentPane.add(getPanelJugador(), BorderLayout.WEST);
		getPanelPokemon().setLayout(new GridLayout(0, 1, 1, 1));
		for (int i = 0; i < pNumPokemons; i++) {
			PantallaPokemon pp = new PantallaPokemon(pIdJugador, i);
			getPanelPokemon().add(pp);
			this.listaPokemons.add(pp);
		}
	}

	JPanel getPanelPokemon() {
		if (panelPokemon == null) {
			panelPokemon = new JPanel();
			panelPokemon.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return panelPokemon;
	}
	private JPanel getPanelJugador() {
		if (panelJugador == null) {
			panelJugador = new JPanel();
			panelJugador.setLayout(new BorderLayout(0, 0));
			panelJugador.add(getLabelTurno(), BorderLayout.NORTH);
			panelJugador.add(getLabelFoto(), BorderLayout.CENTER);
		}
		return panelJugador;
	}
	private JLabel getLabelTurno() {
		if (this.labelTurno == null) {
			this.labelTurno = new JLabel("Turno");
			this.labelTurno.setHorizontalAlignment(SwingConstants.CENTER);
			if (this.nombre.matches("NPC (.*)")) {
				this.labelTurno.setBorder(BorderFactory.createRaisedBevelBorder());
			}
			this.labelTurno.addMouseListener(getControler());
		}
		return labelTurno;
	}
	private JLabel getLabelFoto() {
		if (labelFoto == null) {
			labelFoto = new JLabel();
			String foto = CargarPokemons.getCargarPokemons().buscarTipo("Entrenador"+this.random.nextInt(6));
			labelFoto.setIcon(new ImageIcon(PantallaPokemon.class.getResource(foto)));
		}
		return labelFoto;
	}
	public String getNombreJugador() {
		return this.nombre;
	}
	public int getIdJugador() {
		return this.idJugador;
	}
	private class Controler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (ListaJugadores.getListaJugadores().getPosicionJugador(PantallaJugador.this.idJugador).getTurno() && !(ListaJugadores.getListaJugadores().getPosicionJugador(PantallaJugador.this.idJugador) instanceof Modelo.NPC)) {
				Juego.getJuego().iniciarJuego();
				PantallaJugador.this.listaPokemons.stream().filter(p -> !p.Derrotado()).forEach(p -> p.setLabelEnabled());
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
		if(this.controler == null) {
			this.controler = new Controler();
		}
		return this.controler;
	}
	public void update(Observable arg0, Object arg1) {
		Object[] datos = (Object[])arg1;
		if(((Boolean)datos[0]).booleanValue()) {
			if (ListaJugadores.getListaJugadores().ganador()) {
				labelTurno.setText(" GANADOR ");
			} else {
				labelTurno.setText(" Es tu turno ");
			}
			labelTurno.setBackground(Color.GREEN);
			labelTurno.setForeground(Color.BLACK);
			this.listaPokemons.stream().filter(p -> !p.Derrotado()).forEach(p -> p.setLabelEnabled());
		} else {
			if(ListaJugadores.getListaJugadores().getPosicionJugador(this.idJugador).getDerrotado() == true) {
				labelTurno.setText(" DERROTADO ");
				labelTurno.setBackground(Color.RED);
			} else {
				labelTurno.setText(" Espera ");
				labelTurno.setBackground(Color.YELLOW);
			}
			labelTurno.setForeground(Color.WHITE);
		}
	}
}
