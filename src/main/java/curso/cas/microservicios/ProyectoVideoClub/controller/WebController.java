package curso.cas.microservicios.ProyectoVideoClub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired //Podemos pasar argumentos del arranque al controlador
    public WebController(ApplicationArguments args){
        //Mandamos a consola los argumentos
        args.getNonOptionArgs().forEach(argumento -> log.info(argumento));
    }

    @GetMapping("/videoclub")
    @ResponseBody
    public String index(@RequestParam String nombre){

        return "Hola Mundo " + nombre;
    }

}
