import java.util.Scanner;
import java.util.function.Function;

public class menu {
    public static <T> T entree(String phrase, Function<String, T> convertisseur) {
        System.out.print(phrase);
        Scanner lect = new Scanner(System.in);
        return convertisseur.apply(lect.next());
    }

    public static void main(String[] args) {

        Group grp = new Group(6776);
        Etudiant etudiant;

        selection slct;
        int choix;


        boolean isAlive = true;
        while (isAlive) {
            System.out.print("\n\n------MENU------\n\n");
            System.out.print("1. Inscrire\n");
            System.out.print("2. Lister\n");
            System.out.print("3. Statistiques\n");
            System.out.print("4.Quitter\n");
            choix = entree("choix: ", Integer::valueOf);


            if (choix >= 0 && choix <= selection.values().length)
            {
                slct = selection.values()[choix - 1];
                switch (slct) {
                    case Inscrire: {
                        etudiant = new Etudiant();
                        // entree les information de l'eleve
                        etudiant.setnom(entree("Donnez moi le nom de l'eleve: ", Function.identity()));
                        etudiant.setPrenom(entree("Donner moi le prénom de l'eleve : " , Function.identity()));
                        etudiant.setAnneeNaissance(entree("Donner l'année de naissance de l'éleve: ",Integer::valueOf));
                        etudiant.setCodePermanent(entree("Donner le code permanent: ",Integer::valueOf));
                        etudiant.setNote(entree("Donner la note de l'éleve: ",Integer::valueOf));

                        grp.ajouterEtudiant(etudiant);
                        break;
                    }
                    case Lister: {
                        System.out.print(grp.toString());
                        break;
                    }
                    case Statistiques: {
                        System.out.printf("La moyenne du group est de %.2f\n\n", grp.moyenne());
                        System.out.printf("Le taux de succes dans ce groupe est de %.2f\n\n", grp.tauxSucces());
                        System.out.printf("La meilleur note de cette class est de %.2f\n\n", grp.meilleur());
                        System.out.printf("La variance de ce groupe est de %.2f\n\n", grp.variance());
                        System.out.printf("L'ecrate type de ce groupe est de %.2f\n\n", grp.ecartType());
                        break;
                    }
                    case Quitter: {
                        System.out.println("Vous avez quittez le menu!");
                        isAlive = false;
                        break;
                    }
                }
            } else {
                System.out.print("[ERREUR] Ta selection n'est pas bonne. Veuillez entrer un nombre entre 1 et 4.");
            }
        }
    }
}



