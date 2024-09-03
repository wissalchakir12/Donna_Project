package org.example.donnabackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{

    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleEmail(String toEmail)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Confirmation de votre commande chez Donna");
        message.setText("Bonjour ,\n" +
                "\n" +
                "Nous vous remercions d'avoir choisi Donna pour votre achat !\n" +
                "\n" +
                "Nous sommes heureux de vous informer que votre commande a été reçue et est en cours de traitement." +
                "Pour toute question ou assistance, n'hésitez pas à nous contacter à " +
                "d56145759@gmail.com ou à répondre directement à cet email. Notre équipe est là pour vous aider !\n" +
                "\n" +
                "Encore une fois, merci de votre confiance et de faire partie de la famille Donna.\n" +
                "\n" +
                "Cordialement,\n" +
                "L'équipe Donna\n");
        message.setFrom("d56145759@gmail.com");

        mailSender.send(message);
        System.out.println("Email envoyé avec succès à " + toEmail);
    }
}
