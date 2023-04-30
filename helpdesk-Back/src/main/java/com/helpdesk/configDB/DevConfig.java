package com.helpdesk.configDB;

import com.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    private DBService dbService;

    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
   public void instanceDB(){
        if(value.equals("create")){
          this.dbService.instanceDB();
        }
    }
}
