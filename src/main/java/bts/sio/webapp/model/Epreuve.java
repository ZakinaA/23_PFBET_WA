package bts.sio.webapp.model;

import lombok.Data;
import java.time.LocalDate;


@Data
public class Epreuve {
    private Integer id;
    private String libelle;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private Sport sport;


    public Epreuve() {
    }

    public Epreuve(Integer id, String nom) {
        this.id = id;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.sport = sport;
    }


}