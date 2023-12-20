package br.com.bieniek.saleservice.application.ports.in;

import br.com.bieniek.saleservice.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
