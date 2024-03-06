import java.util.Arrays;

public class Group {

    private Etudiant[] m_etudiants = new Etudiant[constantes.MAX_ELEVE];
    private int m_NbrGroupe = 0;
    private static int m_nbrEtudiants = 0;

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
   =============================================================
   */
    public void ajouterEtudiant(Etudiant unEtudiant) {
        if (m_nbrEtudiants < constantes.MAX_ELEVE) {
            m_etudiants[m_nbrEtudiants] = unEtudiant;
            m_nbrEtudiants++;
        }
    }

    public double moyenne() {
        double sum = 0;
        for (Etudiant etudiant : m_etudiants) {
            // si l'objet n'est pas initez alors arrete toi
            if (etudiant == null) break;
            sum += etudiant.getNote();
        }

        // retourne la moyenne du groupe
        return sum / m_nbrEtudiants;
    }

    public double tauxSucces() {
        int nbrEtudiantReussi = 0;f
        for (Etudiant etudiant : m_etudiants) {
            if (etudiant == null) break;

            if (etudiant.isSucces()) {
                ++nbrEtudiantReussi;
            }
        }
        // retourne le  taux de succès du groupe
        return (double) nbrEtudiantReussi / m_nbrEtudiants;
    }

    public double meilleur() {
        double tempNote = 0;
        for (Etudiant etudiant : m_etudiants) {
            if (etudiant == null) break;

            if (etudiant.getNote() >= tempNote) {
                tempNote = etudiant.getNote();
            }
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
            if (etudiant == null) break;
            sum += Math.pow(etudiant.getNote() - moyenne, 2);
        }

        //  Calcul de la variance
        return sum / m_nbrEtudiants;
    }

    public double ecartType() {
        return Math.sqrt(variance());
    }

    public String tostring()
    {
        StringBuilder sumOfString = new StringBuilder();
        for (int i = 0; i < m_nbrEtudiants; i++) {
            sumOfString.append(m_etudiants[i].toString());
        }
        return sumOfString.toString();
    }

    public static void main(String[] args) {
        String nom = "belilita";
        String prenom = "anas";
        int codePermanent = 65734;
        int anneeNaissance = 2004;
        int note = 70;


        Group grp = new Group(5000);

        Etudiant etudiant = new Etudiant(nom, prenom, codePermanent, anneeNaissance, note);
        Etudiant etudiant2 = new Etudiant("test", prenom, codePermanent, anneeNaissance, 90);
        Etudiant etudiant3 = new Etudiant("test2", prenom, codePermanent, anneeNaissance, 40);

        grp.ajouterEtudiant(etudiant);
        grp.ajouterEtudiant(etudiant2);
        grp.ajouterEtudiant(etudiant3);

        System.out.print("[moyenne()]\n");
        System.out.printf("La moyenne du group est de %.2f\n\n", grp.moyenne());

        System.out.print("[tauxSucces()]\n");
        System.out.printf("Le taux de succes dans ce groupe est de %.2f\n\n", grp.tauxSucces());

        System.out.print("[meilleur()]\n");
        System.out.printf("La meilleur note de cette class est de %.2f\n\n", grp.meilleur());

        System.out.print("[variance()]\n");
        System.out.printf("La variance de ce groupe est de %.2f\n\n", grp.variance());

        System.out.print("[ecartType()]\n");
        System.out.printf("L'ecrate type de ce groupe est de %.2f\n\n", grp.ecartType());

        System.out.print("[tostring()]");
        System.out.print(grp.tostring());
    }
}
