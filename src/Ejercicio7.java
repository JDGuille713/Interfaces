
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JSpinner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejercicio7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JSlider sliAzul = new JSlider();
	JSlider sliVerde = new JSlider();
	JSlider sliRojo = new JSlider();

	JSpinner spiAzul = new JSpinner();
	JSpinner spiVerde = new JSpinner();
	JSpinner spiRojo = new JSpinner();

	JLabel lblColor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 frame = new Ejercicio7();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio7() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRojo = new JLabel("ROJO");
		lblRojo.setForeground(Color.RED);
		lblRojo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRojo.setBounds(39, 12, 48, 14);
		contentPane.add(lblRojo);

		JLabel lblVerde = new JLabel("VERDE");
		lblVerde.setForeground(Color.GREEN);
		lblVerde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerde.setBounds(39, 67, 48, 14);
		contentPane.add(lblVerde);

		JLabel lblAzul = new JLabel("AZUL");
		lblAzul.setForeground(Color.BLUE);
		lblAzul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAzul.setBounds(39, 125, 48, 14);
		contentPane.add(lblAzul);

		sliAzul.setMaximum(255);
		sliAzul.setValue(0);
		sliAzul.setBounds(146, 125, 200, 26);
		contentPane.add(sliAzul);

		sliVerde.setValue(0);
		sliVerde.setMaximum(255);
		sliVerde.setBounds(146, 67, 200, 26);
		contentPane.add(sliVerde);

		sliRojo.setValue(0);
		sliRojo.setMaximum(255);
		sliRojo.setBounds(146, 12, 200, 26);
		contentPane.add(sliRojo);

		spiAzul.setBounds(356, 124, 48, 20);
		contentPane.add(spiAzul);

		spiVerde.setBounds(356, 66, 48, 20);
		contentPane.add(spiVerde);

		spiRojo.setValue(sliRojo.getValue());
		spiRojo.setBounds(356, 11, 48, 20);
		contentPane.add(spiRojo);

		lblColor = new JLabel("");
		lblColor.setBackground(new Color(255, 255, 255));
		lblColor.setOpaque(true);
		lblColor.setBounds(128, 180, 166, 72);
		contentPane.add(lblColor);
		
		JLabel txtRojo = new JLabel("");
		txtRojo.setBounds(356, 42, 48, 14);
		contentPane.add(txtRojo);
		
		JLabel txtVerde = new JLabel("");
		txtVerde.setBounds(356, 97, 48, 14);
		contentPane.add(txtVerde);
		
		JLabel txtAzul = new JLabel("");
		txtAzul.setBounds(356, 155, 48, 14);
		contentPane.add(txtAzul);

		// Solo números en los Spinner

		spiRojo.getEditor().getComponent(0).addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTodos(e);
			}
		});

		spiVerde.getEditor().getComponent(0).addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTodos(e);
			}
		});

		spiAzul.getEditor().getComponent(0).addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTodos(e);
			}
		});

		// Cambiar Spinner

		spiRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarSlider();
			}
		});

		spiAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarSlider();
			}
		});

		spiVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarSlider();
			}
		});

		// Cambiar Slider

		sliRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cambiarSpinner();
				txtRojo.setText(String.format("%X", sliRojo.getValue()));
	
			}
		});

		sliAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarSpinner();
				txtAzul.setText(String.format("%X", sliAzul.getValue()));
			}
		});

		sliVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarSpinner();
				txtVerde.setText(String.format("%X", sliVerde.getValue()));
			}
		});

	}

	public void cambiarSpinner() {
		spiRojo.setValue(sliRojo.getValue());
		spiAzul.setValue(sliAzul.getValue());
		spiVerde.setValue(sliVerde.getValue());

		lblColor.setBackground(new Color(
				(int) spiRojo.getValue(),
				(int) spiVerde.getValue(),
				(int) spiAzul.getValue()));
	
	}

	public void cambiarSlider() {
		sliRojo.setValue((int) spiRojo.getValue());
		sliAzul.setValue((int) spiAzul.getValue());
		sliVerde.setValue((int) spiVerde.getValue());

		lblColor.setBackground(new Color(
				sliRojo.getValue(),
				sliVerde.getValue(),
				sliAzul.getValue()));
	}

	public void keyTypedTodos(KeyEvent e) {
		if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
			e.consume();
		}
	}
}