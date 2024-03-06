public class Etudiant {
    private String m_nom = "nom inconnue";
    private String m_prenom = "prénom inconnue";
    private int m_codePermanent = 0;
    private int m_anneeNaissance = 0;
    private int m_note = 0;

    Etudiant(String nom, String prenom, int codePermanent, int anneeNaissance, int note)
    {
        m_codePermanent  = codePermanent;
        m_anneeNaissance = anneeNaissance;
        m_prenom = prenom;
        m_nom    = nom;
        m_note   = note;
    }

    Etudiant()
    {}

    /*
    =============================================================
    getter setter
    =============================================================
    */
    public String getnom() {
        return m_nom;
    }

    public void setnom(String nom) {
        m_nom = nom;
    }

    public String getprenom() {
        return m_prenom;
    }

    public void setPrenom(String prenom) {
        m_prenom = prenom;
    }

    public int getCodePermanent() {
        return m_codePermanent;
    }

    public void setCodePermanent(int codePermanent) {
        m_codePermanent = codePermanent;
    }

    public int getAnneeNaissance() {
        return m_anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        m_anneeNaissance = anneeNaissance;
    }

    public int getNote() {
        return m_note;
    }

    public void setNote(int note) {
        m_note = note;
    }

     /*
    =======================================================
    méthode
    =============================================================
    */

    public boolean isSucces()
    {
        int notePassage = 60;
        return m_note >= notePassage;
    }

    public char noteLitterale()
    {
        return  m_note >= 80 && m_note <= 100 ? 'A' :
                m_note >= 60 && m_note <= 80  ? 'B' :
                m_note >= 40 && m_note <= 60  ? 'C' : 'D';

    }
    public String toString()
    {
        return String.format("\n\n[code] %d\n[nom] %s\n[prénom] %s\n[année] %d\n[note] %d\n\n",
                m_codePermanent,
                m_nom,
                m_prenom,
                m_anneeNaissance,
                m_note
        );
    }

   public static void main(String[] args) {
        String nom = "belilita";
        String prenom = "anas";
        int codePermanent = 65734;
        int anneeNaissance = 2004;
        int note = 45;

       Etudiant etudiant = new Etudiant(nom, prenom, codePermanent, anneeNaissance, note);

       System.out.printf("[isSucces] %s\n", etudiant.isSucces());
       System.out.printf("[noteLitterale] %s\n", etudiant.noteLitterale());
       System.out.printf(etudiant.toString());
    }
}