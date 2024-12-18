package com.spring.crudPostulante.controllers;
import com.spring.crudPostulante.models.PostulanteModel;
import com.spring.crudPostulante.services.PostulanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {
    @Autowired
    private PostulanteServices postulanteServices;
    @GetMapping
    public List<PostulanteModel> getPostulantes(){
        return postulanteServices.getPostulantes();
    }

    @GetMapping("/cedula")
    public ResponseEntity<Optional<PostulanteModel>> getPostulanteCedula(@RequestParam("nrocedula") int nrocedula) {
        Optional<PostulanteModel> postulante = postulanteServices.getPostulantesPorCedula(nrocedula);
        return postulante.isPresent()
                ? ResponseEntity.ok(postulante)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
    }

    @PostMapping
    public ResponseEntity<PostulanteModel> createPostulante(@RequestBody PostulanteModel postulante) {
        PostulanteModel createdPostulante = postulanteServices.createPostulante(postulante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPostulante);
    }

    @PostMapping("/modificar")
    public ResponseEntity<PostulanteModel> PostPostulante(@RequestBody PostulanteModel postulante, @RequestParam("id") Long id) {
        postulante.setId(id);
        PostulanteModel updatedPostulante = postulanteServices.PostPostulante(postulante);
        return ResponseEntity.ok(updatedPostulante);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deletePostulanteByNroCedula(@RequestParam("nrocedula") int nrocedula) {
        postulanteServices.deletePostulanteByNroCedula(nrocedula);
        return ResponseEntity.noContent().build();
    }

}
