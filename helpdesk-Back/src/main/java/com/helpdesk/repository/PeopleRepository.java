package com.helpdesk.repository;

import com.helpdesk.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
    Optional<People> findByCpf(String cpf);
    Optional<People> findByEmail(String email);
}
