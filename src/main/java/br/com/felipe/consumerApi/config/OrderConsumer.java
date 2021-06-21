package br.com.felipe.consumerApi.config;

import br.com.felipe.consumerApi.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class OrderConsumer {

    @Autowired
    private AddressService addressService;


    @RabbitListener(queues = "OrderQueue")
    public void receive(@Payload Map<String, String> order) {
        addressService.save(order);
        log.info("Order: " + order);
    }

}