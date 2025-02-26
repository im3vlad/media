package com.e6.media.service;

import com.e6.media.model.entity.SubscriptionEntity;
import com.e6.media.model.entity.UserEntity;
import com.e6.media.repository.SubscriptionRepository;
import com.e6.media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, UserRepository userRepository) {
       this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
    }

    public SubscriptionEntity addSubscription(UUID userId, SubscriptionEntity subscription) {
        UserEntity user = (UserEntity) userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("Пользователь не найден"));
        subscription.setId(userId);
        return(subscriptionRepository.save(subscription));
    }

    public Iterable<SubscriptionEntity> getSubscriptionsForUser(UUID userId) {
        UserEntity user = (UserEntity) userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return subscriptionRepository.findAllByUser(user);
    }

    public void deleteSubscription(UUID subId) {
       subscriptionRepository.deleteById(subId);
    }
}
