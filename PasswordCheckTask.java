public class PasswordCheckTask implements Runnable {

    private final String password;

    public PasswordCheckTask(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        validarPassword(password);
    }

    private void validarPassword(String password) {
        boolean esValida = true;

        if (password.length() < 8) {
            System.out.println("[❌] " + password + " -> Error: La contraseña debe tener al menos 8 caracteres.");
            esValida = false;
        }

        if (contarCoincidencias(password, "[A-Z]") < 2) {
            System.out.println("[❌] " + password + " -> Error: Debe contener al menos 2 letras mayúsculas.");
            esValida = false;
        }

        if (contarCoincidencias(password, "[a-z]") < 3) {
            System.out.println("[❌] " + password + " -> Error: Debe contener al menos 3 letras minúsculas.");
            esValida = false;
        }

        if (contarCoincidencias(password, "[0-9]") < 1) {
            System.out.println("[❌] " + password + " -> Error: Debe contener al menos 1 número.");
            esValida = false;
        }

        if (contarCoincidencias(password, "[^a-zA-Z0-9]") < 1) {
            System.out.println("[❌] " + password + " -> Error: Debe contener al menos 1 carácter especial.");
            esValida = false;
        }

        if (esValida) {
            System.out.println("[✅] " + password + " -> Contraseña válida.");
        }
    }

    private int contarCoincidencias(String texto, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        int contador = 0;
        while (matcher.find()) {
            contador++;
        }
        return contador;
    }
}