package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import ma.emsi.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {



        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,122));
            patientRepository.save(new Patient(null,"Omar",new Date(),false,321));
            patientRepository.save(new Patient(null,"Youssef",new Date(),false,165));
            patientRepository.save(new Patient(null,"Khalid",new Date(),false,132));



        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService ){
        return args->{
            securityService.saveNewUser("Mohamed","1234","1234");
            securityService.saveNewUser("yassine","1234","1234");
            securityService.saveNewUser("oussama","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("yassine","USER");
            securityService.addRoleToUser("oussama","USER");



        };
    }


    /*https://github.com/AbdessamadMoujani/patients-mvc*/

}
