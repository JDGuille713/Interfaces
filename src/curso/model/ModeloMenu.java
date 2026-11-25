package curso.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ModeloMenu {
    private File archivoActual;

    public File getArchivoActual() {
        return archivoActual;
    }

    public void setArchivoActual(File archivoActual) {
        this.archivoActual = archivoActual;
    }

    public String leerArchivo(File archivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            this.archivoActual = archivo;
        } catch (IOException e) {
            return null;
        }
        return contenido.toString();
    }

    public boolean guardarArchivo(File archivo, String texto) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8))) {
            bw.write(texto);
            this.archivoActual = archivo;
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}