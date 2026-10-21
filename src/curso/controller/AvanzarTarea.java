package curso.controller;

import javax.swing.*;

public class AvanzarTarea extends Thread {
    private int valor;
    private String nombre;
    private JProgressBar pbarra;

    public AvanzarTarea() {
        this.valor = 0;
        this.nombre = "sin nombre";
    }

    public AvanzarTarea(String nombre, JProgressBar pb) {
        this.valor = 0;
        this.nombre = nombre;
        this.pbarra = pb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            valor++;
            try {
                sleep(25);
                pbarra.setValue(valor);
                System.out.println(nombre+ ": v" + valor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getValor() {
        return valor;
    }

    public void setValor() {
        this.valor = valor;
    }
}
