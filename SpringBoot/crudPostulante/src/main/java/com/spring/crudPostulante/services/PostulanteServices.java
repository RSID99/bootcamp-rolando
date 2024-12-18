package com.spring.crudPostulante.services;

import com.spring.crudPostulante.models.PostulanteModel;
import com.spring.crudPostulante.repositories.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulanteServices {
    @Autowired
    PostulanteRepository postulanteRepository;

    public List<PostulanteModel> getPostulantes(){
        return postulanteRepository.findAll();
    }

    public Optional<PostulanteModel> getPostulantesPorCedula(int nrocedula) {
        return postulanteRepository.findByNrocedula(nrocedula);
    }

    public PostulanteModel createPostulante(PostulanteModel postulante) {
        return postulanteRepository.save(postulante);
    }

    public PostulanteModel PostPostulante(PostulanteModel postulante) {
        return postulanteRepository.save(postulante);
    }


    public void deletePostulanteByNroCedula(int nrocedula) {
        Optional<PostulanteModel> postulante = postulanteRepository.findByNrocedula(nrocedula).stream().findFirst();
        if (postulante.isPresent()) {
            postulanteRepository.delete(postulante.get());
        } else {
            throw new RuntimeException("No encontrado Cedula: " + nrocedula);
        }
    }
}
