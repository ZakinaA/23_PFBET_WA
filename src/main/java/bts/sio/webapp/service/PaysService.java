package bts.sio.webapp.service;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Pays;
import bts.sio.webapp.repository.AthleteProxy;
import bts.sio.webapp.repository.PaysProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PaysService {

    @Autowired
    private PaysProxy paysProxy;
    public Iterable<Pays> getLesPays() {
        return paysProxy.getLesPays();
    }
}
