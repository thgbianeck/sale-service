package br.com.bieniek.saleservice.application.core.domain.enums;

import java.util.Arrays;

public enum SaleStatus {
    PENDING(1),
    FINALIZED(2),
    CANCELED(3);

    private final Integer statusId;

    SaleStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public static SaleStatus toEnum(Integer id) {
        if (id == null) return null;

       return Arrays.stream(SaleStatus.values())
                .filter(saleStatus -> id.equals(saleStatus.getStatusId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid SaleStatus Id"));
    }
}
