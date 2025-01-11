package com.motivus.Exercise.kafka;

import com.motivus.Exercise.model.Notificacion;
import com.motivus.Exercise.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class NotificacionConsumer {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @KafkaListener(topics = "notificaciones", groupId = "notificaciones-group")
    public void consume(Notificacion notificacion){
        System.out.println("Notificacion recibida: " + notificacion.getMensaje());
        notificacionRepository.save(notificacion);
    }
}
