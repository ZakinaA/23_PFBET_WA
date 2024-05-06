package bts.sio.webapp.model.pari;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Utilisateur;
import lombok.Data;

@Data
public class Pari {
    private Integer id;
    private String libelle;
    private String place;
    private String mise;
    private String cote;
    private Utilisateur utilisateur;
    private Athlete athlete;

    public Pari() {
    }

    public Pari(Integer id, String nom) {
        this.id = id;
        this.libelle = libelle;
        this.place = place;
        this.mise = mise;
        this.cote = cote;
    }


}