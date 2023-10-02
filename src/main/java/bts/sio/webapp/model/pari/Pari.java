package bts.sio.webapp.model.pari;

import lombok.Data;

@Data
public class Pari {
    private Integer id;
    private String libelle;
    private String place;
    private String mise;

    public Pari() {
    }

    public Pari(Integer id, String nom) {
        this.id = id;
        this.libelle = libelle;
        this.place = place;
        this.mise = mise;
    }


}
