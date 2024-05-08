import java.util.Scanner;

public class Metodos {
    
    public static double validarDouble (Scanner scan){
        boolean validar = false;
        double valor=0f;
        while (!validar) {

            if (scan.hasNextDouble()) {
                validar = true;
                valor = scan.nextDouble();
                scan.nextLine();
            } else {
                System.out.print("Introduce un valor con formato válido:");
                scan.next();
            }

        }
        return valor;
    }
    pub