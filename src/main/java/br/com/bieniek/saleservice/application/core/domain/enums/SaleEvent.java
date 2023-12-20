package br.com.bieniek.saleservice.application.core.domain.enums;

public enum SaleEvent {
    CREATED_SALE,
    UPDATED_INVENTORY,
    VALIDATED_PAYMENT,
    ROLLBACK_INVENTORY,
    FAILED_PAYMENT;
}
