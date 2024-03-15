// Fait par mohammed Anas Belilita

public class Etudiant {
    private String m_nom = "nom inconnue";
    private String m_prenom = "prénom inconnue";
    private String m_codePermanent = "";
    private int m_anneeNaissance = 0;
    private int m_note = 0;

    Etudiant(String nom, String prenom, int anneeNaissance, int note)
    {
        String codeNom = nom.substring(0, 1).toUpperCase();
        String codePrenom = prenom.substring(0, 1).toUpperCase();
        String codeAnnee = String.valueOf(anneeNaissance).substring(0, 4);
        m_codePermanent  = codeNom + codePrenom +codeAnnee;
        m_anneeNaissance = anneeNaissance;
        setPrenom(prenom);
        setnom(nom);
        setNote(note);
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
        m_nom = contientUnNbr(nom) ? m_nom : nom;
        if(m_nom.equals("nom inconnue"))
            System.out.print("[ERROR] le nom ne doit pas contenir un nombre\n");
    }

    public String getprenom() {
        return m_prenom;
    }

    public void setPrenom(String prenom) {
        m_prenom = contientUnNbr(prenom) ? m_prenom : prenom;
        if(m_prenom.equals("prénom inconnue"))
            System.out.print("[ERROR] le prenom ne doit pas contenir un nombre\n");
    }

    public String getCodePermanent() {
        return m_codePermanent;
    }

    public void setCodePermanent(String codePermanent) { m_codePermanent = codePermanent; }

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
        m_note = (note >= 0 && note <= 100) ? note : m_note;
        if (m_note == 0)
            System.out.print("[ERROR] la note doit etre entre 0 et 100!\n");
    }



    /* =============================================================
    *                           méthode
    * ============================================================== */
   
    private boolean contientUnNbr(String phrase) {
        for (char caractere : phrase.toCharArray()) {
            if (Character.isDigit(caractere)) 
                return true;
        }
        return false;
    }

    private int genererCodePermanent(String nom, String prenom, int anneeNaissance) {
        int code = 0;
        if (!nom.isEmpty() && !prenom.isEmpty()) {
            code += Character.toUpperCase(nom.charAt(0));
            code += Character.toUpperCase(prenom.charAt(0));
        }
        code += anneeNaissance;
        return code;
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

   public static void main(String[] args) {
        String nom = "belilita";
        String prenom = "anas";
        int anneeNaissance = 2004;
        int note = 45;

       Etudiant etudiant = new Etudiant(nom, prenom, anneeNaissance, note);

       System.out.printf("[Code Permanent] %s\n", etudiant.getCodePermanent());
       System.out.printf("[isSucces] %s\n", etudiant.isSucces());
       System.out.printf("[noteLitterale] %s\n", etudiant.noteLitterale());
       System.out.printf(etudiant.toString());
    }
}
