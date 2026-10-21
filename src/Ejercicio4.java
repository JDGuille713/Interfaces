
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		comboBox.setBounds(59, 53, 105, 22);
		contentPane.add(comboBox);
		
		JButton btnMesElegido = new JButton("Mes Elegido");
		btnMesElegido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				switch (comboBox.getSelectedIndex()) {
					case 0: {
						JOptionPane.showMessageDialog(null, "El mes elegido es enero");
						break;
					}
					case 1: {
						JOptionPane.showMessageDialog(null, "El mes elegido es febrero");	
						break;
					}
					case 2: {
						JOptionPane.showMessageDialog(null, "El mes elegido es marzo");	
						break;
					}
					case 3: {
						JOptionPane.showMessageDialog(null, "El mes elegido es abril");	
						break;
					}
					case 4: {
						JOptionPane.showMessageDialog(null, "El mes elegido es mayo");	
						break;
					}
					case 5: {
						JOptionPane.showMessageDialog(null, "El mes elegido es junio");	
						break;
					}
					case 6: {
						JOptionPane.showMessageDialog(null, "El mes elegido es julio");	
						break;
					}
					case 7: {
						JOptionPane.showMessageDialog(null, "El mes elegido es agosto");	
						break;
					}
					case 8: {
						JOptionPane.showMessageDialog(null, "El mes elegido es septiembre");	
						break;
					}
					case 9: {
						JOptionPane.showMessageDialog(null, "El mes elegido es octubre");	
						break;
					}
					case 10: {
						JOptionPane.showMessageDialog(null, "El mes elegido es noviembre");	
						break;
					}
					case 11: {
						JOptionPane.showMessageDialog(null, "El mes elegido es diciembre");	
						break;
					}
				}
				*/
				JOptionPane.showMessageDialog(null, "El mes elegido es " + comboBox.getSelectedItem().toString());	

			}
		});
		btnMesElegido.setBounds(287, 53, 111, 22);
		contentPane.add(btnMesElegido);

	}
}
