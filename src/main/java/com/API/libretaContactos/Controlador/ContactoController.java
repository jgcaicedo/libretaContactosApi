package com.API.libretaContactos.Controlador;

import com.API.libretaContactos.Modelo.Contacto;
import com.API.libretaContactos.Servicio.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> listarContactos() {
        return contactoService.obtenerTodosLosContactos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerContacto(@PathVariable Integer id) {
        Optional<Contacto> contacto = contactoService.obtenerContactoPorId(id);
        return contacto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoService.guardarContacto(contacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacto> actualizarContacto(@PathVariable Integer id, @RequestBody Contacto contactoDetalles) {
        Optional<Contacto> contacto = contactoService.obtenerContactoPorId(id);

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
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Integer id) {
        contactoService.eliminarContacto(id);
        return ResponseEntity.noContent().build();
    }
}
