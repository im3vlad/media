package com.e6.media.service;

import com.e6.media.model.entity.SubscriptionEntity;
import com.e6.media.model.entity.UserEntity;
import com.e6.media.repository.SubscriptionRepository;
import com.e6.media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserRepository userRepository) {
       (this.subscriptionRepository) = subscriptionRepository;
        (this.userRepository) = userRepository;
    }

    public SubscriptionEntity addSubscription(Long userId, SubscriptionEntity subscription) {
        UserEntity user =userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        subscription.setUser(user);
        return(subscriptionRepository.save(subscription));
    }

    public Iterable<SubscriptionEntity> getSubscriptionsForUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return subscriptionRepository.findAllByUser(user);
    }

    public void deleteSubscription(Long subId) {
       subscriptionRepository.deleteById(subId);
    }
}
