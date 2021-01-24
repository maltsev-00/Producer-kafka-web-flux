package com.kafka.producer.config;

import com.kafka.producer.constants.Constants;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfig {

    @Bean
    public SenderOptions<String,String> senderOptions() {

       Map<String, Object> config = new HashMap<>();
       config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
       config.put(org.apache.kafka.clients.producer.ProducerConfig.CLIENT_ID_CONFIG, Constants.CLIENT_ID_CONFIG);
       config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
       config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

       return SenderOptions.create(config);
    }

   @Bean
   public KafkaSender<String, String> kafkaSender(){
        return  KafkaSender.create(senderOptions());
    }

}
