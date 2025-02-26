package com.e6.media.controller;

import com.e6.media.model.entity.SubscriptionEntity;
import com.e6.media.service.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    private final SubscriptionServiceImpl subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionServiceImpl subscriptionService) {
      this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public SubscriptionEntity addSubscription(@PathVariable UUID userId, @RequestBody SubscriptionEntity subscription) {
        return subscriptionService.addSubscription (userId, subscription);
    }

    @GetMapping
    public Iterable<SubscriptionEntity> getSubscriptionsForUser(@PathVariable UUID userId) {
        return subscriptionService.getSubscriptionsForUser(userId);
    }

    @DeleteMapping("/{subId}")
    public void deleteSubscription(@PathVariable UUID subId) {
        subscriptionService.deleteSubscription(subId);
    }
}
