/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_byronlemuz;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author lesly
 */
public class Lab6P1_Byronlemuz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner bicho = new Scanner(System.in);
        Random random = new Random();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("+++++++++++Menú:+++++++++++");
            System.out.println("1. Rotacion ");
            System.out.println("2. Elemento perdido ");
            System.out.println("3. Punto de equilibrio ");
            System.out.println("4. Salir");
            System.out.println("***************************");
            System.out.print("Ingrese una opción: ");
            opcion = bicho.nextInt();
            switch (opcion) {
                case 1:
                    int continuar = 1;
                    while (continuar == 1) {
                        System.out.println("Ingrese el tamaño del array: ");
                        int tamaño = bicho.nextInt();
                        int[] arreglo = new int[tamaño];
                        for (int i = 0; i < tamaño; i++) {
                            arreglo[i] = random.nextInt(100);
                        }
                        System.out.println("Array generado: ");
                        imprimirArray(arreglo);
                        System.out.println("\n Ingrese el numero de posiciones a rotar: ");
                        int rotaciones = bicho.nextInt();
                        rotamosArray(arreglo, rotaciones);
                        System.out.println("\n Array rotado: ");
                        imprimirArray(arreglo);
                        System.out.println("\n Desea volver a generar otro array?: ");
                        continuar = bicho.nextInt();

                    }

                    break;
                case 2:
                    int continuarr = 1;
                    while (continuarr == 1) {
                        System.out.println("Ingrese el tamaño del array: ");
                        int tamañito = bicho.nextInt();
                        int[] arreglo = new int[tamañito];
                        System.out.println("Array ingresado: [");
                        for (int i = 0; i < tamañito; i++) {
                            arreglo[i] = bicho.nextInt();
                            System.out.println(arreglo[i]);
                            if (i < tamañito - 1) {
                                System.out.print(", ");
                            }

                        }
                        System.out.print("]\n");
                        int elementoPerdido = encontrarElementoqueestaperdidito(arreglo);
                        System.out.println("El elemento perdido es: " + elementoPerdido);
                        System.out.print("¿Desea volver a ingresar otro array?: ");
                        continuar = bicho.nextInt();

                    }
                    break;
                case 3:
                    int continuemos = 1;
                    while (continuemos == 1) {
                        System.out.println("Ingrese el tamaño del array: ");
                        int dimension = bicho.nextInt();
                        int[] arreglo = new int[dimension];
                        for (int i = 0; i < dimension; i++) {
                            arreglo[i] = random.nextInt(100);

                        }
                        System.out.println("Array generado; ");
                        imprimirArraydenumeros(arreglo);
                        int puntodeequilibrio = encontrarpuntodeequilirio(arreglo);
                        System.out.println("\nEl punto de equilibrio está en el índex: " + puntodeequilibrio + " (" + arreglo[puntodeequilibrio] + ")");
                        int sumaIzquierda = 0;
                        for (int i = 0; i < puntodeequilibrio; i++) {
                            sumaIzquierda += arreglo[i];
                        }
                        int sumaDerecha = 0;
                        for (int i = puntodeequilibrio + 1; i < arreglo.length; i++) {
                            sumaDerecha += arreglo[i];
                        }
                        System.out.println("Porque la suma en la izquierda es " + sumaIzquierda + " y en la derecha es " + sumaDerecha + ".");
                        System.out.print("¿Desea volver a generar otro array?: ");
                        continuar = bicho.nextInt();
                    }

                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    public static void imprimirArray(int[] arreglos) {
        System.out.print("[");
        for (int i = 0; i < arreglos.length; i++) {
            System.out.print(arreglos[i]);
            if (i < arreglos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int[] rotamosArray(int[] arreglos, int rotaciones) {
        int[] arraynuevo = new int[arreglos.length];
        for (int i = 0; i < arreglos.length; i++) {
            int nuevaPosicion = (i + rotaciones) % arreglos.length;
            if (nuevaPosicion < 0) {
                nuevaPosicion += arreglos.length;
            }
            arraynuevo[nuevaPosicion] = arreglos[i];
        }
        return arraynuevo;
    }

    public static int encontrarElementoqueestaperdidito(int[] arreglo) {
        int suma1 = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma1 += arreglo[i];
        }
        int primerElemento = arreglo[0];
        int ultimoElemento = arreglo[arreglo.length - 1];
        int suma2 = (primerElemento + ultimoElemento) * (arreglo.length + 1) / 2;
        return suma2 - suma1;

    }

    public static void imprimirArraydenumeros(int[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {

                System.out.print(",");

            }
        }
        System.out.print("]");

    }

    public static int encontrarpuntodeequilirio(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];

        }
        int sumaizquierda = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (sumaizquierda == suma - sumaizquierda - arreglo[i]) {
                return i;
            }
            sumaizquierda *= arreglo[i];
        }
        return -1;
    }

}
    
    


    

