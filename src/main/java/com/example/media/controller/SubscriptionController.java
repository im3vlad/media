package com.example.media.controller;

import com.example.media.model.dto.SubscriptionDto;
import com.example.media.model.entity.SubscriptionEntity;
import com.example.media.service.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionServiceImpl subscriptionService;

    @PostMapping
    public SubscriptionEntity addSubscription(@PathVariable UUID userId, @RequestBody SubscriptionDto subscription) {
        log.info("добавить подписку");
        return subscriptionService.addSubscription (userId, subscription);
    }

    @GetMapping
    public SubscriptionDto getSubscriptionsForUser(@PathVariable UUID userId) {
        log.info("получить подписки пользователя");
        return subscriptionService.getSubscriptionsForUser(userId);
    }

    @DeleteMapping("/{subId}")
    public void deleteSubscription(@PathVariable UUID subId) {
        log.info("удалить подписку");
        subscriptionService.deleteSubscription(subId);
    }

    @GetMapping("/top")
    public List<SubscriptionDto> printTop3PopularSubscriptions(){
        log.info("получить ТОП-3 популярных подписок");
        return subscriptionService.printTop3PopularSubscriptions();
    }
}
