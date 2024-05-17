import javax.swing.*;

// Fait par mohammed Anas Belilita
//Bonus 1 et tests/bugs fait par Riad
public class Group {

    private Etudiant[] etudiantsRegulier = new Etudiant[constantes.MAX_ELEVE];
    private int nbrGroupe = 0;
    private int nbrEtudiants = 0;

    /* =============================================================
    *                        getter setter
    * ============================================================== */
    Group(int NbrGroupe) { this.nbrGroupe = NbrGroupe; }

    public int getNbrEtudiants() { return this.nbrEtudiants; }

    public void setNbrEtudiants(int nbrEtudiants) { this.nbrEtudiants = nbrEtudiants; }

    public int getNbrGroupe() { return this.nbrGroupe; }

    public void setNbrGroupe(int nbrgroupe) { this.nbrGroupe = nbrgroupe; }

    public Etudiant[] getEtudiants() { return this.etudiantsRegulier; }

    public void setEtudiants(Etudiant[] etudiants) { this.etudiantsRegulier = etudiants; }

    /* =============================================================
    *                       méthode
    * ============================================================== */
    // j ai resoue ce probleme a la vavite stp utilise generic
    public void ajouterEtudiant(Etudiant unEtudiant)
    {
        try{
            if(this.nbrEtudiants > constantes.MAX_ELEVE)
                throw new IllegalAccessException("vous avez atteint le maximum d'eleve");

            this.etudiantsRegulier[this.nbrEtudiants] = unEtudiant;
            this.nbrEtudiants++;
        } catch (IllegalAccessException e){
            JOptionPane.showMessageDialog(null, "[Erreur] " + e.getMessage());
        }
    }

    public double moyenne() {
        try
        {
            double sum = 0;

            for (Etudiant etudiant : this.etudiantsRegulier)
            {
                // si l'objet n'est pas initez alors arrete toi
                if (etudiant != null)
                    sum += etudiant.getNote();
            }

            if (this.nbrEtudiants <= 0)
                throw new IllegalAccessException("le nombre d'etudiant doit etre plus grand que 0");

            // retourne la moyenne du groupe
            return sum / this.nbrEtudiants;
        }catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "[Erreur] " + e.getMessage());
        }
        return 0;
    }

    public double tauxSucces() {
        try{
            int nbrEtudiantReussi = 0;
            for (Etudiant etudiant : this.etudiantsRegulier)
            {
                if (etudiant != null && etudiant.isSucces())
                    ++nbrEtudiantReussi;
            }

            if (nbrEtudiantReussi <= 0)
                throw new IllegalAccessException("le nombre d'etudiant reussi doit etre plus grand que 0");

            // retourne le  taux de succès du groupe
            return (double) nbrEtudiantReussi / this.nbrEtudiants;
        } catch(IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "[Erreur] " + e.getMessage());
        }
        return 0;
    }

    public double meilleur() {
        double tempNote = 0;
        for (Etudiant etudiant : this.etudiantsRegulier)
        {
            if (etudiant != null && etudiant.getNote() >= tempNote)
                tempNote = etudiant.getNote();
        }
        return tempNote;
    }

    /*
        L'équation mathématique utilisée pour déterminer l'écart-type et la variance provient des sites suivant :
        - https://fr.khanacademy.org/math/be-4eme-secondaire2/x213a6fc6f6c9e122:statistiques/x213a6fc6f6c9e122:parametres-de-dispersion/a/calculating-standard-deviation-step-by-step#:~:text=Comment%20calculer%20l'%C3%A9cart%2Dtype&text=1%20%2D%20On%20calcule%20la%20moyenne,l'effectif%20de%20la%20s%C3%A9rie.
        - https://byjus.com/maths/difference-between-variance-and-standard-deviation
    */
    public double variance() {
        try{
            double moyenne = moyenne();
            double sum = 0;

            for (Etudiant etudiant : this.etudiantsRegulier)
            {
                if (etudiant != null)
                    sum += Math.pow(etudiant.getNote() - moyenne, 2);
            }

            if (this.nbrEtudiants <= 0)
                throw new IllegalAccessException("le nombre d'etudiant doit etre plus grand que 0");

            //  Calcul de la variance
            return sum / this.nbrEtudiants;
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "[Erreur] " + e.getMessage());
        }
        return 0;
    }

    public double ecartType() {
        return Math.sqrt(variance());
    }

    public String toString()
    {
        StringBuilder sumOfString = new StringBuilder();
        for (Etudiant etudiant: this.etudiantsRegulier)
        {
            if (etudiant != null)
                sumOfString.append(etudiant.toString());
        }
        return sumOfString.toString();
    }

    /* =============================================================
     *                       Point de test
     * ============================================================== */

    public static void main(String[] args) {

        Etudiant etudiant = new Etudiant("belilita", "anas", 2004, 90);
        Etudiant etudiant2 = new Etudiant("yacine", "test", 2000, 10);
        Etudiant etudiant3 = new Etudiant("amine", "test2", 2003, 10);
        Group grp = new Group(3);

        grp.ajouterEtudiant(etudiant);
        grp.ajouterEtudiant(etudiant2);
        grp.ajouterEtudiant(etudiant3);

        JOptionPane.showMessageDialog(null, "[nbrGroupe] " + grp.getNbrGroupe());
        JOptionPane.showMessageDialog(null, "[nbrEtudiants] " + grp.getNbrEtudiants());
        JOptionPane.showMessageDialog(null, "[etudiants] " + grp.toString());

        JOptionPane.showMessageDialog(null, "[moyenne] La moyenne du group est de" + grp.moyenne());
        JOptionPane.showMessageDialog(null,"[tauxSucces] Le taux de succes dans ce groupe est d" + grp.tauxSucces());
        JOptionPane.showMessageDialog(null, "[meilleur]  La meilleur note de cette class est de" + grp.meilleur());
        JOptionPane.showMessageDialog(null, "[variance]  La variance de ce groupe est de" + grp.variance());
        JOptionPane.showMessageDialog(null, "[ecartType] L'ecrate type de ce groupe est de" + grp.ecartType());

    }
}
