package com.lojavirtual.modelo;

import com.lojavirtual.notificacao.NotificationService;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Order {
    private String customerEmail;
    private List<Product> items;
    private NotificationService notificationService;

    public Order(String customerEmail, NotificationService notificationService) {
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
        this.notificationService = notificationService;
    }

    public void addItem(Product product) {
        this.items.add(product);
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void placeOrder() {
        System.out.println("Pedido realizado para: " + customerEmail);
        System.out.println("Itens do pedido:");
        items.forEach(item -> System.out.println("- " + item.getName() + " (R$ " + item.getPrice() + ")"));
        System.out.println("Total do pedido: R$ " + getTotal());

        String message = "Seu pedido foi realizado com sucesso! Total: R$ " + getTotal();
        notificationService.sendNotification(customerEmail, message);
    }
}
