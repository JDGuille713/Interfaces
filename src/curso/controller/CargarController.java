
package curso.controller;

import curso.model.GestorFicheros;
import curso.view.EjercicioClase2Cargar;

import javax.swing.*;
import java.io.IOException;

public class CargarController {

    private EjercicioClase2Cargar vista;
    private GestorFicheros modelo;

    public CargarController(EjercicioClase2Cargar vista) {

        this.vista = vista;
        modelo = new GestorFicheros();

        vista.getBtnCarga1().addActionListener(e -> cargarTexto1());

        vista.getCargaTexto2Button().addActionListener(e -> cargarTexto2());

        vista.getBtnComparar().addActionListener(e -> comparar());

        vista.getBtnAutor().addActionListener(e ->
                JOptionPane.showMessageDialog(vista.getContentPane(),
                        "Autor: Guillermo Repullo Estevez" + "\nCurso: 2ºDAM"));

        vista.getBtnSalir().addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    vista.getContentPane(),
                    "¿Estas seguro de que quieres salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void cargarTexto1() {

        try {
            vista.setTexto1(modelo.cargarTexto1());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(vista.getContentPane(),
                    "Error al cargar texto1.txt");
        }
    }

    private void cargarTexto2() {

        try {
            vista.setTexto2(modelo.cargarTexto2());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(vista.getContentPane(),
                    "Error al cargar texto2.txt");
        }
    }

    private void comparar() {

        String texto1 = vista.getTexto1();
        String texto2 = vista.getTexto2();

        String resultado = modelo.compararTextos(texto1, texto2);

        vista.setResultado(resultado);
    }
}
