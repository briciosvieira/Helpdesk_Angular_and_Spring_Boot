package com.helpdesk.services;

import com.helpdesk.enuns.Profile;
import com.helpdesk.enuns.Priority;
import com.helpdesk.enuns.Status;
import com.helpdesk.models.Called;
import com.helpdesk.models.Client;
import com.helpdesk.models.Technician;
import com.helpdesk.repository.CalledRepository;
import com.helpdesk.repository.ClientRepository;
import com.helpdesk.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService  {

    private TechnicianRepository tech;
    private ClientRepository cl;
    private CalledRepository calle;

    public DBService(TechnicianRepository tech, ClientRepository cl, CalledRepository calle) {
        this.tech = tech;
        this.cl = cl;
        this.calle = calle;
    }
    public void instanceDB(){

        Technician tc1 = new Technician( null,"Fabricio","06679735599","123","fabricio@test.com");
        tc1.addProfile(Profile.ADMIN);

        Client cl1 = new Client(null,"Caio","06679735587","123","caio@test");

        Called cal1 = new Called(null,"Teste de chamado", Priority.MEDIA, Status.ABERTO,"Ola mundo",cl1,tc1);

        tech.saveAll(Arrays.asList(tc1));
        cl.saveAll(Arrays.asList(cl1));
        calle.saveAll(Arrays.asList(cal1));
    }
}
