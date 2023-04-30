package com.helpdesk.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.helpdesk.enuns.Perfil;
import com.helpdesk.models.People;
import com.helpdesk.models.Technician;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TechnicianDTO extends People implements Serializable {
    private static final long serialVersionUID =1L;

    protected Integer id;
    protected String name;
    protected String cpf;
    protected String password;
    protected String email;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dateResgister = LocalDate.now();


    public TechnicianDTO() {
        super();
    }

    public TechnicianDTO(Technician obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.password = obj.getPassword();
        this.email = obj.getEmail();
        this.perfis = obj.getPerfis().stream().map(x->x.getId()).collect(Collectors.toSet());
        this.dateResgister = obj.getDateResgister();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x-> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfil) {
        this.perfis.add(perfil.getId());
    }

    @Override
    public LocalDate getDateResgister() {
        return dateResgister;
    }

    @Override
    public void setDateResgister(LocalDate dateResgister) {
        this.dateResgister = dateResgister;
    }
}
