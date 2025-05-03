package ir.otrag.endpoint.restapi.framework;


import ir.otrag.endpoint.restapi.framework.mediator.Mediator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseController {
    protected Mediator mediator;
}
