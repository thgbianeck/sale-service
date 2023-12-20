package br.com.bieniek.saleservice.adapters.in.controller;

import br.com.bieniek.saleservice.adapters.in.controller.mapper.SaleRequestMapper;
import br.com.bieniek.saleservice.adapters.in.controller.request.SaleRequest;
import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;
    private final SaleRequestMapper saleRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@RequestBody @Valid SaleRequest saleRequest) {
        log.info("Creating sale...");
        var sale = saleRequestMapper.toSale(saleRequest);
        createSaleInputPort.create(sale);
        log.info("Sale created successfully");
    }
}
