
package curso.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestorFicheros {

    private final String RUTA1 = "src/curso/resource/texto1.txt";
    private final String RUTA2 = "src/curso/resource/texto2.txt";

    public String cargarTexto1() throws IOException {
        return Files.readString(Path.of(RUTA1));
    }

    public String cargarTexto2() throws IOException {
        return Files.readString(Path.of(RUTA2));
    }

    public String compararTextos(String texto1, String texto2) {

        String[] lineas1 = texto1.split("\\R", -1);
        String[] lineas2 = texto2.split("\\R", -1);

        String resultado = "";

        int maxLineas = Math.max(lineas1.length, lineas2.length);

        for (int i = 0; i < maxLineas; i++) {

            String linea1 = i < lineas1.length ? lineas1[i] : "";
            String linea2 = i < lineas2.length ? lineas2[i] : "";

            int maxColumnas = Math.max(linea1.length(), linea2.length());

            for (int j = 0; j < maxColumnas; j++) {

                String caracter1 = j < linea1.length()
                        ? mostrarCaracter(linea1.charAt(j)) : "<FIN>";

                String caracter2 = j < linea2.length()
                        ? mostrarCaracter(linea2.charAt(j)) : "<FIN>";

                if (!caracter1.equals(caracter2)) {

                    resultado += "Linea: " + (i + 1)
                            + " Columna: " + (j + 1)
                            + " -> " + caracter1 + " != " + caracter2 + "\n";
                }
            }
        }

        if (resultado.isEmpty()) {
            resultado = "Los ficheros son iguales.";
        }

        return resultado;
    }

    private String mostrarCaracter(char caracter) {

        if (caracter == ' ') {
            return "<ESPACIO>";
        }

        if (caracter == '\t') {
            return "<TAB>";
        }

        return "'" + caracter + "'";
    }
}
