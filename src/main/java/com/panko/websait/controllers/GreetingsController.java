package com.panko.websait.controllers;

import com.panko.websait.models.Message;
import com.panko.websait.repositories.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {

    private final MessageRepository messageRepository;

    public GreetingsController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(required = false) String name, Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("messages", messageRepository.findAll());

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, @RequestParam Map<String, Object> model) {
        messageRepository.save(new Message(text, tag));

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter == null || filter.isEmpty()) {
            messages = messageRepository.findAll();
        } else {
            messages = messageRepository.findByTag(filter);
        }

        model.put("messages", messages);

        return "main";
    }
}
