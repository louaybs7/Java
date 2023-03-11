package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.*;

public class go {

    private static String url = "";
    private static Connection cnx;

    //setting the url
    private static void setUrl() {
        url = "jdbc:mysql://localhost/ProjetPoo";
    }

    //connexion
    private static void setConnection() {
        setUrl();
        try {
            cnx = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
    }

    //check user connexion
    public static boolean checkUserAndPassword(String username, String password) {
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            String strCheck = "select * from users where " + "username='"
                    + username + "' and password='" + password + "'";
            stmt.executeQuery(strCheck);
            while (stmt.getResultSet().next()) {
                cnx.close();
                return true;
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return false;
    }

    //run Non Query
    public static boolean runNonQuery(String sqlStatement) {
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            stmt.execute(sqlStatement);
            cnx.close();
            return true;
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
            return false;
        }
    }

    //get all members data
    public static ArrayList<models.membre> getMembersData() {
        ArrayList<membre> result = new ArrayList<models.membre>();
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM `membre`");
            while (rst.next()) {
                int id = rst.getInt("Id");
                String Nom = rst.getString("Nom");
                String Prenom = rst.getString("Prenom");
                java.sql.Date DateDeNaissance = rst.getDate("DateDeNaissance");
                java.sql.Date DateLimite = rst.getDate("DateLimite");
                String statut = String.valueOf(rst.getString("Statut"));
                models.membre x = new models.membre(id, Nom, Prenom, DateDeNaissance, DateLimite, statut);
                result.add(x);
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return result;
    }

    //get coachs data
    public static ArrayList<models.coach> getCoachsData() {
        ArrayList<coach> result = new ArrayList<models.coach>();
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM `Coach`");
            while (rst.next()) {
                int id = rst.getInt("Id");
                String Nom = rst.getString("Nom");
                String Prenom = rst.getString("Prenom");
                int cin = rst.getInt("Cin");
                java.sql.Date DateDeNaissance = rst.getDate("DateDeNaissance");
                int tarif = rst.getInt("Tarif");
                int balence = rst.getInt("Balance");
                int nombre = rst.getInt("Nombre");

                models.coach x = new models.coach(id, Nom, Prenom, DateDeNaissance, cin, tarif, balence,nombre);
                result.add(x);
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return result;
    }

    // get Horaire data 
    public static ArrayList<Horaire> getHoraireData() {
        ArrayList<Horaire> result = new ArrayList<Horaire>();
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM `Horaire`");
            while (rst.next()) {
                int cinCoach = rst.getInt("CinCoach");
                String Lundi = rst.getString("Lundi");
                String Mercredi = rst.getString("Mercredi");
                String Mardi = rst.getString("Mardi");
                String Jeudi = rst.getString("Jeudi");
                String Vendredi = rst.getString("Vendredi");
                String Samedi = rst.getString("Samedi");
                String Dimanche = rst.getString("Dimanche");

                Horaire x = new Horaire( cinCoach, Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche);
                result.add(x);
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return result;
    }
    //get seances data
    public static ArrayList<seance> getSeanceData() {
        ArrayList<seance> result = new ArrayList<seance>();
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM `seance`");
            while (rst.next()) {
                int id = rst.getInt("Id");
                int memberId = rst.getInt("IdMembre");
                int coachId = rst.getInt("IdCoach");
                String statut = rst.getString("Statut");
                java.sql.Date date = rst.getDate("DateSeance");
                String horaire = rst.getString("HoraireSeance");
                seance x = new seance(id, memberId, coachId, statut, date, horaire);
                result.add(x);
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return result;
    }
    // get payments data
    public static ArrayList<payment> getPaymentData() {
        ArrayList<payment> result = new ArrayList<payment>();
        try {
            setConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM `paiments`");
            while (rst.next()) {
                int id = rst.getInt("Id");
                int coachId = rst.getInt("IdCoach");
                int Montant = rst.getInt("Montant");
                java.sql.Date date = rst.getDate("DatePaiment");
                payment x = new payment(id, coachId, Montant, date);
                result.add(x);
            }
            cnx.close();
        } catch (SQLException ex) {
            gym.Tools.msgBox(ex.getMessage());
        }
        return result;
    }

}
