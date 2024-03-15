import java.util.Scanner;               // Menu.java --> ALi
import java.util.function.Function;

public class Menu {
    /* =============================================================
     *                       méthode
     * ============================================================== */
    private static <T> T entree(String phrase, Function<String, T> convertisseur) {
        System.out.print(phrase);
        Scanner lect = new Scanner(System.in);
        return convertisseur.apply(lect.nextLine());
    }
    public static void afficherMenu() {
        System.out.print("\n\n------MENU------\n\n");
        System.out.print("1. Inscrire\n");
        System.out.print("2. Lister\n");
        System.out.print("3. Statistiques\n");
        System.out.print("4.Quitter\n");
    }

    public static selection saisirChoixUtilisateur() {
        int choix = entree("choix: ", Integer::valueOf);

        while (!ChoixValide(choix)) {
            System.out.print("[ERREUR] Votre selection n'est pas bonne. Veuillez entrer un nombre entre 1 et 4.\n");
            choix = entree("choix: ", Integer::valueOf);
        }

        return selection.values()[choix - 1];
    }

    private static boolean ChoixValide(int choix) {
        return choix >= 0 && choix <= selection.values().length;
    }

    public static boolean traiterChoixUtilisateur(selection choix, Group grp)
    {
        return switch (choix) {
            case Inscrire -> {
                InscrireEtudiant(grp);
                yield true;
            }
            case Lister -> {
                System.out.print(grp.toString());
                yield true;
            }
            case Statistiques -> {
                afficherStatistique(grp);
                yield true;
            }
            case Quitter -> {
                System.out.println("Vous avez quittez le menu!");
                yield false;
            }
        };
    }

    private static void InscrireEtudiant(Group grp)
    {
        Etudiant etudiant = new Etudiant(
                entree("Donnez le nom de l'eleve: ", Function.identity()),
                entree("Donner le prénom de l'eleve : " , Function.identity()),
                entree("Donner l'année de naissance de l'éleve: ", Integer::valueOf),
                entree("Donner la note de l'éleve: ", Integer::valueOf)
        );
        grp.ajouterEtudiant(etudiant);
    }

    private static void afficherStatistique(Group grp)
    {
        System.out.printf("\nLa moyenne du group est de %.2f\n", grp.moyenne());
        System.out.printf("Le taux de succes dans ce groupe est de %.2f\n", grp.tauxSucces());
        System.out.printf("La meilleur note de cette class est de %.2f\n", grp.meilleur());
        System.out.printf("La variance de ce groupe est de %.2f\n", grp.variance());
        System.out.printf("L'ecrate type de ce groupe est de %.2f\n", grp.ecartType());
    }

    /* =============================================================
     *                       Point de test
     * ============================================================== */

    public static void main(String[] args) {
        Group grp = new Group(6776);
        boolean isAlive = true;

        while (isAlive) {
            afficherMenu();
            isAlive = traiterChoixUtilisateur(saisirChoixUtilisateur(), grp);
        }

    }
}
