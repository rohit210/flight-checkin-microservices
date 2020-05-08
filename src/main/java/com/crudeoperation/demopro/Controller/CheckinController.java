package com.crudeoperation.demopro.Controller;

import com.crudeoperation.demopro.integration.ReservationRestClient;
import com.crudeoperation.demopro.integration.dto.Reservation;
import com.crudeoperation.demopro.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckinController {
    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/checkin")
    public ModelAndView gohome() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("id", new Reservation());

        return modelAndView;
    }

    @RequestMapping("/startCheckIn")
    public ModelAndView startChcekIn(@RequestParam("id") Long id) {
        Reservation reservation = restClient.findReservation(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reservation", reservation);
        modelAndView.setViewName("displayReservationDetails");
        modelAndView.addObject("nobags", new ReservationUpdateRequest());
        return modelAndView;
    }

    @RequestMapping(value = "/completecheckin",  method = RequestMethod.POST)
    public String completeCheckin(@RequestParam("id") Long id, @RequestParam(value = "numberOfBags", required = false) int numberOfBags) {
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(id);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        restClient.updateReservation(reservationUpdateRequest);
        return "checkInConfirmation";
    }

}
