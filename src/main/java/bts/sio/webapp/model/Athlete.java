package bts.sio.webapp.model;


import lombok.Data;


import java.time.LocalDate;


@Data
public class Athlete {

    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate datenaiss ;
    private Pays pays;
    private Sport sport;

    public Athlete() {
    }

    public Athlete(Integer id, String nom, String prenom, LocalDate datenaiss, Pays pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.pays = pays;
    }


    public Sport getLeSport(){
        return sport;
    }

    public void setLeSport(Sport LeSport){
        this.sport = sport;
    }

}