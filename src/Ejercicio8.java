
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Ejercicio8 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

    public Ejercicio8() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(47, 116, 264, 28);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        contentPane.add(progressBar);

        JButton btnAvanzar = new JButton("AVANZAR");
        btnAvanzar.setBounds(144, 193, 113, 22);
        contentPane.add(btnAvanzar);

        JLabel lblNewLabel = new JLabel("0%");
        lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel.setBounds(349, 116, 65, 28);
        contentPane.add(lblNewLabel);

        btnAvanzar.addActionListener(e -> {
            btnAvanzar.setEnabled(false);

            Thread hilo = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i <= 100; i++) {
                        final int porcentaje = i;

                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                progressBar.setValue(porcentaje);
                                lblNewLabel.setText(porcentaje + "%");

                                if (porcentaje == 100) {
                                    btnAvanzar.setEnabled(true);
                                }
                            }
                        });

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            });

            hilo.start();
        });
    }
}
