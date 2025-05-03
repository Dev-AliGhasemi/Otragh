package ir.otrag.endpoint.restapi.rent.controller;

import ir.otrag.endpoint.restapi.framework.BaseController;
import ir.otrag.endpoint.restapi.framework.mediator.Mediator;
import ir.otragh.applicationservice.rents.queries.getrent.GetRentQuery;
import ir.otragh.applicationservice.rents.queries.getrent.RentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class RentController extends BaseController {

    public RentController(Mediator mediator) {
        super(mediator);
    }

    @GetMapping
    public ResponseEntity<RentResponse> getRent(long id) {
        GetRentQuery getRentQuery = new GetRentQuery(id);
        RentResponse rentResponse = mediator.<GetRentQuery, RentResponse>send(getRentQuery);
        return ResponseEntity.ok(rentResponse);
    }
}
