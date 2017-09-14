package org.ditto.gift.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.gift.model.Giftgroup;

@RepositoryConfig(cacheName = "GiftgroupCache")
public interface GiftgroupRepository extends IgniteRepository<Giftgroup, String> {
}