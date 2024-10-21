package com.test.coffee.service.listner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.coffee.entity.CoffeeBag;
import com.test.coffee.service.repositories.CoffeeBagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @Autowired
    private CoffeeBagRepository coffeeBagRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "coffee-bag", groupId = "coffee")
    public void listen(String message) {
        log.info("Message: {}", message);
        try {

            CoffeeBag bag = objectMapper.readValue(message, CoffeeBag.class);
            bag.setCurrentWeight(bag.getWeight().getWeight());
            coffeeBagRepository.save(bag);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}