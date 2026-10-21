
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class Ejercicio8 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> modeloIzq = new DefaultListModel<String>();
	private JList<String> listaIzq = new JList(modeloIzq);
	private DefaultListModel<String> modeloDer = new DefaultListModel<String>();
	private JList<String> listaDer = new JList(modeloDer);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio8 frame = new Ejercicio8();
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
	public Ejercicio8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JScrollPane scroll = new JScrollPane(listaIzq);
		scroll.setBounds(30,30,150,240);
		contentPane.add(scroll);
		
		
		
		JButton btnDerecha = new JButton(">");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String seleccion = listaIzq.getSelectedValue();
			if (seleccion != null) {
				
			}
			}
		});
		btnDerecha.setBounds(176, 48, 66, 22);
		contentPane.add(btnDerecha);
		
		JButton btnDerechaTodos = new JButton(">>");
		btnDerechaTodos.setBounds(176, 81, 66, 22);
		contentPane.add(btnDerechaTodos);
		
		JButton btnIzquierda = new JButton("<");
		btnIzquierda.setBounds(176, 114, 66, 22);
		contentPane.add(btnIzquierda);
		
		JButton btnIzquierdaTodos = new JButton("<<");
		btnIzquierdaTodos.setBounds(176, 147, 66, 22);
		contentPane.add(btnIzquierdaTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 32, 118, 145);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(265, 33, 118, 145);
		contentPane.add(scrollPane_1);
		
		JButton btnIzquierdaBorrar = new JButton("X");
		btnIzquierdaBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIzquierdaBorrar.setBounds(28, 188, 56, 22);
		contentPane.add(btnIzquierdaBorrar);
		
		JButton btnIzquierdaSumar = new JButton("+");
		btnIzquierdaSumar.setBounds(90, 188, 56, 22);
		contentPane.add(btnIzquierdaSumar);
		
		JButton btnDerechaSumar = new JButton("+");
		btnDerechaSumar.setBounds(327, 188, 56, 22);
		contentPane.add(btnDerechaSumar);
		
		JButton btnDerechaBorrar = new JButton("X");
		btnDerechaBorrar.setBounds(265, 188, 56, 22);
		contentPane.add(btnDerechaBorrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(167, 188, 88, 22);
		contentPane.add(btnSalir);

	}
}
