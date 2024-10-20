package M1_T06_P25;

import java.util.List;

public class OrdPalNumInc extends AlgoritmoOrdenacion{
	
	@Override
    public void ordena(List<Carta> listaCartas) {
        // Algoritmo de ordenaci�n
	  for (int i = 0; i < listaCartas.size() - 1; i++) {
        for (int j = 0; j < listaCartas.size() - 1 - i; j++) {
          if (comparadorCarta(listaCartas.get(j), listaCartas.get(j + 1)) > 0) {
            // Intercambiar cartas si están en el orden incorrecto
            Carta temp = listaCartas.get(j);
            listaCartas.set(j, listaCartas.get(j + 1));
            listaCartas.set(j + 1, temp);
          }
        }
      }
    }

    public static int comparadorCarta(Carta c1, Carta c2) {
        // Comparador de cartas usado en el algoritmo de ordenaci�n
    	// Primero comparamos por palo
      int paloComparison = c1.getPalo().compareTo(c2.getPalo());
      if (paloComparison == 0) {
            // Si son del mismo palo, comparamos por número
        return compararNumeros(c1.getNumero(), c2.getNumero());
      }
      return paloComparison;
    }
    
    private static int compararNumeros(String numero1, String numero2) {
      // Definimos un orden específico para los números
      String[] ordenNumeros = {"AS", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "SOTA", "CABALLO", "REY"};
        
      // Convertimos cada número a su índice en el orden definido
      int index1 = obtenerIndice(numero1, ordenNumeros);
      int index2 = obtenerIndice(numero2, ordenNumeros);

      // Comparar los índices
      return Integer.compare(index1, index2);
    }
    
    private static int obtenerIndice(String numero, String[] ordenNumeros) {
      for (int i = 0; i < ordenNumeros.length; i++) {
        if (ordenNumeros[i].equals(numero)) {
          return i; // Retorna el índice si encuentra el número
        }
      }
      return -1; // En caso de no encontrar, retorna -1
    }

}
