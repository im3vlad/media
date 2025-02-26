package com.example.media.repository;

import com.example.media.model.entity.SubscriptionEntity;
import com.example.media.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    SubscriptionEntity findAllByUser(UserEntity user);
    void deleteById(UUID subId);
}
