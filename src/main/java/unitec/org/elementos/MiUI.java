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
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme ("valo")
public class MiUI extends UI{

    @Override
    protected void init(VaadinRequest request) {
     //agregaremos un leyout vertical y dentro de el las componentes 
     //que quedaran en orden descendente 
     VerticalLayout layout=new VerticalLayout();
     Label e1=new Label("Carlos Eduardo");
     e1.addStyleName(ValoTheme.LABEL_H1);
     
     Button b1=new Button("click aqui");
     b1.addStyleName(ValoTheme.BUTTON_HUGE);
     
     //Vamos a programar el evento del boton b1 usando programacion funcional 
     b1.addClickListener(algo->{
        //aqui vamos a poner el evento
        e1.setValue("Mi primer programacion funcional");
     });
     
     //agregamos las componentes al layout
     layout.addComponent(e1);
     layout.addComponent(b1);
     
     //esto que sigue solo se hace una vez 
     //Agregar el layout a la pagina index
     setContent(layout);
    }
    
}
