
package curso.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.math.BigInteger;
import java.util.Locale;

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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(7, 11, new Insets(0, 0, 0, 0), -1, -1));
        Font panel1Font = this.$$$getFont$$$(null, -1, 15, panel1.getFont());
        if (panel1Font != null) panel1.setFont(panel1Font);
        lblConv = new JLabel();
        lblConv.setText("CONVERSOR");
        panel1.add(lblConv, new GridConstraints(0, 0, 1, 11, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(2, 10, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioBin = new JRadioButton();
        radioBin.setHorizontalAlignment(0);
        radioBin.setText("BIN");
        panel1.add(radioBin, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnA = new JButton();
        btnA.setText("A");
        panel1.add(btnA, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioDec = new JRadioButton();
        radioDec.setText("DEC");
        panel1.add(radioDec, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioHex = new JRadioButton();
        radioHex.setText("HEX");
        panel1.add(radioHex, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn1 = new JButton();
        btn1.setText("1");
        panel1.add(btn1, new GridConstraints(5, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn2 = new JButton();
        btn2.setText("2");
        panel1.add(btn2, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn3 = new JButton();
        btn3.setText("3");
        panel1.add(btn3, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioOct = new JRadioButton();
        radioOct.setHorizontalAlignment(0);
        radioOct.setText("OCT");
        panel1.add(radioOct, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn0 = new JButton();
        btn0.setText("0");
        panel1.add(btn0, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblResultado = new JLabel();
        lblResultado.setText("0");
        panel1.add(lblResultado, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn4 = new JButton();
        btn4.setText("4");
        panel1.add(btn4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn5 = new JButton();
        btn5.setText("5");
        panel1.add(btn5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnB = new JButton();
        btnB.setText("B");
        panel1.add(btnB, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn6 = new JButton();
        btn6.setText("6");
        panel1.add(btn6, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnC = new JButton();
        btnC.setText("C");
        panel1.add(btnC, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn7 = new JButton();
        btn7.setText("7");
        panel1.add(btn7, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnD = new JButton();
        btnD.setText("D");
        panel1.add(btnD, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn8 = new JButton();
        btn8.setText("8");
        panel1.add(btn8, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnE = new JButton();
        btnE.setText("E");
        panel1.add(btnE, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn9 = new JButton();
        btn9.setText("9");
        panel1.add(btn9, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnF = new JButton();
        btnF.setText("F");
        panel1.add(btnF, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnSalir = new JButton();
        btnSalir.setText("SALIR");
        panel1.add(btnSalir, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAutor = new JButton();
        btnAutor.setText("AUTOR");
        panel1.add(btnAutor, new GridConstraints(6, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnReset = new JButton();
        btnReset.setText("RESET");
        panel1.add(btnReset, new GridConstraints(6, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }
}
