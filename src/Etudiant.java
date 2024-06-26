// Fait par mohammed Anas Belilita
//Bonus 1 et tests/bugs fait par Riad
import java.util.Scanner;
import java.util.function.Function;

public class Etudiant implements Facture {

    protected String nom = "nom inconnue";
    protected String prenom = "prénom inconnue";
    protected String codePermanent = "";
    protected int anneeNaissance = 0;
    protected int note = 0;
    private int montant = 0;

    Etudiant(String nom, String prenom, int anneeNaissance, int note)
    {
        setPrenom(prenom);
        setnom(nom);
        setNote(note);
        setCodePermanent(nom, prenom, anneeNaissance);
        setAnneeNaissance(anneeNaissance);
        facturer();
    }

    //le code permanent, le nom et le prénom par des valeurs fournies en paramètre
    Etudiant(String nom, String prenom, String codePermanent)
    {
        setPrenom(prenom);
        setnom(nom);
        this.codePermanent = codePermanent;
    }

    Etudiant() {}

    /* =============================================================  *
     *                        getter setter                           *
     * ============================================================== */

    public void setnom(String nom) {
        try {
            if (contientUnNbr(nom))
                throw new IllegalAccessException("le nom ne doit pas contenir un nombre");

            this.nom = nom;
        } catch (IllegalAccessException e) {
            System.out.printf("[Error] %s\n",e.getMessage());
        }
    }

    public String getprenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        try {
            if (contientUnNbr(prenom))
                throw new IllegalAccessException("le prenom ne doit pas contenir un nombre");

            this.prenom = prenom;
        } catch (IllegalAccessException e) {
            System.out.printf("[Error] %s\n",e.getMessage());
        }
    }

    public void setCodePermanent(String nom, String prenom, int anneeNaissance) {
        char codeNom     = getFirstCharacter(nom);
        char codePrenom  = getFirstCharacter(prenom);
        String codeAnnee = integerToString(anneeNaissance);

        this.codePermanent = String.valueOf(codeNom) + String.valueOf(codePrenom) + codeAnnee;
    }

    public void setNote(int note) {
        try {
            if (note < 0 || note > 100)
                throw new IllegalAccessException("note doit etre entre l'interval [0,100]");

            this.note = note;

        } catch (IllegalAccessException e) {
            System.out.printf("[Error]  %s", e.getMessage());
        }
    }

    public String getCodePermanent() { return this.codePermanent; }
    public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }
    public int getNote() { return this.note; }
    public String getnom() {
        return this.nom;
    }

    /* ============================================================= *
     *                           méthode                             *
     * ============================================================= */
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
        return this.note >= notePassage;
    }

    public char noteLitterale() {
        return  this.note >= 80 && this.note <= 100 ? 'A' :
                this.note >= 60 && this.note <= 80  ? 'B' :
                this.note >= 40 && this.note <= 60  ? 'C' : 'D';
    }
    
    public String toString(){
        return String.format("\n\n[code] %s\n[nom] %s\n[prénom] %s\n[année] %d\n[note] %d\n",
                this.codePermanent,
                this.nom,
                this.prenom,
                this.anneeNaissance,
                this.note);
    }
    @Override
    public void facturer() {
        this.montant = MONTANT;
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
