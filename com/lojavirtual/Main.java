package com.lojavirtual;

import com.lojavirtual.modelo.Order;
import com.lojavirtual.modelo.Product;
import com.lojavirtual.notificacao.EmailNotificationService;
import com.lojavirtual.notificacao.NotificationService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Configuração da Injeção de Dependência (manual neste exemplo simples)
        NotificationService emailService = new EmailNotificationService();

        // Criando produtos
        Product product1 = new Product("Laptop", new BigDecimal("2500.00"));
        Product product2 = new Product("Mouse", new BigDecimal("150.00"));
        Product product3 = new Product("Teclado", new BigDecimal("300.00"));

        // Criando um pedido e injetando o serviço de notificação
        Order order = new Order("cliente@example.com", emailService);

        // Adicionando itens ao pedido
        order.addItem(product1);
        order.addItem(product2);
        order.addItem(product3);

        // Finalizando o pedido (que acionará a notificação)
        order.placeOrder();
    }
}
