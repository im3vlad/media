package com.e6.media.service;

import com.e6.media.model.entity.SubscriptionEntity;

import java.util.UUID;

public interface SubscriptionService {
    SubscriptionEntity addSubscription(UUID userId, SubscriptionEntity subscriptionEntity);
    Iterable<SubscriptionEntity> getSubscriptionsForUser(UUID userId);
    void deleteSubscription(UUID subId);
}
