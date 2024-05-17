import java.util.function.Function;
import javax.swing.JOptionPane;

public class Menu extends Entree {
    /* =============================================================
     *                       méthode
     * ============================================================== */
    public static void afficherMenu() {
        String menu = "------MENU------\n\n" +
                      "1. Inscrire\n" +
                      "2. Lister\n" +
                      "3. Statistiques\n" +
                      "4. Quitter\n";
        JOptionPane.showMessageDialog(null, menu, "Menu", JOptionPane.INFORMATION_MESSAGE);
    }

    public static selection saisirChoixUtilisateurSelection() {
        int choix = entree("choix: ", Integer::valueOf);

        while (!ChoixValide(choix)) {
            JOptionPane.showMessageDialog(null,"[ERREUR] Votre selection n'est pas bonne. Veuillez entrer un nombre entre 1 et 4.", "Erreur", JOptionPane.ERROR_MESSAGE);
            choix = entree("choix: ", Integer::valueOf);
        }

        return selection.values()[choix - 1];
    }

    public static typeEtudiant saisirChoixUtilisateurTypeEtudiant() {
        int choix = entree("choix: ", Integer::valueOf);

        while (!ChoixValide(choix)) {
            JOptionPane.showMessageDialog(null, "[ERREUR] Votre selection n'est pas bonne. Veuillez entrer un nombre entre 1 et 4.", "Erreur", JOptionPane.ERROR_MESSAGE);
            choix = entree("choix: ", Integer::valueOf);
        }

        return typeEtudiant.values()[choix - 1];
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
                JOptionPane.showMessageDialog(null, grp.toString(), "Liste des étudiants", JOptionPane.INFORMATION_MESSAGE);
                yield true;
            }
            case Statistiques -> {
                afficherStatistique(grp);
                yield true;
            }
            case Quitter -> {
                JOptionPane.showMessageDialog(null, "Vous avez quittez le menu!", "Quitter", JOptionPane.INFORMATION_MESSAGE);
                yield false;
            }
        };
    }

    private static void InscrireEtudiant(Group grp)
    {
        typeEtudiant choixEtudiant = saisirChoixUtilisateurTypeEtudiant();
        Etudiant etudiant;
        switch (choixEtudiant)
        {
            case ordinaire ->
            {
                etudiant = new Etudiant(
                        entree("Donnez le nom de l'élève: ", Function.identity()),
                        entree("Donner le prénom de l'élève : " , Function.identity()),
                        entree("Donner l'année de naissance de l'élève: ", Integer::valueOf),
                        entree("Donner la note de l'élève ", Integer::valueOf)
                );
                grp.ajouterEtudiant(etudiant);
            }
            case adaptation ->
            {
                etudiant = new EtudiantAdaptation(
                        entree("Donnez le nom de l'élève: ", Function.identity()),
                        entree("Donner le prénom de l'élève : " , Function.identity()),
                        entree("Donner l'historique des incidents de l'élève : " , Function.identity()),
                        entree("Donnez la coteS de l'élève: ", Integer::valueOf),
                        entree("Donner l'année de naissance de l'élève: ", Integer::valueOf),
                        entree("Donner la note de l'élève ", Integer::valueOf)
                );
                grp.ajouterEtudiant(etudiant);
            }
            case difficulter ->
            {
                etudiant = new EtudiantDifficulte(
                        entree("Donnez le nom de l'élève: ", Function.identity()),
                        entree("Donner le prénom de l'élève : " , Function.identity()),
                        entree("Donner le tpe de touble que l'élève a causer : " , Function.identity()),
                        entree("Donnez la coteS de l'élève: ", Integer::valueOf),
                        entree("Donner l'année de naissance de l'élève: ", Integer::valueOf),
                        entree("Donner la note de l'élève ", Integer::valueOf)
                );
                grp.ajouterEtudiant(etudiant);
            }
        }
    }

    private static void afficherStatistique(Group grp)
    {
        String statistiques = String.format(
            "La moyenne du groupe est de %.2f\n" +
            "Le taux de succès dans ce groupe est de %.2f\n" +
            "La meilleure note de cette classe est de %.2f\n" +
            "La variance de ce groupe est de %.2f\n" +
            "L'écart type de ce groupe est de %.2f\n",
            grp.moyenne(), grp.tauxSucces(), grp.meilleur(), grp.variance(), grp.ecartType()
        );
        JOptionPane.showMessageDialog(null, statistiques, "Statistiques", JOptionPane.INFORMATION_MESSAGE);
    }

    /* =============================================================
     *                       Point de test
     * ============================================================== */

    public static void main(String[] args) {
        Group grp = new Group(6776);
        boolean isAlive = true;

        while (isAlive) {
            afficherMenu();
            isAlive = traiterChoixUtilisateur(saisirChoixUtilisateurSelection(), grp);
        }

    }
}
