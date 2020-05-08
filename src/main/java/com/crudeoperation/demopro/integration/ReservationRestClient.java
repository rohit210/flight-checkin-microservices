package com.crudeoperation.demopro.integration;

import com.crudeoperation.demopro.integration.dto.Reservation;
import com.crudeoperation.demopro.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    Reservation findReservation(Long id);

    Reservation updateReservation(ReservationUpdateRequest request);



}
