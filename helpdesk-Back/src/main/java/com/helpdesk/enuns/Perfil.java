package com.helpdesk.enuns;

public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1,"ROLE_CLIENTE"), TECNICO(2,"ROLE_TECNICO");

    private Integer id;
    private String description;

    Perfil(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Perfil toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Perfil x : Perfil.values()){
            if (cod.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil não existe !");
    }
}
