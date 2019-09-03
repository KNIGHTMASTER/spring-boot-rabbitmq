package com.zisal.messaging.producer.endpoint;

import com.zisal.messaging.producer.service.ProducerFanoutExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @since : 2019-09-03
 **/
@RestController
public class ProducerEndPoint {

    @Autowired private ProducerFanoutExchangeService producerFanoutExchangeService;

    @GetMapping("/send")
    public ResponseEntity sendMessage(@RequestParam("message") String p_Message) {
        producerFanoutExchangeService.sendMessage(p_Message);
        return ResponseEntity.ok("OK");
    }
}
