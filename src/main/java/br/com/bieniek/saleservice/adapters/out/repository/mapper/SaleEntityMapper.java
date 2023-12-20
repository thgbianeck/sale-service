package br.com.bieniek.saleservice.adapters.out.repository.mapper;

import br.com.bieniek.saleservice.adapters.out.repository.entity.SaleEntity;
import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(final Sale sale);

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(final SaleEntity saleEntity);

    @Named("setStatusId")
    default Integer setStatusId(final Sale sale){
        return sale.getStatus().getStatusId();
    }

    @Named("setStatus")
    default SaleStatus setStatus(final SaleEntity saleEntity){
        return SaleStatus.toEnum(saleEntity.getStatusId());
    }
}
