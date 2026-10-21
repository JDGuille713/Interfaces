
import java.awt.EventQueue;
 
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

import javax.swing.JLabel;

import javax.swing.JTextArea;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
 
public class Ejercicio6 extends JFrame {
 
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtVocales;

	private JTextField txtConsonantes;

	private JTextField txtEspeciales;

	private JTextField txtResto;

	private JTextField txtNumeros;

	private JTextField txtTotal;
	
	private GestorFichero gFichero;
 
	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Ejercicio6 frame = new Ejercicio6();

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

	public Ejercicio6() {
		gFichero = new GestorFichero();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		txtVocales = new JTextField();

		txtVocales.setBounds(330, 21, 96, 20);

		contentPane.add(txtVocales);

		txtVocales.setColumns(10);

		txtConsonantes = new JTextField();

		txtConsonantes.setBounds(330, 50, 96, 20);

		contentPane.add(txtConsonantes);

		txtConsonantes.setColumns(10);

		txtEspeciales = new JTextField();

		txtEspeciales.setBounds(330, 81, 96, 20);

		contentPane.add(txtEspeciales);

		txtEspeciales.setColumns(10);

		txtResto = new JTextField();

		txtResto.setBounds(330, 112, 96, 20);

		contentPane.add(txtResto);

		txtResto.setColumns(10);

		txtNumeros = new JTextField();

		txtNumeros.setBounds(330, 143, 96, 20);

		contentPane.add(txtNumeros);

		txtNumeros.setColumns(10);

		txtTotal = new JTextField();

		txtTotal.setBounds(330, 174, 96, 20);

		contentPane.add(txtTotal);

		txtTotal.setColumns(10);

		JLabel lblVocales = new JLabel("VOCALES");
		lblVocales.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVocales.setHorizontalAlignment(SwingConstants.RIGHT);

		lblVocales.setBounds(253, 24, 67, 14);

		contentPane.add(lblVocales);

		JLabel lblConsonantes = new JLabel("CONSONANTES");
		lblConsonantes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConsonantes.setHorizontalAlignment(SwingConstants.RIGHT);

		lblConsonantes.setBounds(235, 53, 85, 14);

		contentPane.add(lblConsonantes);

		JLabel lblEspeciales = new JLabel("ESPECIALES");
		lblEspeciales.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEspeciales.setHorizontalAlignment(SwingConstants.RIGHT);

		lblEspeciales.setBounds(242, 84, 78, 14);

		contentPane.add(lblEspeciales);
		
		JTextArea textArea = new JTextArea();

		JButton btnLeer = new JButton("LEER");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(gFichero.getTextoFichero());
			}
		});
		btnLeer.setFont(new Font("Tahoma", Font.PLAIN, 10));

		btnLeer.setBounds(10, 223, 67, 22);

		contentPane.add(btnLeer);

		JButton btnEscribir = new JButton("ESCRBIR");
		btnEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gFichero.escribirFichero(textArea.getText());
			}
		});
		btnEscribir.setFont(new Font("Tahoma", Font.PLAIN, 10));

		btnEscribir.setBounds(87, 223, 85, 22);

		contentPane.add(btnEscribir);

		JButton btnContar = new JButton("CONTAR");
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Integer> contadores = gFichero.contarChar(textArea.getText());
				
				txtVocales.setText(String.valueOf(contadores.get("vocales")));
		        txtConsonantes.setText(String.valueOf(contadores.get("consonantes")));
		        txtEspeciales.setText(String.valueOf(contadores.get("especiales")));
		        txtResto.setText(String.valueOf(contadores.get("resto")));
		        txtNumeros.setText(String.valueOf(contadores.get("numeros")));
		        txtTotal.setText(String.valueOf(contadores.get("total")));
			}
		});
		btnContar.setFont(new Font("Tahoma", Font.PLAIN, 10));

		btnContar.setBounds(182, 223, 78, 22);

		contentPane.add(btnContar);
		
		JLabel lblResto = new JLabel("RESTO");
		lblResto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblResto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResto.setBounds(242, 115, 78, 14);
		contentPane.add(lblResto);
		
		JLabel lblNumeros = new JLabel("NÚMEROS");
		lblNumeros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumeros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeros.setBounds(242, 146, 78, 14);
		contentPane.add(lblNumeros);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(242, 177, 78, 14);
		contentPane.add(lblTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 228, 172);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
 
	}
}

 