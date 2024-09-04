package com.API.libretaContactos.Controlador;
// Importa las clases necesarias para manejar solicitudes HTTP y trabajar con la lógica de negocio de contactos.
import com.API.libretaContactos.Modelo.Contacto;
import com.API.libretaContactos.Servicio.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// La anotación @RestController indica que esta clase manejará solicitudes HTTP y devolverá respuestas JSON.
@RestController
// @RequestMapping define la ruta base para todas las rutas dentro de este controlador.
@RequestMapping("/api/contactos")
public class ContactoController {
    // Inyecta el servicio de Contacto para acceder a la lógica de negocio relacionada con los contactos.
    @Autowired
    private ContactoService contactoService;
    // @GetMapping define una ruta GET para obtener una lista de todos los contactos.
    @GetMapping
    public List<Contacto> listarContactos() {
        return contactoService.obtenerTodosLosContactos();
    }
    // @GetMapping con un parámetro de ruta ({id}) para obtener un contacto específico por su ID.
    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerContacto(@PathVariable Integer id) {
        // Busca un contacto por su ID utilizando el servicio.
        Optional<Contacto> contacto = contactoService.obtenerContactoPorId(id);
        // Si el contacto existe, devuelve un ResponseEntity con el contacto y un código de estado 200 (OK).
        // Si no existe, devuelve un ResponseEntity con un código de estado 404 (Not Found).

        return contacto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // @PostMapping define una ruta POST para crear un nuevo contacto.
    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoService.guardarContacto(contacto);
    }
    // @PutMapping con un parámetro de ruta ({id}) para actualizar un contacto existente.
    @PutMapping("/{id}")
    public ResponseEntity<Contacto> actualizarContacto(@PathVariable Integer id, @RequestBody Contacto contactoDetalles) {
        // Busca el contacto por su ID.
        Optional<Contacto> contacto = contactoService.obtenerContactoPorId(id);
        // Si el contacto existe, actualiza sus detalles y guarda los cambios.
        if (contacto.isPresent()) {
            Contacto contactoActualizado = contacto.get();
            contactoActualizado.setNombre(contactoDetalles.getNombre());
            contactoActualizado.setApellido(contactoDetalles.getApellido());
            contactoActualizado.setCorreo(contactoDetalles.getCorreo());
            contactoActualizado.setTelefono(contactoDetalles.getTelefono());
            contactoActualizado.setCelular(contactoDetalles.getCelular());
            contactoActualizado.setDireccion(contactoDetalles.getDireccion());
            return ResponseEntity.ok(contactoService.guardarContacto(contactoActualizado));
        } else {
            // Si no se encuentra el contacto, devuelve un código de estado 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
    // @DeleteMapping con un parámetro de ruta ({id}) para eliminar un contacto por su ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Integer id) {
        // Llama al servicio para eliminar el contacto por su ID.
        contactoService.eliminarContacto(id);
        // Devuelve un ResponseEntity con un código de estado 204 (No Content) indicando que la operación fue exitosa.
        return ResponseEntity.noContent().build();
    }
}
