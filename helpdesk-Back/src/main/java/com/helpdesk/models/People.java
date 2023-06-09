package com.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.helpdesk.enuns.Profile;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class People implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    @Column(unique = true)
    protected String cpf;
    protected String password;
    @Column(unique = true)
    protected String email;
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> profiles = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dateResgister = LocalDate.now();

    public People() {
        super();
        addProfile(Profile.CLIENTE);
    }

    public People(Integer id, String name, String cpf, String password, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        addProfile(Profile.CLIENTE);
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

    public Set<Profile> getPerfis() {
        return profiles.stream().map(x-> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getId());
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
