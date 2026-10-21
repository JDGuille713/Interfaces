
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GestorFichero {
	private String rutaFichero = "";
	private String textoCompleto;
	File fichero = null;
	FileReader lector = null;
	BufferedReader buffer = null;
	FileWriter escritor = null;
	
	public GestorFichero() {
		rutaFichero = "C:/Users/GuillermoRepulloE/eclipse-workspace/Int_Tema1/Inte_Tema1/src/Resources/datos.txt";
		textoCompleto = new String("");
		fichero = null;
		lector = null;
		buffer = null;
		escritor = null;
	}
	
	public String getTextoFichero() {
		try {
			fichero = new File(rutaFichero);
			lector = new FileReader(fichero);
			buffer = new BufferedReader(lector);
			
			String linea;
			while((linea = buffer.readLine()) != null)
				textoCompleto += linea + "\n";
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		} finally {
			try {
				if (null != lector) {
					lector.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return textoCompleto;
	}
	
	public void escribirFichero(String texto) {
		try {
			fichero = new File(rutaFichero);
			escritor = new FileWriter(fichero);
			escritor.write(texto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (escritor != null) {
					escritor.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public Map<String, Integer> contarChar(String textoCompleto) {
		String vocales[] = {"a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú"};
		Map <String, Integer> contadores = new HashMap<String, Integer>();
		char car;
		int contVocales = 0;
		int contConsonantes = 0;
		int contEspeciales = 0;
		int contResto = 0;
		int contNumeros = 0;
		int contTotal = 0;
		
		for(int i=0; i<textoCompleto.length(); i++) {
			car = Character.toLowerCase(textoCompleto.charAt(i));
			
		
			if(Arrays.binarySearch(vocales, String.valueOf(car))>=0) {
				contVocales++;
			} else if(Character.isDigit(car)) {
				contNumeros++;
			} else if(Character.isLetter(car)) {
				contConsonantes++;
			} else if(Character.isWhitespace(car)) {
				contResto++;
			} else {
				contEspeciales++;
			}
			contTotal++;
		}
		contadores.put("vocales", contVocales);
		contadores.put("consonantes", contConsonantes);
	    contadores.put("especiales", contEspeciales);
	    contadores.put("resto", contResto);
	    contadores.put("numeros", contNumeros);
	    contadores.put("total", contTotal);
		
		return contadores;
	}	
	
}

