package com.example.media.controller;

import com.example.media.model.dto.SubscriptionDto;
import com.example.media.model.entity.SubscriptionEntity;
import com.example.media.service.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionServiceImpl subscriptionService;

    @PostMapping
    public SubscriptionEntity addSubscription(@PathVariable UUID userId, @RequestBody SubscriptionDto subscription) {
        return subscriptionService.addSubscription (userId, subscription);
    }

    @GetMapping
    public SubscriptionDto getSubscriptionsForUser(@PathVariable UUID userId) {
        return subscriptionService.getSubscriptionsForUser(userId);
    }

    @DeleteMapping("/{subId}")
    public void deleteSubscription(@PathVariable UUID subId) {
        subscriptionService.deleteSubscription(subId);
    }
}
