package com.motivus.Exercise.controller;

import com.motivus.Exercise.model.Producto;
import com.motivus.Exercise.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class CrudController {
    @Autowired
    private CrudService crudService;

    @GetMapping("/get")
    public List<Producto> obtenerTodosLosProductos() {
        return crudService.obtenerTodosLosProductos();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return crudService.obtenerProductoPorId(id)
                .map(producto -> ResponseEntity.ok(producto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = crudService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return ResponseEntity.ok(crudService.actualizarProducto(id, producto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        crudService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
 