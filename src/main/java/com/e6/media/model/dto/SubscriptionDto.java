package com.e6.media.model.dto;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public class SubscriptionDto {
    private UUID subId = UUID.randomUUID();
    private String serviceName;

    public SubscriptionDto(UUID subId, String serviceName) {
        this.subId = subId;
        this.serviceName = serviceName;
    }

    public UUID getSubId() {
        return subId;
    }

    public void setSubId(UUID subId) {
        this.subId = subId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionDto that = (SubscriptionDto) o;
        return Objects.equals(subId, that.subId) && Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId, serviceName);
    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "subId=" + subId +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
