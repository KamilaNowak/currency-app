package com.nowak.demo.respos;

import com.nowak.demo.entities.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
}
