package academy.learnprogramming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig {
	// == fields ==

	@Value("${game.maxNumber:100}")
	private int maxNumber;
	@Value("${game.guessCount:5}")
	private int guessCount;
	@Value("${game.minNumber:99}")
	private int minNumber;


	// == beans ==
	@Bean
	@MaxNumber
	public int maxNumber() {
		return maxNumber;
	}

	@Bean
	@GuessCount
	public int guessCount() {
		return guessCount;
	}

	@Bean
	@MinNumber
	public int minNumber() {
		return minNumber;
	}

}
