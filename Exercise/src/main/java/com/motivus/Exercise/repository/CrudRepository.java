package com.motivus.Exercise.repository;

import com.motivus.Exercise.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrudRepository extends JpaRepository<Producto, Long> {


}
