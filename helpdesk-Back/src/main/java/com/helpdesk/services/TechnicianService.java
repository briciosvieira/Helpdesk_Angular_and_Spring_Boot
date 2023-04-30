package com.helpdesk.services;

import com.helpdesk.models.Technician;
import com.helpdesk.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    private TechnicianRepository repository;

    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    public Technician findById(Integer id){
        Optional<Technician> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
