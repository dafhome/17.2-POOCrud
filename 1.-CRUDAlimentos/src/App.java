import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static final String SEPARADOR = "------------------------------------------------------------";

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Alimentos> tienda = new ArrayList<>();
        Alimentos a1 = new Alimentos("Manzana", "Lleida", 1.5, 2.99);
        Alimentos a2 = new Alimentos("Tomate", "Andalucia", 3.5, 1.99);
        Alimentos a3 = new Alimentos("Naranja", "Valencia", 5, 2.99);

        tienda.add(a1);
        tienda.add(a2);
        tienda.add(a3);

        System.out.println();
        System.out.println("Bienvenido a la tienda de alimentación");
        System.out.println(SEPARADOR);
        int opcion = 0;
        boolean validar = false;
        while (!validar) {
            menu();
            opcion = Metodos.validarInt(scan);
            switch (opcion) {
                case 1:
                    Alimentos.addAlimento(scan, tienda);
                    break;
                case 2:
                    Alimentos.showAll(tienda);
                    break;

                case 3:
                    Alimentos.searchAlimento(scan, tienda);
                    break;
                case 4:
                    Alimentos.modifyAlimento(scan, tienda);
                    break;
                case 5:
                    Alimentos.removeAlimento(scan, tienda);
                    break;
                case 6:
                    Alimentos.moveAlimento(scan, tienda);
                    System.out.println(SEPARADOR);

                    break;
                case 0:
                    System.out.println();
                    System.out.println("Gracias por venir! Nos vemos otro día.");
                    validar = true;
                    break;
                default:
                    System.out.println("Introduce un valor válido para el menú.");
                    break;
            }
        }

        scan.close();
    }

    public static void menu() {
        System.out.println();
        System.out.println("¿Que quieres hacer hoy?");
        System.out.println("1.Añadir alimento");
        System.out.println("2.Mostrar todos los alimentos");
        System.out.println("3.Buscar producto");
        System.out.println("4.Modificar un producto");
        System.out.println("5.Borrar un producto");
        System.out.println("6.Mover producto a otra 'balda'");
        System.out.println("0.Salir");
        System.out.println(SEPARADOR);
        System.out.print("Opcion: ");
    }
}
