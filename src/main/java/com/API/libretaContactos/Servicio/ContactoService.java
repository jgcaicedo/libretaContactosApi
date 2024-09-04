package com.API.libretaContactos.Servicio;

// Importa las clases necesarias para implementar la lógica de negocio relacionada con los contactos.
import com.API.libretaContactos.Modelo.Contacto;
import com.API.libretaContactos.Repositorio.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// La anotación @Service indica que esta clase es un componente de servicio en Spring,
// encargado de manejar la lógica de negocio.
@Service
public class ContactoService {

    // Inyecta el repositorio de Contacto para acceder a las operaciones de la base de datos.
    @Autowired
    private ContactoRepository contactoRepository;

    // Método para obtener todos los contactos de la base de datos.
    public List<Contacto> obtenerTodosLosContactos() {
        // Utiliza el repositorio para recuperar todos los contactos.
        return contactoRepository.findAll();
    }

    // Método para obtener un contacto específico por su ID.
    public Optional<Contacto> obtenerContactoPorId(Integer id) {
        // Utiliza el repositorio para encontrar un contacto por su ID.
        return contactoRepository.findById(id);
    }

    // Método para guardar un nuevo contacto o actualizar un contacto existente en la base de datos.
    public Contacto guardarContacto(Contacto contacto) {
        // Utiliza el repositorio para guardar el contacto.
        return contactoRepository.save(contacto);
    }

    // Método para eliminar un contacto por su ID.
    public void eliminarContacto(Integer id) {
        // Utiliza el repositorio para eliminar el contacto con el ID especificado.
        contactoRepository.deleteById(id);
    }
}
