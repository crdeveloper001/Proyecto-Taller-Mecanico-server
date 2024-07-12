package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ContactRequestDTO;
import com.example.tallermecanicoserverv2.Repositories.ContactRequestRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServices {

    @Autowired
    private ContactRequestRepositories service;

    @Autowired
    private JavaMailSender emailSender;

    public ContactInfoServices(ContactRequestRepositories repo, JavaMailSender _javaMailSender) {
        this.service = repo;
        this.emailSender = _javaMailSender;
    }

    public String sendContactInfoEmail(ContactRequestDTO request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("crdevelopers506@gmail.com");
            message.setTo("crdevelopers506@gmail.com");
            message.setSubject("Solicitud de información proveniente de: " + request.getName());
            message.setText("Hola, el sistema ha recibido un nuevo correo del cliente: " + request.getName() + "\n" +
                    "Adjunto al sistema, viene la siguiente información: \n" +
                    "-----------------------------------------------------------------------------------\n" +
                    "Nombre del Cliente: " + request.getName() + "\n" +
                    "Apellidos: " + request.getEmail() + "\n" +
                    "Número de Teléfono: " + request.getPhone() + "\n" +
                    "Mensaje: "+ request.getMessage()+"\n"+
                    "-----------------------------------------------------------------------------------");

            emailSender.send(message);

            return "¡Muchas gracias por contactarnos! " + request.getName() + ", su información ha sido recibida. De igual forma, lo invitamos a usar nuestro chat público en nuestro sitio web.";
        } catch (Exception errorEmailSender) {
            return "Error al enviar el correo: " + errorEmailSender.getMessage();
        }
    }
}
