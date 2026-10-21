
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Ejercicio5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaterial;
	private JButton btnDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 frame = new Ejercicio5();
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
	public Ejercicio5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMaterial = new JTextField();
		txtMaterial.setBounds(47, 73, 96, 20);
		contentPane.add(txtMaterial);
		txtMaterial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(47, 48, 96, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		JLabel lblMateriales = new JLabel("Materiales");
		lblMateriales.setHorizontalAlignment(SwingConstants.CENTER);
		lblMateriales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMateriales.setBounds(297, 50, 96, 14);
		contentPane.add(lblMateriales);
		
		JComboBox<String> cBMateriales = new JComboBox<String>();
		String[] materiales = new String[0];
		DefaultComboBoxModel<String> dcbmodel = new DefaultComboBoxModel<String>(materiales);
		cBMateriales.setModel(dcbmodel);
		
		contentPane.add(cBMateriales);
		cBMateriales.setBounds(307, 72, 86, 22);
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(Ejercicio5.class.getResource("/Imagenes/mas.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String material = txtMaterial.getText().trim();

		        if (material.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo material está vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (!material.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
					JOptionPane.showMessageDialog(null, "No se pueden escribir caracteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (dcbmodel.getIndexOf(material) != -1) {
					JOptionPane.showMessageDialog(null, "El material está repetido", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        dcbmodel.addElement(material);
		        txtMaterial.setText("");
			}
		});
		btnAdd.setBounds(200, 72, 42, 35);
		contentPane.add(btnAdd);

		
		btnDel = new JButton("");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dcbmodel.getSize() != 0) {
				int respuesta = JOptionPane.showConfirmDialog(null, 
						"¿Seguro que desea borrar?",
						"Borrar",
						JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION)
						dcbmodel.removeElement(dcbmodel.getSelectedItem());
				} else {
					JOptionPane.showMessageDialog(null, "El campo materiales está vacío", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		btnDel.setIcon(new ImageIcon("C:\\Users\\GuillermoRepulloE\\eclipse-workspace\\Int_Tema1\\Inte_Tema1\\src\\Imagenes\\10308565.png"));
		btnDel.setBounds(200, 139, 42, 35);
		contentPane.add(btnDel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int respuesta = JOptionPane.showConfirmDialog(null, 
							"¿Seguro que desea cerrar?",
							"Salir",
							JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION)
						System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(177, 213, 88, 22);
		contentPane.add(btnSalir);
	}
}
