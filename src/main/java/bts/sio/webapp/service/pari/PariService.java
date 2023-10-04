package bts.sio.webapp.service.pari;

import bts.sio.webapp.model.pari.Pari;
import bts.sio.webapp.repository.pari.PariProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service

public class PariService {

    @Autowired
    private PariProxy pariProxy;

    public Pari getPari(final int id) {
        return pariProxy.getPari(id);
    }

    public Iterable<Pari> getParis() {
        return pariProxy.getParis();
    }

    public void deletePari(final int id) {
        pariProxy.deletePari(id);
    }

    public void savePari(Pari pari) {
    }
}


