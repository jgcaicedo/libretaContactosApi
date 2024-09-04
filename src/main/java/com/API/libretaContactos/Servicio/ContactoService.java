package com.API.libretaContactos.Servicio;

import com.API.libretaContactos.Modelo.Contacto;
import com.API.libretaContactos.Repositorio.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> obtenerTodosLosContactos() {
        return contactoRepository.findAll();
    }

    public Optional<Contacto> obtenerContactoPorId(Integer id) {
        return contactoRepository.findById(id);
    }

    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public void eliminarContacto(Integer id) {
        contactoRepository.deleteById(id);
    }
}
