package br.com.bieniek.saleservice.adapters.in.controller.mapper;

import br.com.bieniek.saleservice.adapters.in.controller.request.SaleRequest;
import br.com.bieniek.saleservice.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
