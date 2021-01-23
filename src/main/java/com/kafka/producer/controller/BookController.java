package com.kafka.producer.controller;

import com.kafka.producer.model.Book;
import com.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("kafka")
public class BookController {

    private final ProducerService producerService;

    @Autowired
    public BookController(ProducerService producerService) {
        this.producerService = producerService;
    }


    @PostMapping
    public Mono<Book> addNewBook(@Valid @RequestBody Book book){
        return  producerService.send(book);
    }
}
