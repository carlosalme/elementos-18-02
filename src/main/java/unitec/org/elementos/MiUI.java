/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme ("valo")
public class MiUI extends UI{
    public TextField t1;
    public TextField t2;
    public Integer id;
    @Autowired
    RepositorioMensajitos repoMensa;

    @Override
    protected void init(VaadinRequest request) {
        
        t1=new TextField();
        t2=new TextField();
     
     VerticalLayout layout=new VerticalLayout();
     Label e1=new Label("Carlos Eduardo");
     e1.addStyleName(ValoTheme.LABEL_H1);
     
     Button b1=new Button("Guardar");
     b1.addStyleName(ValoTheme.BUTTON_HUGE);
     
     //Vamos a programar el evento del boton b1 usando programacion funcional 
     b1.addClickListener(algo->{
        //aqui vamos a poner el evento
        //e1.setValue("Mi primer programacion funcional");
        //Notification.show("Error", Notification.Type.ERROR_MESSAGE);
        t1.setValue("");
        t2.setValue("");
        VentanaGuardar sub = new VentanaGuardar();
    
        UI.getCurrent().addWindow(sub);
        
     });
     
     //agregamos las componentes al layout
     layout.addComponent(e1);
     layout.addComponent(b1);
     
     //esto que sigue solo se hace una vez 
     //Agregar el layout a la pagina index
     setContent(layout);
     
     // Have some data
List<Mensajitos> mensaje = (List<Mensajitos>) repoMensa.findAll();

// Create a grid bound to the list
Grid<Mensajitos> grid = new Grid<>();
grid.setItems(mensaje);
grid.addColumn(Mensajitos::getId).setCaption("ID");
grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo");
grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo del mensaje");

//agregar al grid el modo de seleccion unico
grid.setSelectionMode(SelectionMode.SINGLE);

grid.addItemClickListener(evento -> {
    //Notification.show("Valor: "+ evento.getItem().getTitulo());
    id=evento.getItem().getId();
    t1.setValue(evento.getItem().getTitulo());
    t2.setValue(evento.getItem().getCuerpo());
    Ventana sub = new Ventana();
    
    UI.getCurrent().addWindow(sub);
    
});

layout.addComponent(grid);
    }
    


class Ventana extends Window {
    public Ventana(){
        super("actualizar o borrar");
        center();
        VerticalLayout v12 =new VerticalLayout();
        
        //TextField t1=new TextField();
        //TextField t2=new TextField();
        
        
        Button boton =new Button ("actualizar");
        Button botonborrar = new Button ("borrar");
        
        botonborrar.addAttachListener(eventoborrar-> {
           repoMensa.delete(id);
        });
                
        boton.addClickListener(evento -> {
            repoMensa.save(new Mensajitos(id,t1.getValue(),t2.getValue()));
            close();
        });
        v12.addComponent(t1);
        v12.addComponent(t2);
        v12.addComponent(boton);
        v12.addComponent(botonborrar);
        
        setContent(v12);
    }
    
    class VentanaGuardar extends Window {
    public VentanaGuardar(){
        super("guardar");
        center();
        VerticalLayout v12 =new VerticalLayout();
        
        //TextField t1=new TextField();
        //TextField t2=new TextField();
        
        
        Button boton =new Button ("guardar");
        boton.addClickListener(evento -> {
            repoMensa.save(new Mensajitos(id,t1.getValue(),t2.getValue()));
            close();
        });
        
        v12.addComponent(t1);
        v12.addComponent(t2);
        v12.addComponent(boton);
        
        setContent(v12);
    
    }

    }
}