package dto;

import entity.PaymentStatusEnum;

import java.util.List;

public class OrederRequest {
    private List<OrderItimesRequest> orderItems;
    private Long clientId;
    private PaymentStatusEnum peymentStatus;

    public List<OrderItimesRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItimesRequest> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public PaymentStatusEnum getPeymentStatus() {
        return peymentStatus;
    }

    public void setPeymentStatus(PaymentStatusEnum peymentStatus) {
        this.peymentStatus = peymentStatus;
    }
}
