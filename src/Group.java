public class Group {

    private Etudiant[] m_etudiants = new Etudiant[constantes.MAX_ELEVE];
    private int m_NbrGroupe = 0;
    private int m_nbrEtudiants = 0;

    /*
    =============================================================
    getter setter
    =============================================================
    */
    Group(int NbrGroupe) {
        m_NbrGroupe = NbrGroupe;
    }

    public int getNbrEtudiants() {
        return m_nbrEtudiants;
    }

    public void setNbrEtudiants(int nbrEtudiants) {
        m_nbrEtudiants = nbrEtudiants;
    }

    public int getNbrGroupe() {
        return m_NbrGroupe;
    }

    public void setNbrGroupe(int nbrgroupe) {
        this.m_NbrGroupe = nbrgroupe;
    }

    public Etudiant[] getEtudiants() {
        return m_etudiants;
    }

    public void setEtudiants(Etudiant[] m_etudiants) {
        this.m_etudiants = m_etudiants;
    }

    /*
   =======================================================
   méthode
   =======================================================
   */
    public void ajouterEtudiant(Etudiant unEtudiant) {
        if (m_nbrEtudiants <= constantes.MAX_ELEVE) {
            m_etudiants[m_nbrEtudiants] = unEtudiant;
            m_nbrEtudiants++;
        }
    }

    public double moyenne() {
        double sum = 0;
        for (Etudiant etudiant : m_etudiants) {
            // si l'objet n'est pas initez alors arrete toi
            if (etudiant != null)
                sum += etudiant.getNote();
        }

        // retourne la moyenne du groupe
        return sum / m_nbrEtudiants;
    }

    public double tauxSucces() {
        int nbrEtudiantReussi = 0;
        for (Etudiant etudiant : m_etudiants) {
            if (etudiant != null && etudiant.isSucces())
                ++nbrEtudiantReussi;
        }
        // retourne le  taux de succès du groupe
        return (double) nbrEtudiantReussi / m_nbrEtudiants;
    }

    public double meilleur() {
        double tempNote = 0;
        for (Etudiant etudiant : m_etudiants) {
            if (etudiant != null && etudiant.getNote() >= tempNote)
                tempNote = etudiant.getNote();
        }
        return tempNote;
    }

    /*
        L'équation mathématique utilisée pour déterminer l'écart-type et variance provient des sites suivant :
        - https://fr.khanacademy.org/math/be-4eme-secondaire2/x213a6fc6f6c9e122:statistiques/x213a6fc6f6c9e122:parametres-de-dispersion/a/calculating-standard-deviation-step-by-step#:~:text=Comment%20calculer%20l'%C3%A9cart%2Dtype&text=1%20%2D%20On%20calcule%20la%20moyenne,l'effectif%20de%20la%20s%C3%A9rie.
        - https://byjus.com/maths/difference-between-variance-and-standard-deviation
    */
    public double variance() {
        double moyenne = moyenne();
        double sum = 0;

        for (Etudiant etudiant : m_etudiants) {
            if (etudiant != null)
                sum += Math.pow(etudiant.getNote() - moyenne, 2);
        }

        //  Calcul de la variance
        return sum / m_nbrEtudiants;
    }

    public double ecartType() {
        return Math.sqrt(variance());
    }

    public String toString()
    {
        StringBuilder sumOfString = new StringBuilder();
        for (Etudiant etudiant: m_etudiants) {
            if (etudiant != null)
                sumOfString.append(etudiant.toString());
        }
        return sumOfString.toString();
    }

    public static void main(String[] args) {

        Etudiant etudiant = new Etudiant("belilita", "anas", 65734, 2004, 90);
        Etudiant etudiant2 = new Etudiant("yacine", "test", 89695, 2000, 10);
        Etudiant etudiant3 = new Etudiant("amine", "test2", 65758, 2003, 10);
        Group grp = new Group(5000);

        grp.ajouterEtudiant(etudiant);
        grp.ajouterEtudiant(etudiant2);
        grp.ajouterEtudiant(etudiant3);

        // resultat

        System.out.printf("[m_NbrGroupe] %d\n", grp.getNbrGroupe());
        System.out.printf("[m_NbrGroupe] %d\n", grp.getNbrEtudiants());
        System.out.printf("[m_etudiants] %s \n", grp.toString());

        System.out.printf("[moyenne]   \nLa moyenne du group est de %.2f\n\n", grp.moyenne());
        System.out.printf("[tauxSucces]\nLe taux de succes dans ce groupe est de %.2f\n\n", grp.tauxSucces());
        System.out.printf("[meilleur]  \nLa meilleur note de cette class est de %.2f\n\n", grp.meilleur());
        System.out.printf("[variance]  \nLa variance de ce groupe est de %.2f\n\n", grp.variance());
        System.out.printf("[ecartType] \nL'ecrate type de ce groupe est de %.2f\n\n", grp.ecartType());

    }
}
