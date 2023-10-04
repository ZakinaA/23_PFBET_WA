package bts.sio.webapp.model.pari;

import lombok.Data;

@Data
public class Pari {
    private Integer id;
    private String libelle;
    private String place;
    private String mise;
    private String cote;

    public Pari() {
    }

    public Pari(Integer id) {
        this.id = id;
        this.libelle = libelle;
        this.place = place;
        this.mise = mise;
        this.cote = cote;
    }


}
