package br.com.bieniek.saleservice.config.usecase;

import br.com.bieniek.saleservice.application.core.usecase.CreateSaleUseCase;
import br.com.bieniek.saleservice.application.ports.out.SaveSaleOutputPort;
import br.com.bieniek.saleservice.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        return new CreateSaleUseCase(saveSaleOutputPort, sendCreatedSaleOutputPort);
    }
}
