package com.e6.media.controller;

import com.e6.media.model.entity.SubscriptionEntity;
import com.e6.media.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
      (this.subscriptionService) = subscriptionService;
    }

    @PostMapping
    public SubscriptionEntity addSubscription(@PathVariable Long userId, @RequestBody SubscriptionEntity subscription) {
        return subscriptionService.addSubscription (userId, subscription);
    }

    @GetMapping
    public Iterable<SubscriptionEntity> getSubscriptionsForUser(@PathVariable Long userId) {
        return(subscriptionService.getSubscriptionsForUser(userId));
    }

    @DeleteMapping("/{subId}")
    public void deleteSubscription(@PathVariable Long subId) {
        subscriptionService.deleteSubscription(subId);
    }
}
