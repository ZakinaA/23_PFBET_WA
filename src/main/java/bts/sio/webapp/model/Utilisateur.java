package bts.sio.webapp.model;


import lombok.Data;


import java.time.LocalDate;


@Data
public class Utilisateur {

    private Integer id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;


    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String prenom, String login, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }



}
