package com.github.brianmmcclain.k8sshopbackend;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ItemController {
    private final ItemRepository repository;

    ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/item")
    List<Item> all() {
        return repository.findAll();
    }

    @GetMapping("/item/{id}")
    Item getOne(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException());
    }
}