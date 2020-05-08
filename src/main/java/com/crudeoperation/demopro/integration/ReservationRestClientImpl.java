package com.crudeoperation.demopro.integration;

import com.crudeoperation.demopro.integration.dto.Reservation;
import com.crudeoperation.demopro.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
    public static final String RESERVATION_REST_URL = "http://localhost:9090/reservation/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);

        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
        return null;
    }

}
