package com.kafka.producer.service;

import com.google.gson.Gson;
import com.kafka.producer.constants.Constants;
import com.kafka.producer.model.Book;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@Data
@Slf4j
public class ProducerService {

    private final KafkaSender<String,String> kafkaSender;

    public Mono<Book> send(Book book){

        kafkaSender.<String>send(Flux.range(1, 1)
                .map(i -> SenderRecord.create(new ProducerRecord<>(Constants.TOPIC, "Key_"+i,  new Gson().toJson(book) ), "")))
                .doOnError(e -> log.error("Send failed", e))
                .subscribe(newBook->log.info(newBook+" send to server"));

        return Mono.just(book);
    }
}
