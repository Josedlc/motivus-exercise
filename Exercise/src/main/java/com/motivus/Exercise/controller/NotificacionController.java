package com.motivus.Exercise.controller;

import com.motivus.Exercise.model.Notificacion;
import com.motivus.Exercise.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificationService notificacionService;

    @PostMapping("/send")
    public ResponseEntity<Void> registrarNotificacion(@RequestBody Notificacion notificacion){
        notificacionService.registrarNotificacion(notificacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Notificacion>> obtenerHistorial(){
        List<Notificacion> historial = notificacionService.obtenerHistorial();
        return ResponseEntity.ok(historial);
    }
}
