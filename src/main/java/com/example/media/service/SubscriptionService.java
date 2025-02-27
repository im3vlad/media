package com.example.media.service;

import com.example.media.model.dto.SubscriptionDto;
import com.example.media.model.entity.SubscriptionEntity;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    SubscriptionEntity addSubscription(UUID userId, SubscriptionDto subscriptionDto);
    SubscriptionDto getSubscriptionsForUser(UUID userId);
    void deleteSubscription(UUID subId);
    List<SubscriptionDto> printTop3PopularSubscriptions();

}
