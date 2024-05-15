import java.util.Scanner;
import java.util.function.Function;

public class Entree {
    public static <T> T entree(String phrase, Function<String, T> convertisseur) {
        System.out.print(phrase);
        Scanner lect = new Scanner(System.in);
        return convertisseur.apply(lect.nextLine());
    }
}
