import java.util.ArrayList;
import java.util.Scanner;

public class Alimentos {

    private String nombre;
    private String origen;
    private double peso;
    private double precioKg;
    private double precio;
    static final String SEPARADOR = "------------------------------------------------------------";

    public Alimentos(String nombre, String origen, double peso, double precioKg) {
        this.nombre = nombre;
        this.origen = origen;
        this.peso = peso;
        this.precioKg = precioKg;
        this.precio = calcularPrecio(precioKg, peso);
    }

    public Alimentos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecioKg() {
        return precioKg;
    }

    public void setPrecioKg(double precioKg) {
        this.precioKg = precioKg;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Alimento: " + nombre + ", Origen: " + origen + ", Peso: " + peso + " kg, Precio/Kg: " + precioKg
                + "€, Precio Unidad: " + String.format("%.2f", precio) + "€";
    }

    private static double calcularPrecio(double precioKg, double peso) {
        return (precioKg * peso);
    }

    public static void addAlimento(Scanner scan, ArrayList<Alimentos> carro) {

        String alimento;
        String origen;
        double peso;
        double precioKg;

        System.out.println();
        System.out.println("Añadir Alimento");
        System.out.println();
        System.out.println("Vamos a añadir un alimento.");
        System.out.print("Alimento: ");
        alimento = scan.nextLine();
        System.out.print("Origen: ");
        origen = scan.nextLine();
        System.out.print("Peso: ");
        peso = Metodos.validarDouble(scan);
        System.out.print("Precio/Kg: ");
        precioKg = Metodos.validarDouble(scan);

        carro.add(new Alimentos(alimento, origen, peso, precioKg));

    }

    public static void showAll(ArrayList<Alimentos> carro) {
        System.out.println();
        System.out.println("Mostrar todos los Alimentos");
        System.out.println();
        for (Alimentos alimento : carro) {
            System.out.println(alimento);
        }
        System.out.println();
        System.out.println(SEPARADOR);

    }

    public static void searchAlimento(Scanner scan, ArrayList<Alimentos> carro) {
        System.out.println();
        System.out.println("Buscar Alimento");
        System.out.println();
        System.out.print("Alimento:");
        String buscar = scan.nextLine();
        int index = 0;
        int cont = 0;
        System.out.println();
        for (int i = 0; i < carro.size(); i++) {

            if (carro.get(i).nombre.toLowerCase().equalsIgnoreCase(buscar)) {
                index = i;
                cont++;
            }
        }
        if (cont > 0) {
            if (cont < 2) {
                System.out.println("El alimento buscado está en la posición " + (index + 1) + " y es el siguiente:");
                System.out.println(carro.get(index));
            } else {
                System.out.println("Lo siento, hay más de un alimento que se llaman igual.");
            }
        } else {
            System.out.println("No he encontrado ningún alimento con este nombre.");
        }
        System.out.println(SEPARADOR);
    }

    private static int searchAlimentoReturn(Scanner scan, ArrayList<Alimentos> carro) {

        System.out.println();
        System.out.print("Alimento:");
        String buscar = scan.nextLine();
        int index = 0;
        int cont = 0;
        for (int i = 0; i < carro.size(); i++) {

            if (carro.get(i).nombre.toLowerCase().equalsIgnoreCase(buscar)) {
                index = i;
                cont++;
            }

        }
        if (cont == 0) {
            index = -1;
        } else if (cont > 1) {
            index = -2;
        }
        return index;
    }

    public static void modifyAlimento(Scanner scan, ArrayList<Alimentos> carro) {
        System.out.println();
        System.out.println("Modificar Alimento");
        int index = searchAlimentoReturn(scan, carro);
        double valor = 0f;
        if (index == -2) {
            System.out.println("Lo siento, hemos encontrado más de un alimento a modificar.");
        } else if (index == -1) {
            System.out.println("Lo siento, no hemos encontrado el alimento que quieres modificar.");
        } else {
            String opcion;
            boolean validar = false;
            while (!validar) {
                menuModify(carro.get(index).getNombre());
                opcion = scan.nextLine();
                switch (opcion) {
                    case "1":
                        System.out.print("Alimento: ");
                        carro.get(index).setNombre(scan.nextLine());
                        validar = true;
                        break;
                    case "2":
                        System.out.print("Origen: ");
                        carro.get(index).setOrigen(scan.nextLine());
                        validar = true;
                        break;
                    case "3":
                        System.out.print("Peso: ");
                        valor = Metodos.validarDouble(scan);
                        carro.get(index).setPeso(valor);
                        carro.get(index).setPrecio(calcularPrecio(carro.get(index).getPrecioKg(), valor));
                        validar = true;
                        break;
                    case "4":
                        System.out.print("Precio/Kg: ");
                        valor = Metodos.validarDouble(scan);
                        carro.get(index).setPrecioKg(valor);
                        carro.get(index).setPrecio(calcularPrecio(valor, carro.get(index).getPeso()));
                        validar = true;
                        break;
                    case "0":
                        System.out.print("Alimento: ");
                        carro.get(index).setNombre(scan.nextLine());
                        System.out.print("Origen: ");
                        carro.get(index).setOrigen(scan.nextLine());
                        System.out.print("Peso: ");
                        valor = Metodos.validarDouble(scan);
                        carro.get(index).setPeso(valor);
                        System.out.print("Precio/Kg: ");
                        valor = Metodos.validarDouble(scan);
                        carro.get(index).setPrecioKg(valor);
                        carro.get(index).setPrecio(calcularPrecio(carro.get(index).getPrecioKg(), carro.get(index).getPeso()));
                        validar = true;
                        break;
                    default:
                        System.out.println("Indica una opción valida del menú.");
                        break;
                }
                System.out.println();
                System.out.println("Se ha modificado correctamente.");
            }

        }
        System.out.println(SEPARADOR);

    }

    public static void removeAlimento(Scanner scan, ArrayList<Alimentos> carro) {
        System.out.println();
        System.out.println("Eliminar Alimento");
        int index = searchAlimentoReturn(scan, carro);
        if (index == -2) {
            System.out.println("Lo siento, hemos encontrado más de un alimento a modificar.");
        } else if (index == -1) {
            System.out.println("Lo siento, no hemos encontrado el alimento que quieres modificar.");
        } else {
            System.out.println(
                    "¿Estas seguro de borrar el/la " + carro.get(index).getNombre() + "? Indica si para borrar");
            String validar = scan.nextLine();
            if (validar.equalsIgnoreCase("si")) {
                carro.remove(index);
                System.out.println();
                System.out.println("Se ha eliminado correctamente");
            } else {
                System.out.println();
                System.out.println("Uy! Casi lo borramos pero lo hemos evitado.");
            }
        }
        System.out.println(SEPARADOR);

    }

    public static void menuModify(String nombre) {

        System.out.pr