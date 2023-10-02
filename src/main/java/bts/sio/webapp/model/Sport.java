package bts.sio.webapp.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Sport {
    private Integer id;
    private String nom;
    private String descriptif;
    private ArrayList<Athlete> lesAthletes;


    public Sport() {
    }

    public Sport(Integer id, String nom, String descriptif) {
        this.id = id;
        this.nom = nom;
        this.descriptif = descriptif;
    }

    public ArrayList<Athlete> getLesAthletes(){
        return lesAthletes;
    }

    public void setLesAthletes(ArrayList<Athlete> lesAthletes){
        this.lesAthletes = lesAthletes;
    }

    public void addUnAthlete(Athlete UnAthlete){
        if (lesAthletes == null){
            lesAthletes = new ArrayList<Athlete>();
        }
        lesAthletes.add(UnAthlete);
    }




}







