package com.helpdesk.models;

import com.helpdesk.enuns.Perfil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class People {

    protected Integer id;
    protected String name;
    protected String cpf;
    protected String password;
    protected String email;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate dateResgister = LocalDate.now();

    public People() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public People(Integer id, String name, String cpf, String password, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        addPerfis(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x-> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfil) {
        this.perfis.add(perfil.getId());
    }

    public LocalDate getDateResgister() {
        return dateResgister;
    }

    public void setDateResgister(LocalDate dateResgister) {
        this.dateResgister = dateResgister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People people)) return false;
        return getId().equals(people.getId()) && getCpf().equals(people.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf());
    }
}
