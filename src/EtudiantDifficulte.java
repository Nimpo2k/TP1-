import java.util.function.Function;

public class EtudiantDifficulte  extends Etudiant implements Facture
{
    private String typeDeTrouble = "";
    private int coteT = 0;
    private int montant = 0;

    EtudiantDifficulte(String nom, String prenom, String typeDeTrouble, int coteT, int anneeNaissance, int note)
    {
        super(nom, prenom, anneeNaissance, note);

        setTypeDeTrouble(typeDeTrouble);
        setCoteT(coteT);
        facturer();
    }

    /* ============================================================== *
     *                        getter setter                           *
     * ============================================================== */


    public void setTypeDeTrouble(String typeDeTrouble) {

        while (typeDeTrouble.isEmpty()) {
            typeDeTrouble = Entree.entree("Donnez le type de trouble que l'élève a: ", Function.identity());
            if (typeDeTrouble.isEmpty()) { System.out.print("Name cannot be empty. Try again."); }
        }
        this.typeDeTrouble = typeDeTrouble;
    }

    public void setCoteT(int coteT)
    {
        try {
            if (coteT < 0 || coteT > 10)
                throw new IllegalAccessException("coteT doit etre entre l'interval [0,10]");

            this.coteT = coteT;
        } catch (IllegalAccessException e) { System.out.printf("Error:  %s", e.getMessage()); }
    }

    public int getMontant()
    {
        return this.montant;
    }
    /* ============================================================== *
     *                          Méthode                               *
     * ============================================================== */

    @Override
    public boolean isSucces() {
        // check si cela fonctionne 40 <--
        return (super.note >= 50 && super.note <= 60) && coteT < 5 || super.note >= 60;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("[typeDeTrouble] %s\n[coteT] %d\n", this.typeDeTrouble, this.coteT);
    }

    @Override
    public void facturer() {
        this.montant = MONTANT + this.coteT * (MONTANT * TAUX/100);
    }

    /* ============================================================== *
     *                       Point de test                            *
     * ============================================================== */
    public static void main(String[] args) {
        final String nom = "belilita";
        final String prenom = "anas";
        final String typeDeTrouble = "Anxiété";
        final int coteT = 4;
        final int anneeNaissance = 2004;
        final int note = 56;

        EtudiantDifficulte etudiantDifficulte = new EtudiantDifficulte(nom ,prenom , typeDeTrouble, coteT, anneeNaissance, note);

        System.out.printf("%s", etudiantDifficulte);
        System.out.printf("[isSucce] %s",etudiantDifficulte.isSucces() ? "true\n" : "false\n");
        System.out.printf("[montant] %d\n", etudiantDifficulte.getMontant());
    }


}
