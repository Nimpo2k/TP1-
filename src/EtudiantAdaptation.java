import java.util.function.Function;

public class EtudiantAdaptation extends Etudiant implements Facture
{
    private String HistoriqueDesIncidents = "";
    private int coteS = 0;

    private int montant = 0;
    EtudiantAdaptation(String nom, String prenom, String HistoriqueDesIncidents, int coteS, int anneeNaissance, int note)
    {
        super(nom, prenom, anneeNaissance, note);

        setHistoriqueDesIncidents(HistoriqueDesIncidents);
        setCoteS(coteS);
        facturer();
    }

    /* ============================================================== *
     *                        getter setter                           *
     * ============================================================== */

    public void setHistoriqueDesIncidents(String HistoriqueDesIncidents) {

        while (HistoriqueDesIncidents.isEmpty()) {
            HistoriqueDesIncidents = Entree.entree("Donnez l'historique des incidents: ", Function.identity());
            if (HistoriqueDesIncidents.isEmpty()) { System.out.print("Name cannot be empty. Try again."); }
        }

        this.HistoriqueDesIncidents = HistoriqueDesIncidents;
    }

    public void setCoteS(int coteS)
    {
        try {
            if (coteS < 0 || coteS > 10)
                throw new IllegalAccessException("coteS doit etre entre l'interval [0,10]");

            this.coteS = coteS;
        } catch (IllegalAccessException e) { System.out.printf("Error:  %s", e.getMessage()); }
    }

    public int getMontant() { return this.montant; }

    /* ============================================================== *
     *                          Méthode                               *
     * ============================================================== */

    @Override
    public boolean isSucces() {
        // check si cela fonctionne 40 <--
        return (super.note >= 55 && super.note <= 60) && this.coteS < 2 || super.note >= 60;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("[HistoriqueDesIncidents] %s\n[coteS] %d\n", this.HistoriqueDesIncidents, this.coteS);
    }

    @Override
    public void facturer() {
        this.montant = MONTANT + this.coteS * (MONTANT * (TAUX*2)/100);
    }
    /* ============================================================== *
     *                       Point de test                            *
     * ============================================================== */
    public static void main(String[] args) {
        final String nom = "belilita";
        final String prenom = "anas";
        final String HistoriqueDesIncidents = "trouble d'attention";
        final int coteS = 1;
        final int anneeNaissance = 2004;
        final int note = 56;

        EtudiantAdaptation etudiantAdaptation =  new EtudiantAdaptation(nom ,prenom , HistoriqueDesIncidents, coteS, anneeNaissance, note);

        System.out.printf("%s", etudiantAdaptation);
        System.out.printf("[isSucce] %s",etudiantAdaptation.isSucces() ? "true\n" : "false\n");
        System.out.printf("[montant] %d\n", etudiantAdaptation.getMontant());
    }


}
