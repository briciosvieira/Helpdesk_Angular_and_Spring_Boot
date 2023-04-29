package com.helpdesk.models;

import java.util.ArrayList;
import java.util.List;

public class Technician extends People{

    private List<Called> calleds = new ArrayList<>();

    public Technician() {
        super();
    }

    public Technician(Integer id, String name, String cpf, String password, String email) {
        super(id, name, cpf, password, email);
    }

    public List<Called> getCalleds() {
        return calleds;
    }

    public void setCalleds(List<Called> calleds) {
        this.calleds = calleds;
    }
}
