package com.zisal.messaging.subscriber.two.producer;

import com.zisal.messaging.shared.ReplyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProducerFanoutExchangeService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.fanout.exchange-reply}")
    private String exchangeName;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerFanoutExchangeService.class);

    public void sendMessage(ReplyDTO p_ReplyDTO) {
        LOGGER.info("Subscriber One Send : "+p_ReplyDTO);
        this.amqpTemplate.convertAndSend(exchangeName,"", p_ReplyDTO.toString());
    }

}
