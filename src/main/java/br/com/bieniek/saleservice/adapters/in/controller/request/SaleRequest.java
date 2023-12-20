package br.com.bieniek.saleservice.adapters.in.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

    @NotNull(message = "User ID is required")
    private Integer userId;
    @NotNull(message = "Product ID is required")
    private Integer productId;
    @NotNull(message = "Quantity is required")
    private Integer quantity;
    @NotNull(message = "Value is required")
    private BigDecimal value;
}
