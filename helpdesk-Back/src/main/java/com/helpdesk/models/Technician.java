package com.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdesk.enuns.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technician extends People implements Serializable {
    private static final long serialVersionUID =1L;
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Called> calleds = new ArrayList<>();

    public Technician() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public Technician(Integer id, String name, String cpf, String password, String email) {
        super(id, name, cpf, password, email);
        addPerfis(Perfil.CLIENTE);
    }

    public List<Called> getCalleds() {
        return calleds;
    }

    public void setCalleds(List<Called> calleds) {
        this.calleds = calleds;
    }
}
