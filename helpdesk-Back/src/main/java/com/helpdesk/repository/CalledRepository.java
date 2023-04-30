package com.helpdesk.repository;

import com.helpdesk.models.Called;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledRepository extends JpaRepository<Called, Integer> {
}
