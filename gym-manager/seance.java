package models;

public class seance {
    private int id;
    private int membreId;
    private int coachId;
    private java.sql.Date date;
    private String heure;
    private String statut;
    //Constructor of modification
    public seance(int id, int membreId, int coachId, String statut, java.sql.Date date, String heure) {
        this.id = id;
        this.membreId = membreId;
        this.coachId = coachId;
        this.statut = statut;
        this.date = date;
        this.heure = heure;
    }
    //constructor of creation
    public seance(int membreId, int coachId, java.sql.Date date, String heure) {
        this.membreId = membreId;
        this.coachId = coachId;
        this.date = date;
        this.heure = heure;
    }
    //add seance to db
    public void addSeance() {
       
        String strInsert = "insert into seance values("
                + id + ","
                + "'" + getMembreId() + "',"
                + "'" + getCoachId() + "',"
                + "'" + "en attende" + "',"
                + "'" + getDate() + "',"
                + "'" + getHeure() + "')";
        boolean isAdd = dataBase.go.runNonQuery(strInsert);
        if (isAdd) {
            gym.Tools.msgBox("Seance Ajouté Avec Succes!");
        }

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembreId() {
        return membreId;
    }

    public void setMembreId(int membreId) {
        this.membreId = membreId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
