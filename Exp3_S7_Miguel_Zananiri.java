//Vip = 30000 
//platea = 15000
//general = 9000 

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Exp3_S7_Miguel_Zananiri {
    static int totalVentas = 0;
    static int numeroVentasVip = 0;
    static int numeroVentasPlatea = 0;
    static int numeroVentasGeneral = 0;
    public static class informacion {
        String ubicacion;
        int pagaBase, pagaTotal, descuento;

        public informacion(String ubicacion, int pagaTotal, int descuento, int pagaBase) {
            this.ubicacion = ubicacion;
            this.pagaBase = pagaBase;
            this.descuento = descuento;
            this.pagaTotal = pagaTotal;
        }

        public void mostrarInfo() {
            System.out.println("Ubicacion: " + ubicacion);
            System.out.println("Costo Base " + pagaBase);
            System.out.println("Descuento Aplicado: " + descuento + "%");
            System.out.println("Costo Final: " + pagaTotal);
        }
    }

    public static informacion ventaDeEntradas(Scanner scanner) {
        List<String> entrada = new ArrayList<>();
        List<Integer> precioEntrada = new LinkedList<>();
        int descuento = 0, pagaTotal = 0, pagaBase = 0, index = -1;
        String seleccionEntrada, confirmarEdad, confirmarPago;
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

        while (true) {
            seleccionEntrada = scanner.nextLine().trim().toLowerCase();

            for (int i = 0; i < entrada.size(); i++) {
                if (entrada.get(i).equalsIgnoreCase(seleccionEntrada)) {
                    index = i;
                    pagaBase = precioEntrada.get(index);
                    break;
                }
            }
    
            if (index != -1) {
                pagaTotal = precioEntrada.get(index);
                System.out.println("Has seleccionado: " + entrada.get(index));
                System.out.println("");
                break;
            } else {
                System.out.println("Seleccione una ubicación válida.");
                System.out.println("");
            }
        }
        System.out.println("¿Eres de la tercera edad o estudiante?");

        while (true) {
            confirmarEdad = scanner.nextLine().trim().toLowerCase();

            if (confirmarEdad.equals("tercera edad")) {
                System.out.println("Eres de la tercera edad se aplicara un descuento de 10%");
                descuento = 10;
                System.out.println("");
                break;
            } else if (confirmarEdad.equals("estudiante")) {
                System.out.println("Eres estudiante se aplicara un descuento de 15%");
                descuento = 15;
                System.out.println("");
                break;
            } else if (confirmarEdad.equals("publico general") || confirmarEdad.equals("ninguno")) {
                System.out.println("Eres publico general");
                System.out.println("");
                break;
            } else {
                System.out.println("Confirme si eres tercera edad o estudiante");
            }

            pagaTotal = pagaTotal - (pagaTotal * descuento / 100);
        }

        String ubicacion = entrada.get(index);

        System.out.println("¿Confirmar pago? (si/no)");

        while (true) {
            confirmarPago = scanner.nextLine().trim().toLowerCase();

            if (confirmarPago.equals("si")) {
                System.out.println("Pago confirmado");
                System.out.println("");
                return new informacion(ubicacion, pagaTotal, descuento, pagaBase);
            } else if (confirmarPago.equals("no")) {
                System.out.println("Pago cancelado");
                System.out.println("");
                return null;
            } else {
                System.out.println("Confirme si desea confirmar el pago");
            }
    
        }

    }

    public static void visualizarResumenEntradas(informacion info) {
        info.mostrarInfo();
        System.out.println("");
    }

    public static void generarBoleta(informacion info) {
        System.out.println("--------------------------------");
        System.out.println("          Teatro Moro           ");
        System.out.println("--------------------------------");
        info.mostrarInfo();
        System.out.println("--------------------------------");
        System.out.println("Gracias por su visita al Teatro Moro");
        System.out.println("--------------------------------");
    }

    public static void CalcularIngresosTotales(List<informacion> entradas) {
        for (informacion venta : entradas) {
            totalVentas += venta.pagaTotal;
        }
        System.out.println("");
        System.out.println("Numero de ventas vip: " + numeroVentasVip);
        System.out.println("Numero de ventas platea: " + numeroVentasPlatea);
        System.out.println("Numero de ventas general: " + numeroVentasGeneral);
        System.out.println("Total de ventas: " + totalVentas);
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<informacion> informacionEntradas = new ArrayList<>();
        int menu;

        System.out.println("");

        System.out.println("Bienvenido al teatro Moro");
        do {
            System.out.println("1- Venta de entradas");
            System.out.println("2- Visualizar resumen de entradas");
            System.out.println("3- Calcular ingresos totales");
            System.out.println("4- Salir del programa");

            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    informacion nuevaVenta = ventaDeEntradas(scanner);
                    if (nuevaVenta != null) {
                        informacionEntradas.add(nuevaVenta);
                        generarBoleta(nuevaVenta);
                    }

                    if (nuevaVenta.ubicacion.equalsIgnoreCase("vip")) {
                        numeroVentasVip++;
                    }
                    else if (nuevaVenta.ubicacion.equalsIgnoreCase("platea")) {
                        numeroVentasPlatea++;
                    }
                    else if (nuevaVenta.ubicacion.equalsIgnoreCase("general")) {
                        numeroVentasGeneral++;
                    }

                    break;
                case 2:
                    if (informacionEntradas.isEmpty()) {
                        System.out.println("Esta vacio");
                        System.out.println("");
                    } else {
                        System.out.println("Resumen de entradas:");
                        System.out.println("");
                        for (int i = 0; i < informacionEntradas.size(); i++) {
                            visualizarResumenEntradas(informacionEntradas.get(i));
                        }
                    }
                    break;
                case 3:
                    if (informacionEntradas.isEmpty()) {
                        System.out.println("Esta vacio");
                        System.out.println("");
                    } else {
                        CalcularIngresosTotales(informacionEntradas);
                    }
                    break;
                case 4:
                    System.out.println("Gracias por su compra");
                    return;
                default:
                    break;
            }
        } while (menu != 4);
    }

}
