package curso.controller;

import curso.model.ModeloMenu;
import curso.view.EjercicioMenu;

import javax.swing.*;
import java.io.File;

public class ControladorMenu {
    private final EjercicioMenu vista;
    private final ModeloMenu modelo;

    public ControladorMenu(EjercicioMenu vista, ModeloMenu modelo) {
        this.vista = vista;
        this.modelo = modelo;
        registrarEventos();
    }

    private void registrarEventos() {
        // Nuevo
        vista.getItemNuevo().addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(
                    vista,
                    "¿Seguro que desea crear un archivo nuevo? Se perderán los cambios no guardados.",
                    "Confirmar nuevo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                vista.getAreaTexto().setText("");
                modelo.setArchivoActual(null);
                vista.setTitle("Ejercicio 1");
            }
        });

        // Abrir
        vista.getItemAbrir().addActionListener(e -> abrirArchivo());

        // Guardar
        vista.getItemGuardar().addActionListener(e -> guardarArchivo());

        // Guardar Como...
        vista.getItemGuardarComo().addActionListener(e -> guardarArchivoComo());

        // Acerca de...
        vista.getItemAcercaDe().addActionListener(e -> JOptionPane.showMessageDialog(
                vista,
                "Guillermo\nDesarrollo de Aplicaciones Multiplataforma (DAM)",
                "Acerca de...",
                JOptionPane.INFORMATION_MESSAGE
        ));

        // Salir
        vista.getItemSalir().addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(
                    vista,
                    "¿Seguro que desea salir de la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(vista);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String contenido = modelo.leerArchivo(archivo);

            if (contenido != null) {
                vista.getAreaTexto().setText(contenido);
                vista.setTitle("Ejercicio 1 - " + archivo.getName());
            } else {
                JOptionPane.showMessageDialog(
                        vista,
                        "No se pudo leer el archivo seleccionado.",
                        "Error al abrir",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void guardarArchivo() {
        File archivoActual = modelo.getArchivoActual();
        if (archivoActual != null) {
            boolean guardado = modelo.guardarArchivo(archivoActual, vista.getAreaTexto().getText());
            if (!guardado) {
                JOptionPane.showMessageDialog(
                        vista,
                        "Error al guardar el archivo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            guardarArchivoComo();
        }
    }

    private void guardarArchivoComo() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(vista);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            boolean guardado = modelo.guardarArchivo(archivo, vista.getAreaTexto().getText());

            if (guardado) {
                vista.setTitle("Ejercicio 1 - " + archivo.getName());
            } else {
                JOptionPane.showMessageDialog(
                        vista,
                        "No se pudo guardar el archivo.",
                        "Error al guardar",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}