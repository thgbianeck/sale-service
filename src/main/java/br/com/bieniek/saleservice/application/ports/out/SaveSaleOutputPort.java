package br.com.bieniek.saleservice.application.ports.out;

import br.com.bieniek.saleservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
