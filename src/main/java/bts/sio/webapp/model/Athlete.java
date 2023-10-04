package bts.sio.webapp.model;


import lombok.Data;


import java.time.LocalDate;


@Data
public class Athlete {

    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate date_naissance ;
    private Pays pays;
    private Sport sport;

    public Athlete() {
    }

    public Athlete(Integer id, String nom, String prenom, LocalDate date_naissance, Pays pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.pays = pays;
    }


    public Sport getLeSport(){
        return sport;
    }

    public void setLeSport(Sport LeSport){
        this.sport = sport;
    }

}