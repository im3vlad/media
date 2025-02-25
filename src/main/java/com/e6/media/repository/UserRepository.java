package com.e6.media.repository;
import com.e6.media.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    void deleteById(UUID id);
    Optional<Object> findById(UUID id);
}