package org.ditto.gift.controller;

import org.ditto.gift.model.Breed;
import org.ditto.gift.repository.BreedRepository;
import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Autowired
    private Ignite ignite;
    @Autowired
    private BreedRepository breedRepository;

    @RequestMapping(value = "/hello")
    public String hello() {

        //fill the repository with data and Save
        Breed collie = new Breed();
        collie.setId(1L);
        collie.setName("collie");
        //save Breed with name collie
        breedRepository.save(1L, collie);

        System.out.println("Add one breed in the repository!");
        // Query the breed
        List<Breed> getAllBreeds = breedRepository.getAllBreedsByName("collie");

        String breeds = "";
        for (Breed breed : getAllBreeds) {
            breeds += ("Breed:" + breed + "\n");
        }

        return "hello,Spring Boot " + breeds;
    }
}