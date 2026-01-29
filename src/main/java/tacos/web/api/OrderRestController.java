package tacos.web.api;

import org.springframework.web.bind.annotation.RestController;

import tacos.TacoOrder;
import tacos.data.OrderRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class OrderRestController {

    private OrderRepository orderRepo;

    public OrderRestController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order) {
        return orderRepo.save(order);
    }
    

}
