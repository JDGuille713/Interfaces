package curso.view;

import curso.controller.ControladorMenu;
import curso.model.ModeloMenu;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class EjercicioMenu extends JFrame {
    // Componentes enlazados con EjercicioMenu.form
    private JPanel panelPrincipal;
    private JPanel scrollPane;
    private JTextArea areaTexto;

    // Componentes de la barra de menú
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenuItem itemNuevo;
    private JMenuItem itemAbrir;
    private JMenuItem itemGuardar;
    private JMenuItem itemGuardarComo;
    private JMenuItem itemImprimir;
    private JMenuItem itemAcercaDe;
    private JMenuItem itemSalir;

    private JMenu menuEdicion;
    private JMenuItem itemCopiar;
    private JMenuItem itemCortar;
    private JMenuItem itemPegar;

    // Componentes de la barra de herramientas (iconos)
    private JToolBar toolBar;
    private JButton btnNuevo;
    private JButton btnAbrir;
    private JButton btnGuardar;
    private JButton btnGuardarComo;
    private JButton btnImprimir;
    private JButton btnCopiar;
    private JButton btnCortar;
    private JButton btnPegar;
    private JButton btnAcercaDe;
    private JButton btnSalir;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioMenu vista = new EjercicioMenu();
            ModeloMenu modelo = new ModeloMenu();
            new ControladorMenu(vista, modelo);
            vista.setVisible(true);
        });
    }

    public EjercicioMenu() {
        // Respaldo por si IntelliJ aún no ha regenerado el código del .form tras pegar
        if (panelPrincipal == null) {
            panelPrincipal = new JPanel(new BorderLayout());
            scrollPane = new JPanel(new BorderLayout());
            areaTexto = new JTextArea();
            scrollPane.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
            panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        } else if (areaTexto == null) {
            areaTexto = new JTextArea();
            panelPrincipal.setLayout(new BorderLayout());
            panelPrincipal.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        }

        setTitle("Ejercicio 1");
        inicializarMenu();
        inicializarToolBar();

        // Contenedor raíz para colocar el JToolBar arriba y el panel del .form en el centro
        JPanel contenedorRaiz = new JPanel(new BorderLayout());
        contenedorRaiz.add(toolBar, BorderLayout.NORTH);
        contenedorRaiz.add(panelPrincipal, BorderLayout.CENTER);
        setContentPane(contenedorRaiz);

        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarMenu() {
        menuBar = new JMenuBar();

        // Desplegable Archivo
        menuArchivo = new JMenu("Archivo");
        itemNuevo = new JMenuItem("Nuevo");
        itemAbrir = new JMenuItem("Abrir");
        itemGuardar = new JMenuItem("Guardar");
        itemGuardarComo = new JMenuItem("Guardar Como...");
        itemImprimir = new JMenuItem("Imprimir");
        itemAcercaDe = new JMenuItem("Acerca de...");
        itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemGuardarComo);
        menuArchivo.add(itemImprimir);
        menuArchivo.addSeparator();
        menuArchivo.add(itemAcercaDe);
        menuArchivo.add(itemSalir);

        // Desplegable Edición
        menuEdicion = new JMenu("Edición");
        itemCopiar = new JMenuItem("Copiar");
        itemCortar = new JMenuItem("Cortar");
        itemPegar = new JMenuItem("Pegar");

        menuEdicion.add(itemCopiar);
        menuEdicion.add(itemCortar);
        menuEdicion.add(itemPegar);

        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);
        setJMenuBar(menuBar);
    }

    private void inicializarToolBar() {
        toolBar = new JToolBar();

        // Iconos de Archivo
        btnNuevo = crearBotonToolBar("/curso/resource/EjercicioMenu/nuevo.png", "Nuevo");
        btnAbrir = crearBotonToolBar("/curso/resource/EjercicioMenu/abrir.png", "Abrir");
        btnGuardar = crearBotonToolBar("/curso/resource/EjercicioMenu/guardar.png", "Guardar");
        btnGuardarComo = crearBotonToolBar("/curso/resource/EjercicioMenu/guardar-como.png", "Guardar Como...");
        btnImprimir = crearBotonToolBar("/curso/resource/EjercicioMenu/imprimir.png", "Imprimir");

        // Iconos de Edición
        btnCopiar = crearBotonToolBar("/curso/resource/EjercicioMenu/copiar.png", "Copiar");
        btnCortar = crearBotonToolBar("/curso/resource/EjercicioMenu/cortar.png", "Cortar");
        btnPegar = crearBotonToolBar("/curso/resource/EjercicioMenu/pegar.png", "Pegar");

        // Iconos de Acerca de y Salir
        btnAcercaDe = crearBotonToolBar("/curso/resource/EjercicioMenu/acerca-de.png", "Acerca de...");
        btnSalir = crearBotonToolBar("/curso/resource/EjercicioMenu/salir.png", "Salir");

        toolBar.add(btnNuevo);
        toolBar.add(btnAbrir);
        toolBar.add(btnGuardar);
        toolBar.add(btnGuardarComo);
        toolBar.add(btnImprimir);
        toolBar.addSeparator();
        toolBar.add(btnCopiar);
        toolBar.add(btnCortar);
        toolBar.add(btnPegar);
        toolBar.addSeparator();
        toolBar.add(btnAcercaDe);
        toolBar.add(btnSalir);
    }

    private JButton crearBotonToolBar(String rutaIcono, String tooltip) {
        JButton boton = new JButton();
        boton.setToolTipText(tooltip);
        boton.setFocusable(false);

        URL url = getClass().getResource(rutaIcono);
        if (url != null) {
            ImageIcon iconoOriginal = new ImageIcon(url);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(imagenEscalada));
        } else {
            boton.setText(tooltip);
        }

        return boton;
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    // Getters del menú Archivo
    public JMenuItem getItemNuevo() { return itemNuevo; }
    public JMenuItem getItemAbrir() { return itemAbrir; }
    public JMenuItem getItemGuardar() { return itemGuardar; }
    public JMenuItem getItemGuardarComo() { return itemGuardarComo; }
    public JMenuItem getItemImprimir() { return itemImprimir; }
    public JMenuItem getItemAcercaDe() { return itemAcercaDe; }
    public JMenuItem getItemSalir() { return itemSalir; }

    // Getters del menú Edición
    public JMenuItem getItemCopiar() { return itemCopiar; }
    public JMenuItem getItemCortar() { return itemCortar; }
    public JMenuItem getItemPegar() { return itemPegar; }

    // Getters de la barra de herramientas
    public JButton getBtnNuevo() { return btnNuevo; }
    public JButton getBtnAbrir() { return btnAbrir; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnGuardarComo() { return btnGuardarComo; }
    public JButton getBtnImprimir() { return btnImprimir; }
    public JButton getBtnCopiar() { return btnCopiar; }
    public JButton getBtnCortar() { return btnCortar; }
    public JButton getBtnPegar() { return btnPegar; }
    public JButton getBtnAcercaDe() { return btnAcercaDe; }
    public JButton getBtnSalir() { return btnSalir; }
}