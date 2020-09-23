package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {
	//	private static final Logger log = LoggerFactory.getLogger(Main.class);
//	private static final String CONFIG_LOCATION = "beans.xml";
	public static void main(String[] args) {
		log.info("---- Guess The Number Game -----");
		SpringApplication.run(Main.class, args);
	}

}
