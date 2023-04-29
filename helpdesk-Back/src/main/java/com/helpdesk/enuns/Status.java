package com.helpdesk.enuns;

public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1,"ANDAMENTO"), ENCERRADO(2,"ENCERRADO");

    private Integer id;
    private String description;

    Status(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Status x : Status.values()){
            if (cod.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
