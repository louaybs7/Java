package models;

import dataBase.go;

public class membre {

    private static int membersNumber = 0;
    private int id;
    private String lastName;
    private String firstName;
    private java.sql.Date birthDay;
    private java.sql.Date subscriptionLimit;

    private String statut = "valid";

    // Constructor of Creation
    public membre(String lastName, String firstName, java.sql.Date birthday, java.sql.Date subscriptionLimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthday;
        this.subscriptionLimit = subscriptionLimit;
    }

    //Constructor of modification
    public membre(int id, String lastName, String firstName, java.sql.Date birthday, java.sql.Date subscriptionLimit, String staut) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthday;
        this.subscriptionLimit = subscriptionLimit;
        this.statut = staut;
    }

    //add new member to db
    public void AjouteMembre() {

        try {
            String CommandeAjoute = "INSERT INTO `membre` (`Id`, `Nom`, `Prenom`, `DateDeNaissance`, `DateLimite`, `Statut`) VALUES (NULL, '" + getLastName() + "', '" + getFirstName() + "', '" + getBirthDay() + "', '" + getSubscriptionLimit() + "', '" + getStatut() + "');";
            boolean isAdd = dataBase.go.runNonQuery(CommandeAjoute);
            if (isAdd) {
                gym.Tools.msgBox("Membre Ajouté Avec Succes!");
            }
        } catch (Exception e) {
            gym.Tools.msgBox(e.getMessage());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public java.sql.Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(java.sql.Date birthDay) {
        this.birthDay = birthDay;
    }

    public java.sql.Date getSubscriptionLimit() {
        return subscriptionLimit;
    }
    //add mounths to sub limit
    public void setSubscriptionLimit(int mounths) {
        subscriptionLimit.setMonth(subscriptionLimit.getMonth() + mounths);
        go.runNonQuery("update membre set DateLimite='" + subscriptionLimit + "' where id=" + id + ";");

    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
