package bts.sio.webapp.service;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.repository.EpreuveProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EpreuveService {


    @Autowired
    private EpreuveProxy epreuveProxy;

    public Epreuve getEpreuves(final int id) {
        return epreuveProxy.getEpreuve(id);
    }

    public Iterable<Epreuve> getEpreuves() {
        return epreuveProxy.getEpreuves();
    }

    public void deleteEpreuve(final int id) {
        epreuveProxy.deleteEpreuve(id);
    }


    public Epreuve saveEpreuve(Epreuve epreuve) {
        Epreuve savedEpreuve;

        // Functional rule : Last name must be capitalized.
        epreuve.setLibelle(epreuve.getLibelle());
        epreuve.setDate_debut(epreuve.getDate_debut());
        epreuve.setDate_fin(epreuve.getDate_fin());

        if(epreuve.getId() == null) {
            // If id is null, then it is a new employee.
            savedEpreuve = epreuveProxy.createEpreuve(epreuve);
        } else {
            savedEpreuve =epreuveProxy.updateEpreuve(epreuve);
        }

        return savedEpreuve;

    }

}
