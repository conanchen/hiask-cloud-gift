package org.ditto.gift.repository;

import org.ditto.gift.model.Dog;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import java.util.List;

@RepositoryConfig(cacheName = "DogCache")
public interface DogRepository extends IgniteRepository<Dog, Long> {
    List<Dog> getDogByName(String name);
    Dog getDogById (Long id);
}