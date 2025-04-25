//Vip = 30000 
//platea = 15000
//general = 9000 

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;
public class teatroMoro7 {
    public static class informacion {
        String ubicacion;
        int pagaTotal, descuento;
    
        public informacion(String ubicacion, int pagaTotal, int descuento) {
            this.ubicacion = ubicacion;
            this.pagaTotal = pagaTotal;
            this.descuento = descuento;
        }

        public void mostrarInfo() {
            System.out.println("Ubicacion: " + ubicacion);
            System.out.println("Descuento: " + descuento + "%");
            System.out.println("Precio final: " + pagaTotal);
        }
    }

    public static informacion ventaDeEntradas(Scanner scanner) {
        List<String> entrada = new ArrayList<>();
        List<Integer> precioEntrada = new LinkedList<>();
        int descuento = 0, pagaTotal = 0;
        String seleccionEntrada, confirmarEdad;
        System.out.println("Seleccione la ubicacion");

        entrada.add(0, "Vip");
        entrada.add(1, "Platea");
        entrada.add(2, "General");

        precioEntrada.add(30000);
        precioEntrada.add(15000);
        precioEntrada.add(9000);

        for (int i = 0; i < entrada.size(); i++) {
            System.out.println(entrada.get(i) + ": " + precioEntrada.get(i));
        }

        seleccionEntrada = scanner.nextLine().trim().toLowerCase();

        int index = -1;
        for (int i = 0; i < entrada.size(); i++) {
            if (entrada.get(i).equalsIgnoreCase(seleccionEntrada)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            pagaTotal = precioEntrada.get(index);
            System.out.println("Has seleccionado: " + entrada.get(index));
        } else {
            System.out.println("Seleccione una ubicación válida.");
        }

        System.out.println("");
        System.out.println("¿Eres de la tercera edad o estudiante?");

        confirmarEdad = scanner.nextLine().trim().toLowerCase();

        if (confirmarEdad.equals("tercera edad")) {
            System.out.println("Eres de la tercera edad se aplicara un descuento de 10%");
            descuento = 10;
        } else if (confirmarEdad.equals("estudiante")) {
            System.out.println("Eres estudiante se aplicara un descuento de 15%");
            descuento = 15;
        }
        else if (confirmarEdad.equals("publico general") || confirmarEdad.equals("ninguno")) {
            System.out.println("Eres publico general");
        }
        else {
            System.out.println("Confirme si eres tercera edad o estudiante");
        }

        pagaTotal = pagaTotal - (pagaTotal * descuento / 100);
        String ubicacion = entrada.get(index);

        return new informacion(ubicacion, pagaTotal, descuento);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;

        System.out.println("");

        System.out.println("Bienvenido al teatro Moro");
        do {
            System.out.println("1- Venta de entradas");
            System.out.println("2- Visualizar resumen de entradas");
            System.out.println("3- Generar bolta");
            System.out.println("4- Calcular ingresos totales");
            System.out.println("5- Salir del programa");

            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    ventaDeEntradas(scanner);
                    break;
                case 2:

                case 3:

                case 4:

                case 5:

                default:
                    break;
            }
        } while (menu != 5);
    }

}
