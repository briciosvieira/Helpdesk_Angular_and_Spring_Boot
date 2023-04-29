package com.helpdesk.enuns;

public enum Priority {
    BAIXA(0, "BAIXA"), MEDIA(1,"MEDIA"), ALTA(2,"ALTA");

    private Integer id;
    private String description;

    Priority(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Priority x : Priority.values()){
            if (cod.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválido");
    }
}
