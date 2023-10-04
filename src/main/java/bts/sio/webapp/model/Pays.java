package bts.sio.webapp.model;


import lombok.Data;

@Data
public class Pays {
    private Integer id;
    private String nom;

    public Pays() {
    }

    public Pays(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }


}