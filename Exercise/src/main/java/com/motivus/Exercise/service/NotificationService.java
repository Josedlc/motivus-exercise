package com.motivus.Exercise.service;

import com.motivus.Exercise.model.Notificacion;
import com.motivus.Exercise.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private KafkaTemplate<String, Notificacion> kafkaTemplate;

    public void registrarNotificacion(Notificacion notificacion) {
        // Guardar la notificación en la base de datos
        notificacionRepository.save(notificacion);
        // Enviar la notificación a Kafka
        kafkaTemplate.send("notificaciones", notificacion);
    }

    public List<Notificacion> obtenerHistorial() {
        return notificacionRepository.findAll();
    }

}
