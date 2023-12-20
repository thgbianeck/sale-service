package br.com.bieniek.saleservice.adapters.out;

import br.com.bieniek.saleservice.adapters.out.repository.SaleRepository;
import br.com.bieniek.saleservice.adapters.out.repository.mapper.SaleEntityMapper;
import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.ports.out.SaveSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
