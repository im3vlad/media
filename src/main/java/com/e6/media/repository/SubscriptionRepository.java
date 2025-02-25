package com.e6.media.repository;

import com.e6.media.model.entity.SubscriptionEntity;
import com.e6.media.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    Iterable<SubscriptionEntity> findAllByUser(UserEntity user);

}
