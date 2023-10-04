package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Pays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PaysProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all pays
     * @return An iterable of all pays
     */
    public Iterable<Pays> getLesPays() {

        String baseApiUrl = props.getApiUrl();
        String getPaysUrl = baseApiUrl + "/pays";
        System.out.println("url=" + getPaysUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Pays>> response = restTemplate.exchange(
                getPaysUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Pays>>() {}
        );

        log.debug("Get Pays call " + response.getStatusCode().toString());

        return response.getBody();
    }

}