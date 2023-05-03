package com.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdesk.enuns.Profile;
import com.helpdesk.models.dto.TechnicianDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Technician extends People implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Called> calleds = new ArrayList<>();

    public Technician() {
        super();
        addProfile(Profile.CLIENTE);
    }

    public Technician(TechnicianDTO obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.password = obj.getPassword();
        this.email = obj.getEmail();
        this.profiles = obj.getPerfis().stream().map(x->x.getId()).collect(Collectors.toSet());
        this.dateResgister = obj.getDateResgister();
    }
    public Technician(Integer id, String name, String cpf, String password, String email) {
        super(id, name, cpf, password, email);
        addProfile(Profile.CLIENTE);
    }

    public List<Called> getCalleds() {
        return calleds;
    }

    public void setCalleds(List<Called> calleds) {
        this.calleds = calleds;
    }
}
