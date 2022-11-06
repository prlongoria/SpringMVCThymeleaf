package mx.com.gm.HelloThymeleaf;
//Es un controlador tipo Rest que es el más sencillo que se puede usar
import mx.com.gm.HelloThymeleaf.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Controller //no es un controlador Rest

@Slf4j //para el manejo de logging

public class InitController {
    //Para acceder al mensaje que puse en application.properties
    @Value("${index.greeting}") //Ojo esta notación es la de springframework, no la de lombok
    private String greeting;//Así Spring aplica el concepto de inyección de dependencias

    //Método (ya no tiene que ver con application properties):
    @GetMapping("/") //debo poner esta notación para indicar la ruta al siguiente método, en este
    // caso / que es http://localhost:8080. COn esta notación puedo recibir distintos argumentos en los métodos. Yo
    // no tengo que instanciar una clase, de eso se encarga Spring para que yo sólo tenga que utilizar esas clases

    public String  init(Model model){//vamos a recibir un objeto tipo Model. Con la clase Model voy a agregar la info
        // que quiero compartir con la vista

        //Inicio una variable local:
        var message = "Hello World with Thymeleaf";//es la variable que voy a compartir utilizando la clase Model

        var person = new Person();//Para instanciar la clase person
        person.setName("Juan");//meto los valores para crear la variable persona y poder compartirla usando la clase model
        person.setSurname("Perez");
        person.setEmail("jperez@mail.com");
        person.setPhone("5544332211");
        log.info("ejecutanto el controlador Spring MVC");  //Esto puedo hacerlo gracias a la notación de manejo de logging.

        model.addAttribute("message", message); //utilizo la clase de modelo(que es un mapa) para compartir la variable
        // message, y el método al ser un mapa, lleva el String y el objeto: "llave" y valor

        //También puedo agregar un mensaje en application properties

        model.addAttribute("greeting", greeting);//ahora debo ir a la vista, index, y desplegar esta información

        //Para compartir la variable person usando mi clase Model:
        model.addAttribute("person", person); //llave person, objeto person que creé arriba al instanciar
        // la clase Person. AHora ya voy a la vista

        return "Index"; //Voy a crear un archivo llamado html para que esto retorne una página. Lo creo en
        // src-main-resources-templates-new-htmlFile. ESTE ARCHIVO ES MI VISTA, DESDE DONDE VOY A LLAMAR A LAS
        // VARIABLES DE ESTE CONTROLADOR, EL MODELO LO PONE SPRING EN AUTOMÁTICO

    }
}
