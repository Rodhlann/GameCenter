package GameCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tim on 1/16/2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class GameCenter {
    public static void main(String[] args) {
        SpringApplication.run(GameCenter.class, args);
    }
}

@RestController
class GameController {
    @RequestMapping("/games")
    Solitaire hello() {
        Solitaire solitaire = new Solitaire();
        solitaire.startGame();
        return solitaire;
    }
}
