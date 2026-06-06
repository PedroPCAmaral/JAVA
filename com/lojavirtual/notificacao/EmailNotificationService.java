package com.lojavirtual.notificacao;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Enviando e-mail para: " + recipient + " com a mensagem: " + message);
        // Aqui você integraria com um serviço de envio de e-mail real
    }
}
