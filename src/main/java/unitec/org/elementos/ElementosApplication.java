package unitec.org.elementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner {

    //anotacion que inyecta las dependencias
    @Autowired RepositorioMensajitos repoMensa;
	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Mensajitos m=new Mensajitos("primero","mi primer mensajito con hibernate");
        repoMensa.save(m);
    }
}
