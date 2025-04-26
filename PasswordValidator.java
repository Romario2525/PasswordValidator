import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Validador de Contraseñas Concurrente 🛡️");
        System.out.println("---------------------------------------");

        System.out.print("¿Cuántas contraseñas deseas validar?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.print("\nIngresa la contraseña #" + (i + 1) + ": ");
            String password = scanner.nextLine();

            Thread validador = new Thread(new PasswordCheckTask(password));
            validador.start();
        }

        scanner.close();
    }
}