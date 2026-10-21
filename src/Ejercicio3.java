
import java.awt.Color;
import java.awt.EventQueue;

import javax.print.attribute.standard.JobImpressionsSupported;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
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
	public Ejercicio3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblColores = new JLabel("Colores");
		lblColores.setBounds(38, 11, 78, 30);
		lblColores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblColores);
		
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(38, 48, 110, 22);
		contentPane.add(rdbtnRojo);
		
		JRadioButton rdbtnVerde = new JRadioButton("Verde\r\n");
		rdbtnVerde.setBounds(38, 73, 110, 22);
		contentPane.add(rdbtnVerde);
		
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(38, 98, 110, 22);
		contentPane.add(rdbtnAzul);
		
		ButtonGroup colores = new ButtonGroup();
		colores.add(rdbtnRojo);
		colores.add(rdbtnVerde);
		colores.add(rdbtnAzul);
		
		JButton btnElegido = new JButton("Color Elegido");
		btnElegido.setBounds(10, 127, 124, 22);
		btnElegido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				/*
				if (colores.isSelected(null)) {
					JOptionPane.showMessageDialog(null,"Ningun color elegido", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (rdbtnRojo.isSelected()) {
						JOptionPane.showMessageDialog(null, "El color elegido es Rojo");
					} else if (rdbtnAzul.isSelected()) {
						JOptionPane.showMessageDialog(null, "El color elegido es Azul");
					} else {
						JOptionPane.showMessageDialog(null,"El color elegido es Verde");
					}
				} */
				
				String S = new String("");
				if (rdbtnRojo.isSelected()) {
					S = rdbtnRojo.getText();
					JOptionPane.showMessageDialog(null, "El color elegido es "+ S);
				} else if (rdbtnVerde.isSelected()) {
					S = rdbtnVerde.getText();
					JOptionPane.showMessageDialog(null, "El color elegido es "+ S);
				} else if (rdbtnAzul.isSelected()) {
					S = rdbtnAzul.getText();
					JOptionPane.showMessageDialog(null, "El color elegido es "+ S);
				} else {
					JOptionPane.showMessageDialog(null, "Ningun color elegido", "Error", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		contentPane.add(btnElegido);
		
		JLabel lblColors = new JLabel("Colors");
		lblColors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColors.setBounds(303, 11, 78, 30);
		contentPane.add(lblColors);
		
		JRadioButton rdbtnRed = new JRadioButton("Red");
		rdbtnRed.setBounds(275, 48, 110, 22);
		contentPane.add(rdbtnRed);
		
		JRadioButton rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.setBounds(275, 73, 110, 22);
		contentPane.add(rdbtnGreen);
		
		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.setBounds(275, 98, 110, 22);
		contentPane.add(rdbtnBlue);
		
		ButtonGroup colors = new ButtonGroup();
		colors.add(rdbtnRed);
		colors.add(rdbtnGreen);
		colors.add(rdbtnBlue);
		
		JLabel lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBounds(267, 166, 142, 70);
		contentPane.add(lblColor);
		
		JButton btnChange = new JButton("Change color");
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (colors.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "No color selected", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (rdbtnRed.isSelected()) {
						lblColor.setBackground(Color.RED);
					} else if (rdbtnBlue.isSelected()) {
						lblColor.setBackground(Color.BLUE);
					} else {
						lblColor.setBackground(Color.GREEN);
					}
				}
				
			}
		});
		btnChange.setBounds(267, 127, 136, 22);
		contentPane.add(btnChange);
	}
}
