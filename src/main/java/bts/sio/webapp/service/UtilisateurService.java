package bts.sio.webapp.service;

import bts.sio.webapp.model.Utilisateur;
import bts.sio.webapp.repository.UtilisateurProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurProxy utilisateurProxy;
    public Iterable<Utilisateur> getLesUtilisateurs() {
        return utilisateurProxy.getLesUtilisateurs();
    }
}
