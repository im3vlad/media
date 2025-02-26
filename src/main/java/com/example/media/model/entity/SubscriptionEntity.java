package com.example.media.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


import java.util.UUID;


@Entity
@Table(name = "subscriptions")
@Data
public class SubscriptionEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;

    @Setter
    @Column(nullable = false)
    private String serviceName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
