package unitec.org.elementos;

import java.util.ArrayList;
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
        
        //buscar todos
        ArrayList<Mensajitos> mensajitos= (ArrayList<Mensajitos>)repoMensa.findAll();
        for(Mensajitos mensa: mensajitos)
        {
            System.out.println(mensa.getTitulo());
        }
        
        //ahora probaremos el de buscar por id
        //Mensajitos ml=repoMensa.findOne( 1);
        //System.out.println(ml.getTitulo());
        
        //ACTUALIZACION
        //repoMensa.save(new Mensajitos(1,"otro","malo"));
        
        //BORRAR
        //repoMensa.delete(1);
    }
}
