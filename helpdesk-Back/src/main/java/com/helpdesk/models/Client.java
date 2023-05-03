package com.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdesk.enuns.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends People implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Called> calleds = new ArrayList<>();

    public Client() {
        super();
        addProfile(Profile.CLIENTE);
    }

    public Client(Integer id, String name, String cpf, String password, String email) {
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
