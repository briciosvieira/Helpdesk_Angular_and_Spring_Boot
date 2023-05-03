package com.helpdesk.enuns;

public enum Profile {
    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1,"ROLE_CLIENTE"), TECNICO(2,"ROLE_TECNICO");

    private Integer id;
    private String description;

    Profile(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Profile x : Profile.values()){
            if (cod.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Profile não existe !");
    }
}
