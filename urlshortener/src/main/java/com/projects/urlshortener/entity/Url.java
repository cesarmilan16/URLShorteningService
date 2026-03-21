package com.projects.urlshortener.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Url {

    // Identificador interno de la URL en base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // URL completa que introduce el usuario y que se va a acortar.
    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;

    // Código único que se usa en el enlace corto.
    @Column(name = "short_code", unique = true, nullable = false)
    private String shortCode;

    // Número de veces que se ha resuelto esta URL corta.
    @Column(name = "access_count")
    private Long accessCount = 0L;

    // Fecha de creación del registro.
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Fecha de última actualización del registro.
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Url{" +
                "id: " + id +
                ", URL original: '" + originalUrl + '\'' +
                ", URL acortada: " + shortCode +
                ", Accesos a la URL: " + accessCount +
                "}";
    }

}
