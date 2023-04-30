package com.helpdesk.resources;

import com.helpdesk.models.Technician;
import com.helpdesk.services.TechnicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource {

    private TechnicianService service;

    public TechnicianResource(TechnicianService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Technician> findById(@PathVariable Integer id){
        Technician obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
