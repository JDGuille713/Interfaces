package curso.controller;

import curso.model.ModeloMenu;
import curso.view.EjercicioMenu;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.print.PrinterException;
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
        // Nuevo (menú + icono)
        vista.getItemNuevo().addActionListener(e -> nuevoArchivo());
        vista.getBtnNuevo().addActionListener(e -> nuevoArchivo());

        // Abrir (menú + icono)
        vista.getItemAbrir().addActionListener(e -> abrirArchivo());
        vista.getBtnAbrir().addActionListener(e -> abrirArchivo());

        // Guardar (menú + icono)
        vista.getItemGuardar().addActionListener(e -> guardarArchivo());
        vista.getBtnGuardar().addActionListener(e -> guardarArchivo());

        // Guardar Como... (menú + icono)
        vista.getItemGuardarComo().addActionListener(e -> guardarArchivoComo());
        vista.getBtnGuardarComo().addActionListener(e -> guardarArchivoComo());

        // Imprimir (menú + icono)
        vista.getItemImprimir().addActionListener(e -> imprimirArchivo());
        vista.getBtnImprimir().addActionListener(e -> imprimirArchivo());

        // Edición: Copiar, Cortar y Pegar (menú + icono)
        vista.getItemCopiar().addActionListener(e -> copiarTexto());
        vista.getBtnCopiar().addActionListener(e -> copiarTexto());

        vista.getItemCortar().addActionListener(e -> cortarTexto());
        vista.getBtnCortar().addActionListener(e -> cortarTexto());

        vista.getItemPegar().addActionListener(e -> pegarTexto());
        vista.getBtnPegar().addActionListener(e -> pegarTexto());

        // Acerca de... (menú + icono)
        vista.getItemAcercaDe().addActionListener(e -> mostrarAcercaDe());
        vista.getBtnAcercaDe().addActionListener(e -> mostrarAcercaDe());

        // Salir (menú + icono)
        vista.getItemSalir().addActionListener(e -> salirAplicacion());
        vista.getBtnSalir().addActionListener(e -> salirAplicacion());
    }

    private void nuevoArchivo() {
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

    private void imprimirArchivo() {
        try {
            vista.getAreaTexto().print();
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Error al intentar imprimir el documento.",
                    "Error de impresión",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void copiarTexto() {
        String texto = vista.getAreaTexto().getText();
        StringSelection seleccion = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);
        vista.getAreaTexto().requestFocusInWindow();
    }

    private void cortarTexto() {
        String texto = vista.getAreaTexto().getText();
        StringSelection seleccion = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);
        vista.getAreaTexto().setText("");
        vista.getAreaTexto().requestFocusInWindow();
    }

    private void pegarTexto() {
        vista.getAreaTexto().paste();
        vista.getAreaTexto().requestFocusInWindow();
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(
                vista,
                "Nombre: Guillermo Repullo Estevez\nCurso: 2ºDAM",
                "Acerca de...",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void salirAplicacion() {
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
    }
}