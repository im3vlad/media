package com.example.media.repository;

import com.example.media.model.entity.SubscriptionEntity;
import com.example.media.model.entity.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    SubscriptionEntity findAllByUser(UserEntity user);
    void deleteById(UUID subId);
    @Query("SELECT s.serviceName, COUNT(s.user) as subscriptionCount " +
            "FROM subscriptions s " +
            "GROUP BY s.serviceName " +
            "ORDER BY subscriptionCount DESC")
    List<SubscriptionEntity> findTop3PopularSubscriptions(PageRequest pageRequest);
}
