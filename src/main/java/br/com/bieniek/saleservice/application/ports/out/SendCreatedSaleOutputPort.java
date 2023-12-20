package br.com.bieniek.saleservice.application.ports.out;

import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
