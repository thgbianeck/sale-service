package br.com.bieniek.saleservice.application.core.usecase;

import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.core.domain.enums.SaleEvent;
import br.com.bieniek.saleservice.application.core.domain.enums.SaleStatus;
import br.com.bieniek.saleservice.application.ports.out.SaveSaleOutputPort;
import br.com.bieniek.saleservice.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    public void create(Sale sale){
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
