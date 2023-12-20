package br.com.bieniek.saleservice.adapters.out;

import br.com.bieniek.saleservice.adapters.out.message.SaleMessage;
import br.com.bieniek.saleservice.application.core.domain.Sale;
import br.com.bieniek.saleservice.application.core.domain.enums.SaleEvent;
import br.com.bieniek.saleservice.application.ports.out.SendCreatedSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCretaedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
