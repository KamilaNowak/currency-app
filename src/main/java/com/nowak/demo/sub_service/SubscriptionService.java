package com.nowak.demo.sub_service;

import com.nowak.demo.entities.Subscription;

public interface SubscriptionService {

    Subscription findBySubscription(String name);
}
