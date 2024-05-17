import java.util.function.Function;
import javax.swing.JOptionPane;

public abstract class Entree {
    public static <T> T entree(String message, Function<String, T> parser) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                if (input == null) { // l'utilisateur a cliqué sur "Annuler"
                    return null;
                }
                return parser.apply(input);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrée invalide, veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}