package com.API.libretaContactos.Repositorio;
// Importa las clases necesarias para definir un repositorio JPA en Spring.

import com.API.libretaContactos.Modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// @Repository indica que esta interfaz es un componente de repositorio en Spring,
// lo que facilita la implementación de patrones de acceso a datos.
@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
    // Esta interfaz extiende JpaRepository, proporcionando métodos CRUD (Crear, Leer, Actualizar, Eliminar)
    // y otras operaciones comunes para manejar la entidad Contacto.
    // La clase 'Contacto' es la entidad que se gestionará, y 'Integer' es el tipo de dato de la clave primaria.
}
