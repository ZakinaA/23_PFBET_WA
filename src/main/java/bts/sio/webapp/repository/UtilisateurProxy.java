package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Utilisateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UtilisateurProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all utilisateurs
     * @return An iterable of all utilisateurs
     */
    public Iterable<Utilisateur> getLesUtilisateurs() {

        String baseApiUrl = props.getApiUrl();
        String getLesUtilisateursUrl = baseApiUrl + "/utilisateur";
        System.out.println("url=" + getLesUtilisateursUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Utilisateur>> response = restTemplate.exchange(
                getLesUtilisateursUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Utilisateur>>() {}
        );

        log.debug("Get Utilisateur call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
