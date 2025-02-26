package com.example.media.service;

import com.example.media.mapper.SubscriptionMapper;
import com.example.media.model.dto.SubscriptionDto;
import com.example.media.model.entity.SubscriptionEntity;
import com.example.media.model.entity.UserEntity;
import com.example.media.repository.SubscriptionRepository;
import com.example.media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Transactional
    public SubscriptionEntity addSubscription(UUID userId, SubscriptionDto subscription) {
        SubscriptionEntity subscriptionEntity = subscriptionMapper.mapFromSubscriptionDto(subscription);
        subscription.setSubId(userId);
        return subscriptionRepository.save(subscriptionEntity);
    }

    public SubscriptionDto getSubscriptionsForUser(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        SubscriptionEntity subscriptionEntity = subscriptionRepository.findAllByUser(user);
        return subscriptionMapper.mapFromSubscriptionEntity(subscriptionEntity);
    }
    @Transactional
    public void deleteSubscription(UUID subId) {
       subscriptionRepository.deleteById(subId);
    }


}
