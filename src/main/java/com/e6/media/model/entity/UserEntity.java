package com.e6.media.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private UUID userid;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", cascade =CascadeType.ALL, orphanRemoval = true)
    private Set<SubscriptionEntity> subscriptions;

    public UserEntity(UUID userId, String userName) {
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", subscriptions=" + subscriptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userid, that.userid) && Objects.equals(name, that.name) && Objects.equals(subscriptions, that.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, subscriptions);
    }
}
