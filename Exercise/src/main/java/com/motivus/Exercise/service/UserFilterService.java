package com.motivus.Exercise.service;

import com.motivus.Exercise.model.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFilterService {

    @Value("${usuarios.filtered.path}")
    private String outputPath;
    @Value("${usuarios.list.path}")
    private String inputFilePath;

    public String procesarUsuarios(int min, int max) {
        String outputFilePath = generarNombreArchivoSalida(min, max);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            List<User> usuariosFiltrados = reader.lines()
                    .skip(1)
                    .parallel()
                    .map(line -> {
                        String[] fields = line.split(",");
                        Long id = Long.parseLong(fields[0]);
                        String firstName = fields[1];
                        String lastName = fields[2];
                        String email = fields[3];
                        String gender = fields[4];
                        int age = Integer.parseInt(fields[5]);
                        return new User(id, firstName, lastName, email, gender, age);
                    })
                    .filter(usuario -> usuario.getAge() >= min && usuario.getAge() <= max)
                    .collect(Collectors.toList());


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("id,first_name,last_name,email,gender,age\n");
                for (User usuario : usuariosFiltrados) {
                    writer.write(usuario.getId() + "," +
                            usuario.getFirstName() + "," +
                            usuario.getLastName() + "," +
                            usuario.getEmail() + "," +
                            usuario.getGender() + "," +
                            usuario.getAge() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFilePath;
    }

    private String generarNombreArchivoSalida(int min, int max) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = LocalDate.now().format(formatter);
        return outputPath +"/user-filter-range-"+ min + "-" +max+"-"+ fecha + ".csv";
    }

}
