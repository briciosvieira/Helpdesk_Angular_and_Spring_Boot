package com.helpdesk.models;

import com.helpdesk.enuns.Priority;
import com.helpdesk.enuns.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Called {

    private Integer id;
    private String title;
    private LocalDate initialDate = LocalDate.now();
    private LocalDate finishDate;
    private Priority priority;
    private Status status;
    private String observation;

    private Client client;
    private Technician technician;

    public Called() {
    }

    public Called(Integer id, String title, Priority priority, Status status, String observation, Client client, Technician technician) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.observation = observation;
        this.client = client;
        this.technician = technician;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Called called)) return false;
        return getId().equals(called.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
