package org.ditto.gift.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.gift.model.Gift;

@RepositoryConfig(cacheName = "GiftCache")
public interface GiftRepository extends IgniteRepository<Gift, String> {
}