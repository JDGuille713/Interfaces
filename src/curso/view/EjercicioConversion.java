
package curso.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigInteger;

public class EjercicioConversion extends JFrame {

    private JRadioButton radioBin;
    private JRadioButton radioOct;
    private JRadioButton radioDec;
    private JRadioButton radioHex;

    private JButton btnA, btnB, btnC, btnD, btnE, btnF;
    private JButton btn0, btn1, btn2, btn3, btn4;
    private JButton btn5, btn6, btn7, btn8, btn9;
    private JButton btnSalir, btnAutor, btnReset;

    private JLabel lblConv;
    private JLabel lblResultado;

    private int baseActual = 10;

    public EjercicioConversion() {
        setTitle("Conversor numérico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(430, 420));

        crearInterfaz();
        configurarEventos();
        actualizarBotones();

        setLocationRelativeTo(null);
    }

    private void crearInterfaz() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.weightx = 1;
        gbc.weighty = 0;

        // Título
        lblConv = new JLabel("CONVERSOR", SwingConstants.CENTER);
        lblConv.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.weighty = 0.2;
        panel.add(lblConv, gbc);

        // Pantalla de resultados
        lblResultado = new JLabel("0", SwingConstants.RIGHT);
        lblResultado.setFont(new Font("Consolas", Font.BOLD, 25));
        lblResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(10, 10, 10, 10)
        ));

        gbc.gridy = 1;
        gbc.weighty = 0.8;
        panel.add(lblResultado, gbc);

        // Selección de base
        radioBin = new JRadioButton("BIN");
        radioOct = new JRadioButton("OCT");
        radioDec = new JRadioButton("DEC", true);
        radioHex = new JRadioButton("HEX");

        ButtonGroup grupoBases = new ButtonGroup();
        grupoBases.add(radioBin);
        grupoBases.add(radioOct);
        grupoBases.add(radioDec);
        grupoBases.add(radioHex);

        JPanel panelBases = new JPanel(new GridLayout(1, 4, 10, 0));
        panelBases.add(radioBin);
        panelBases.add(radioOct);
        panelBases.add(radioDec);
        panelBases.add(radioHex);

        gbc.gridy = 2;
        gbc.weighty = 0.4;
        panel.add(panelBases, gbc);

        // Botones A-F
        btnA = new JButton("A");
        btnB = new JButton("B");
        btnC = new JButton("C");
        btnD = new JButton("D");
        btnE = new JButton("E");
        btnF = new JButton("F");

        agregarFila(panel, gbc, 3,
                btnA, btnB, btnC, btnD, btnE, btnF);

        // Botones 4-9
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");

        agregarFila(panel, gbc, 4,
                btn4, btn5, btn6, btn7, btn8, btn9);

        // Botones 0-3, conservando la distribución del ejemplo
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");

        gbc.gridy = 5;
        gbc.weighty = 0.6;

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(btn0, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        panel.add(btn1, gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 1;
        panel.add(btn2, gbc);

        gbc.gridx = 5;
        gbc.gridwidth = 1;
        panel.add(btn3, gbc);

        // Botones inferiores
        btnSalir = new JButton("SALIR");
        btnAutor = new JButton("AUTOR");
        btnReset = new JButton("RESET");

        gbc.gridy = 6;
        gbc.weighty = 0.4;

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(btnSalir, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        panel.add(btnAutor, gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 2;
        panel.add(btnReset, gbc);

        setContentPane(panel);
    }

    private void agregarFila(
            JPanel panel,
            GridBagConstraints gbc,
            int fila,
            JButton... botones) {

        gbc.gridy = fila;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;

        for (int i = 0; i < botones.length; i++) {
            gbc.gridx = i;
            panel.add(botones[i], gbc);
        }
    }

    private void configurarEventos() {

        // Introducir números y letras
        JButton[] botones = {
                btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9,
                btnA, btnB, btnC, btnD, btnE, btnF
        };

        for (JButton boton : botones) {
            boton.addActionListener(e -> {
                String digito = boton.getText();
                String actual = lblResultado.getText();

                if (actual.equals("0")) {
                    actual = "";
                }

                lblResultado.setText(actual + digito);
            });
        }

        // Cambio de base
        radioBin.addActionListener(e -> cambiarBase(2));
        radioOct.addActionListener(e -> cambiarBase(8));
        radioDec.addActionListener(e -> cambiarBase(10));
        radioHex.addActionListener(e -> cambiarBase(16));

        // Reset
        btnReset.addActionListener(e -> lblResultado.setText("0"));

        // Autor
        btnAutor.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Conversor numérico\nAutor: Guillermo Repullo",
                        "Autor",
                        JOptionPane.INFORMATION_MESSAGE
                )
        );

        // Salir
        btnSalir.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Deseas salir de la aplicación?",
                    "Salir",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
    }

    private void cambiarBase(int nuevaBase) {
        String numero = lblResultado.getText();

        try {
            // Interpretar el número usando la base anterior
            BigInteger valor = new BigInteger(numero, baseActual);

            // Convertirlo a la base nueva
            lblResultado.setText(valor.toString(nuevaBase).toUpperCase());

            baseActual = nuevaBase;
            actualizarBotones();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se puede convertir el número introducido.",
                    "Error de conversión",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void actualizarBotones() {
        JButton[] botones = {
                btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9,
                btnA, btnB, btnC, btnD, btnE, btnF
        };

        String digitos = "0123456789ABCDEF";

        for (JButton boton : botones) {
            int valor = digitos.indexOf(boton.getText());
            boton.setEnabled(valor < baseActual);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioConversion ventana = new EjercicioConversion();
            ventana.setVisible(true);
        });
    }
}
