package com.helpdesk.services;

import com.helpdesk.models.People;
import com.helpdesk.models.Technician;
import com.helpdesk.models.dto.TechnicianDTO;
import com.helpdesk.repository.PeopleRepository;
import com.helpdesk.repository.TechnicianRepository;
import com.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    private TechnicianRepository repository;
    private PeopleRepository peopleRepository;

    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    public Technician findById(Integer id){
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID: "+ id));
    }

    public List<Technician> findAll() {
        return repository.findAll();
    }

    public Technician create(TechnicianDTO dto) {
        dto.setId(null);
        validationCpfAndEmail(dto);
        Technician tech = new Technician(dto);
        return repository.save(tech);
    }

    private void validationCpfAndEmail(TechnicianDTO dto) {
        Optional<People> obj = peopleRepository.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getId() != dto.getId());
    }
}
