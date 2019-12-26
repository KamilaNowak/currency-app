package com.nowak.demo.sub_service;

import com.nowak.demo.entities.Subscription;
import com.nowak.demo.respos.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription findBySubscription(String name) {
        return subscriptionRepository.findBySubscription(name);
    }
}
