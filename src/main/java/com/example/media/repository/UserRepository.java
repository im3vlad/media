package com.example.media.repository;
import com.example.media.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    void deleteById(UUID id);
    Optional<UserEntity> findById(UUID id);
}