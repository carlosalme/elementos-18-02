package unitec.org.elementos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //las entidades todas las vamos a marcar jpa por ser el standart
public class Mensajitos {
    //@column(name="nombrecolumnapk") se ocupa cuando no se tiene el mismo nombre que en la tabla
    @Id 
    /*cuando la pk es autoincrementable se hace esta anotacion*/
    @GeneratedValue 
    private Integer id;
    private String titulo;
    private String cuerpo;

    public Mensajitos(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(Integer id) {
        this.id = id;
    }

    public Mensajitos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
