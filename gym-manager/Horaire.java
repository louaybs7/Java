
package models;

public class Horaire {

    private int cinCoach;
    private String Lundi;
    private String Mardi;
    private String Mercredi;
    private String Jeudi;
    private String Vendredi;
    private String Samedi;
    private String Dimanche;

    // Constructor of creation
    public Horaire(String Lundi, String Mardi, String Mercredi, String Jeudi, String Vendredi, String Samedi, String Dimanche) {
        this.setLundi(Lundi);
        this.setMardi(Mardi);
        this.setMercredi(Mercredi);
        this.setJeudi(Jeudi);
        this.setVendredi(Vendredi);
        this.setSamedi(Samedi);
        this.setDimanche(Dimanche);

    }
    // constructor of modification
    public Horaire( int cinCoach, String Lundi, String Mardi, String Mercredi, String Jeudi, String Vendredi, String Samedi, String Dimanche) {
        this.setCinCoach(cinCoach);
        this.setLundi(Lundi);
        this.setMardi(Mardi);
        this.setMercredi(Mercredi);
        this.setJeudi(Jeudi);
        this.setVendredi(Vendredi);
        this.setSamedi(Samedi);
        this.setDimanche(Dimanche);

    }
    //add horaire to db
    public static boolean addHoraire(int cinCoach, String[] Seance) {

        String CommandeAjouteHoraire = "INSERT INTO `horaire` (`CinCoach`, `Lundi`, `Mardi`, `Mercredi`, `Jeudi`, `Vendredi`, `Samedi`, `Dimanche`) VALUES ('" + cinCoach + "', '" + Seance[0] + "', '" + Seance[1] + "', '" + Seance[2] + "', '" + Seance[3] + "', '" + Seance[4] + "', '" + Seance[5] + "', '" + Seance[6] + "');";
        boolean isAdd = dataBase.go.runNonQuery(CommandeAjouteHoraire);
        return isAdd;

    }
    //update horaire in db
    public static boolean updateHorraire(int cinCoach, String[] Seance) {
            String CommandeUpdateHoraire="UPDATE Horaire SET Lundi = '"+Seance[0]+"' ,`Mardi` = '"+Seance[1]+"', Mercredi = '"+Seance[2]+"',`Jeudi` = '"+Seance[3]+"', Vendredi = '"+Seance[4]+"', Samedi = '"+Seance[5]+"', Dimanche`='"+Seance[6]+"' WHERE Horaire`.`idCoach` = "+cinCoach+";";
            boolean isModified = dataBase.go.runNonQuery(CommandeUpdateHoraire);
        return isModified;
    }
    
    public String toString(){
        return "Lundi : "+Lundi+" \n Mardi : "+Mardi+"\n Mercredi : "+Mercredi+" \n Jeudi : "+Jeudi+" \n Vendredi : "+Vendredi+" \n Samedi : "+Samedi+"\n Dimanche : "+Dimanche;
    }


    public int getCinCoach() {
        return cinCoach;
    }

    public void setCinCoach(int cinCoach) {
        this.cinCoach = cinCoach;
    }

    public String getLundi() {
        return Lundi;
    }

    public void setLundi(String Lundi) {
        this.Lundi = Lundi;
    }

    public String getMardi() {
        return Mardi;
    }

    public void setMardi(String Mardi) {
        this.Mardi = Mardi;
    }

    public String getMercredi() {
        return Mercredi;
    }

    public void setMercredi(String Mercredi) {
        this.Mercredi = Mercredi;
    }

    public String getJeudi() {
        return Jeudi;
    }

    public void setJeudi(String Jeudi) {
        this.Jeudi = Jeudi;
    }

    public String getVendredi() {
        return Vendredi;
    }

    public void setVendredi(String Vendredi) {
        this.Vendredi = Vendredi;
    }

    public String getSamedi() {
        return Samedi;
    }

    public void setSamedi(String Samedi) {
        this.Samedi = Samedi;
    }

    public String getDimanche() {
        return Dimanche;
    }

    public void setDimanche(String Dimanche) {
        this.Dimanche = Dimanche;
    }


}
