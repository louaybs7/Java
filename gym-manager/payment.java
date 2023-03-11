package models;

import java.sql.Date;

public class payment {

    private int id;
    private int coachId;
    private double montant;
    private java.sql.Date date;
    //constructor
    public payment(int id, int coachId, double montant, java.sql.Date date) {
        this.id = id;
        this.coachId = coachId;
        this.montant = montant;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
