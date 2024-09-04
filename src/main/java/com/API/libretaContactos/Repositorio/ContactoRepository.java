package com.API.libretaContactos.Repositorio;

import com.API.libretaContactos.Modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
