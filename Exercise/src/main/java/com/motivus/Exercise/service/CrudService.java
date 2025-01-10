package com.motivus.Exercise.service;

import com.motivus.Exercise.model.Producto;
import com.motivus.Exercise.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    @Autowired
    private CrudRepository crudRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return crudRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return crudRepository.findById(id);
    }

    public Producto crearProducto(Producto producto) {
        return crudRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        productoActualizado.setId(id);
        return crudRepository.save(productoActualizado);
    }

    public void eliminarProducto(Long id) {
        crudRepository.deleteById(id);
    }
}
