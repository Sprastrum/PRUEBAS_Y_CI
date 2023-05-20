package com.unisabana.software.tienda.rabbitmq;

import com.unisabana.software.tienda.controller.dto.SaleDTO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@EnableRabbit
public class PublishMessage {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendSale(SaleDTO saleDTO) {
        rabbitTemplate.convertAndSend("adminShop", "sale", saleDTO);
    }
}
