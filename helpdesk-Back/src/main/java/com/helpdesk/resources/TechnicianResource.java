package com.helpdesk.resources;

import com.helpdesk.models.Technician;
import com.helpdesk.models.dto.TechnicianDTO;
import com.helpdesk.services.TechnicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource {

    private TechnicianService service;

    public TechnicianResource(TechnicianService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id){
        Technician obj = service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));

    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        List<Technician> list = service.findAll();
        List<TechnicianDTO> listDto = list.stream().map(TechnicianDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@RequestBody TechnicianDTO dto){
        Technician tech = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tech.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }
}
