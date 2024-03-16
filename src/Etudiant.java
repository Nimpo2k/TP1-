// Fait par mohammed Anas Belilita
//Bonus 1 et tests/bugs fait par Riad
import java.util.Scanner;
import java.util.function.Function;

import java.util.Scanner;
import java.util.function.Function;

public class Etudiant {
    private String m_nom = "nom inconnue";
    private String m_prenom = "prénom inconnue";
    private String m_codePermanent = "";
    private int m_anneeNaissance = 0;
    private int m_note = 0;

    Etudiant(String nom, String prenom, int anneeNaissance, int note)
    {
        setPrenom(prenom);
        setnom(nom);
        setNote(note);
        setCodePermanent(nom, prenom, anneeNaissance);
        setAnneeNaissance(anneeNaissance);
    }

    Etudiant()
    {}


    /* =============================================================
    *                        getter setter
    * ============================================================== */
    public String getnom() {
        return m_nom;
    }

    public void setnom(String nom) {
        while(contientUnNbr(nom))
        {
            System.out.print("[ERROR] le nom ne doit pas contenir un nombre\n");
            m_nom = nom = entree("Donner le nom de l'eleve : ", Function.identity());
         }
        m_nom = nom;
    }

    public String getprenom() {
        return m_prenom;
    }

    public void setPrenom(String prenom) {
        while(contientUnNbr(prenom))
        {
            System.out.print("[ERROR] le prenom ne doit pas contenir un nombre\n");
            m_prenom = prenom = entree("Donner le prenom de l'eleve : ", Function.identity());
        }
        m_prenom = prenom;
    }


    public void setCodePermanent(String nom, String prenom, int anneeNaissance) {
        char codeNom     = getFirstCharacter(nom);
        char codePrenom  = getFirstCharacter(prenom);
        String codeAnnee = integerToString(anneeNaissance);

        m_codePermanent = String.valueOf(codeNom) + String.valueOf(codePrenom) + codeAnnee;
    }

    public String getCodePermanent() { return m_codePermanent; }

    public int getAnneeNaissance() { return m_anneeNaissance; }

    public void setAnneeNaissance(int anneeNaissance) { m_anneeNaissance = anneeNaissance; }

    public int getNote() { return m_note; }
    

    public void setNote(int note) {
        while(noteValide(note))
        {
            System.out.print("[ERROR] le note ne doit pas contenir un nombre\n");
            m_note = note = entree("Donner le note de l'eleve : ", Integer::valueOf);
        }
        m_note = note;
    }

    private boolean noteValide(int note) {
        return note < 0 || note > 100;
    }



    /* =============================================================
    *                           méthode
    * ============================================================== */
    private static <T> T entree(String phrase, Function<String, T> convertisseur) {
        System.out.print(phrase);
        Scanner lect = new Scanner(System.in);
        return convertisseur.apply(lect.nextLine());
    }
    public char getFirstCharacter(String word) {
        char character = word.charAt(0);
        return Character.toUpperCase(character);
    }

    public String integerToString(int number) {
        return Integer.toString(number);
    }

    private boolean contientUnNbr(String phrase) {
        for (char caractere : phrase.toCharArray()) {
            if (Character.isDigit(caractere)) 
                return true;
        }
        return false;
    }

    public boolean isSucces(){
        int notePassage = 60;
        return m_note >= notePassage;
    }

    public char noteLitterale(){
        return  m_note >= 80 && m_note <= 100 ? 'A' :
                m_note >= 60 && m_note <= 80  ? 'B' :
                m_note >= 40 && m_note <= 60  ? 'C' : 'D';
    }
    
    public String toString(){
        return String.format("\n\n[code] %s\n[nom] %s\n[prénom] %s\n[année] %d\n[note] %d\n",
                m_codePermanent,
                m_nom,
                m_prenom,
                m_anneeNaissance,
                m_note);
    }

    /* =============================================================
     *                       Point de test
     * ============================================================== */

   public static void main(String[] args) {
        String nom = "belilita";
        String prenom = "anas";
        int anneeNaissance = 2004;
        int note = 56;

       Etudiant etudiant = new Etudiant(nom, prenom, anneeNaissance, note);

       System.out.printf("[Code Permanent] %s\n", etudiant.getCodePermanent());
       System.out.printf("[isSucces] %s\n", etudiant.isSucces());
       System.out.printf("[noteLitterale] %s\n", etudiant.noteLitterale());
       System.out.printf(etudiant.toString());
    }
}
