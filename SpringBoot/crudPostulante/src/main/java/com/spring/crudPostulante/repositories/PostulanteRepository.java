package com.spring.crudPostulante.repositories;

import com.spring.crudPostulante.models.PostulanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostulanteRepository extends JpaRepository<PostulanteModel, Long> {
    Optional<PostulanteModel> findByNrocedula(int nrocedula);
}
