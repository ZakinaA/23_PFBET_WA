package bts.sio.webapp.repository.pari;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.pari.Pari;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PariProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all paris
     * @return An iterable of all athlete
     */
    public Iterable<Pari> getParis() {

        String baseApiUrl = props.getApiUrl();
        String getPariUrl = baseApiUrl + "/paris";
        System.out.println("url=" + getPariUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Pari>> response = restTemplate.exchange(
                getPariUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Pari>>() {}
        );

        log.debug("Get Paris call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get an pari by the id
     * @param id The id of the pari
     * @return The pari which matches the id
     */
    public Pari getPari(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/pari/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pari> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Pari.class
        );

        log.debug("Get Pari call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new pari
     * @param a A new pari (without an id)
     * @return The pari full filled (with an id)
     */
    public Pari createPari(Pari a) {

        String baseApiUrl = props.getApiUrl();
        String createPariUrl = baseApiUrl + "/pari";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Pari> request = new HttpEntity<Pari>(a);
        ResponseEntity<Pari> response = restTemplate.exchange(
                createPariUrl,
                HttpMethod.POST,
                request,
                Pari.class);

        log.debug("Create Pari call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update a pari - using the PUT HTTP Method.
     * @param e Existing pari to update
     */
    public Pari updatePari(Pari e) {
        String baseApiUrl = props.getApiUrl();
        String updatePariUrl = baseApiUrl + "/pari/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Pari> request = new HttpEntity<Pari>(e);
        ResponseEntity<Pari> response = restTemplate.exchange(
                updatePariUrl,
                HttpMethod.PUT,
                request,
                Pari.class);

        log.debug("Update Pari call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete an pari using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     */
    public void deletePari(int id) {
        String baseApiUrl = props.getApiUrl();
        String deletePariUrl = baseApiUrl + "/pari/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deletePariUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Pari call " + response.getStatusCode().toString());
    }

    public Iterable<Pari> getParisByUserId(Long utilisateur_id) {

        String baseApiUrl = props.getApiUrl();
        String getParisByUserIdUrl = baseApiUrl + "/paris/" + utilisateur_id;
        System.out.println("url=" + getParisByUserIdUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Pari>> response = restTemplate.exchange(
                getParisByUserIdUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Pari>>() {}
        );

        log.debug(" Get Paris By utilisateur_id call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
