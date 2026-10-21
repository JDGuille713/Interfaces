
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Opciones");
		menuBar.add(menu1);
		
		JMenu menu2 = new JMenu("Tamaño de la ventana");
		menu1.add(menu2);
		
		JMenuItem mi1 = new JMenuItem("640*480\r\n");
		mi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(640,480);
			}
		});
		menu2.add(mi1);
		
		JMenuItem mi2 = new JMenuItem("1024*768");
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(1024,480);
			}
		});
		menu2.add(mi2);
		
		JMenu menu3 = new JMenu("Color de fondo");
		menu1.add(menu3);
		
		JMenuItem mi3 = new JMenuItem("Rojo");
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.RED);
			}
		});
		mi3.setOpaque(true);
		mi3.setForeground(Color.BLACK);
		menu3.add(mi3);
		
		JMenuItem mi4 = new JMenuItem("Verde");
		mi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		mi4.setForeground(Color.BLACK);
		mi4.setOpaque(true);
		menu3.add(mi4);
		
		JMenuItem miSalir = new JMenuItem("Salir");
		miSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, 
						"¿Seguro que desea cerrar?",
						"Salir",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		
		JMenuItem miRestaurar = new JMenuItem("Restaurar");
		miRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.WHITE);
				setSize(500, 350);
			}
		});
		menu1.add(miRestaurar);
		menu1.add(miSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
}
