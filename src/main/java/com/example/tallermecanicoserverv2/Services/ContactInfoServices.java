package com.example.tallermecanicoserverv2.Services;

import com.example.tallermecanicoserverv2.DTO.UtilsDTO.ContactRequestDTO;
import com.example.tallermecanicoserverv2.Interfaces.IContactRequest;
import com.example.tallermecanicoserverv2.Repositories.ContactRequestRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class ContactInfoServices implements IContactRequest {

    @Autowired
    private ContactRequestRepositories service;

    private JavaMailSenderImpl mailSender;

    public ContactInfoServices(ContactRequestRepositories repo,JavaMailSenderImpl _javaMailSender) {
        this.service = repo;
        this.mailSender = _javaMailSender;
    }

    public ContactInfoServices() {
    }
    public JavaMailSender getJavaMailSender() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("servicioautomotrizchaconcr@gmail.com");
        mailSender.setPassword("TallerChacon2023.");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtpout");
        props.put("mail.smtpout.auth", "true");
        props.put("mail.smtpout.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }


    @Override
    public String SaveContactInfoDB(ContactRequestDTO information) {
        try{

            if (information != null){
                service.save(information);

                return "Registro Completo";
            }else{

                return "Verifique la informacion";
            }

        }catch (Exception errorInsert){
            return errorInsert.getMessage();
        }
    }
    @Override
    public String SendContactInfoEmail(ContactRequestDTO request) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("servicioautomotrizchaconcr@gmail.com");
            message.setTo("servicioautomotrizchaconcr@gmail.com");
            message.setSubject("Solicitud de informacion proveniente de: "+request.getName());
            message.setText("Hola, el sistema ha recibido un nuevo correo del cliente: "+request.getName()+"\n"+"" +
                    "Adjunto al sistema, viene la siguiente informacion: "+"\n"+"_____________________________________________________________"+"\n" +
                    "Nombre del Cliente: "+request.getName()+"\n"+
                    "Apellidos: "+request.getEmail()+"\n"+
                    "Numero de Telefono: "+request.getPhone()+"\n"+
                    "----------------------------------------- ------------------------------------------");
            mailSender.send(message);
            SendContactInfoEmail(request);
            return "Muchas gracias por contactanos! "+request.getName()+ "su informacion ha sido recibida, de igual forma, lo invitamos a usar nuestro chat publico en nuestro sitio web";
        }catch (Exception errorEmailSender){

            return errorEmailSender.getMessage();
        }
    }
    @Override
    public List<ContactRequestDTO> GetHistoryRequests() {
        return service.findAll();
    }
}
