package models;

public class coach {

    private int id;
    private String lastName;
    private String firstName;
    private java.sql.Date birthDay;
    private int cin;
    private int tarif;
    private int balance;
    private int nombre;
public coach(){};
    // constructor of creation
    public coach(String lastName, String firstName, java.sql.Date birthday, int cin, int tarif) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthday;
        this.cin = cin;
        this.tarif = tarif;

    }

    //constructor of modification
    public coach(int id, String lastName, String firstName, java.sql.Date birthday, int cin, int tarif, int balence) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthday;
        this.cin = cin;
        this.tarif = tarif;
        this.balance = balence;
      

    }
       //constructor of modification
    public coach(int id, String lastName, String firstName, java.sql.Date birthday, int cin, int tarif, int balence,int nombre) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthday;
        this.cin = cin;
        this.tarif = tarif;
        this.balance = balence;
        this.nombre = nombre;

    }

    //add coach to db
    public void addCoach(String[] Seance) {

        String CommandeAjoute = "INSERT INTO `coach` (`Id`, `Nom`, `Prenom`, `Cin`, `DateDeNaissance`, `Tarif`, `Balance`) VALUES (NULL, '" + getLastName() + "', '" + getFirstName() + "', '" + getCin() + "', '" + getBirthDay() + "', '" + getTarif() + "', '" + getBalance() + "');";

        boolean isAdd = dataBase.go.runNonQuery(CommandeAjoute);

        models.Horaire.addHoraire(getCin(), Seance);
        if (isAdd) {
            gym.Tools.msgBox("Coach Ajouté Avec Succes!");
        }
    }

    // update coach data in db
    public void updateCoach(String[] Seance, boolean modifyHoraire) {
        String CommandeModifier = "UPDATE coach SET Nom = '" + lastName + "' ,`Prenom` = '" + firstName + "', Cin = '" + cin + "',`DateDeNaissance` = '" + birthDay + "', Tarif = '" + tarif +"',Balance = '"+balance+"' , Nombre ='"+nombre+"' WHERE coach.`Id` = " + id + ";";
        boolean isModified = dataBase.go.runNonQuery(CommandeModifier);
        boolean isHoraireModified = modifyHoraire ? models.Horaire.addHoraire(getCin(), Seance) : true;
        if (isModified && isHoraireModified) {
            gym.Tools.msgBox("Modifications Enregistres !");
        }
    }

    //payer coach
    public void payerCoach() {
        balance += tarif;
        updateCoach(null, false);
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getNombre() {
        return this.nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
