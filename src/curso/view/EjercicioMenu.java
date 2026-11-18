package curso.view;

import javax.swing.*;

public class EjercicioMenu extends JFrame {
    public void main(String[] args) {
        private void createUIComponents() {
            menuBar = new JMenuBar();
            menuArchivo = new JMenu("Archivo");
            itemNuevo = new JMenuItem("Nuevo");
            itemAbrir = new JMenuItem("Abrir");
            itemGuardar = new JMenuItem("Guardar");
            itemGuardarComo = new JMenuItem("Guardar como...");
            itemAcercaDe = new JMenuItem("Acerca de...");
            itemSalir = new JMenuItem("Salir");
            menuArchivo.add(itemNuevo);
            menuArchivo.add(itemAbrir);
            menuArchivo.add(itemGuardar);
            menuArchivo.add(itemGuardarComo);
            menuArchivo.add(itemAcercaDe);
            menuArchivo.add(itemSalir);
            menuBar.add(menuArchivo);
        }


    }

    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
