package mx.com.gm.HelloThymeleaf;
//Es un controlador tipo Rest que es el más sencillo que se puede usar
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Controller //no es un controlador Rest

@Slf4j //para el manejo de logging

public class InitController {
    //Método:

    @GetMapping("/") //debo poner esta notación para indicar la ruta al siguiente método, en este
    // caso / que es http://localhost:8080

    public String  init(Model model){//vamos a recibir un objeto tipo Model
        log.info("ejecutanto el controlador Spring MVC");  //Esto puedo hacerlo gracias a la notación de manejo de logging.

        return "Index"; //Voy a crear un archivo llamado html para que esto retorne una página. Lo creo en
        // src-main-resources-templates-new-htmlFile
    }
}
