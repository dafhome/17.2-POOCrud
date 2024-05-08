import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static final String SEPARADOR = "------------------------------------------------------------";

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Alimentos> tienda = new ArrayList<>();
        Alimentos a1 = new Alimentos("Manzana",