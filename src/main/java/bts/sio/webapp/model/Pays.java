package bts.sio.webapp.model;


import lombok.Data;

@Data
public class Pays {
    private Integer id;
    private String libelle;

    public Pays() {
    }

    public Pays(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }


}