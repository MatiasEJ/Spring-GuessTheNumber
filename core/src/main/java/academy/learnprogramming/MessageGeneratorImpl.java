package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
	private static final String MAIN_MESSAGE   = "game.main.message";
	private static final String GAME_WON       = "game.won";
	private static final String GAME_LOST      = "game.lost";
	private static final String INVALID        = "game.invalid";
	private static final String GAME_GUESS     = "game.guess";
	private static final String GAME_REMAINING = "game.remaining";
	private static final String GAME_LOWER     = "game.lower";
	private static final String GAME_HIGHER    = "game.higher";

	private final Game          game;
	private final MessageSource messageSource;


	public MessageGeneratorImpl(Game game, MessageSource messageSource) {
		this.game = game;
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void init() {
		log.info("In postContruct, game not null = {}", game.getRemainingGuesses());
	}

	@Override
	public String getMainMessage() {
		return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
	}

	@Override
	public String getResultMessage() {
		if (game.isGameWon()) {
			return getMessage(GAME_WON, game.getNumber(), game.getRemainingGuesses());
		} else if (game.isGameLost()) {
			return getMessage(GAME_LOST, game.getNumber());
		} else if (!game.isValidNumberRange()) {
			return getMessage(INVALID);
		} else if (game.getRemainingGuesses()==game.getGuessCount()) {
			return getMessage(GAME_GUESS);
		} else {
			String direction = getMessage(GAME_LOWER);
			if (game.getGuess() < game.getNumber()) {
				direction = getMessage(GAME_HIGHER);
			}
			return direction + getMessage(GAME_REMAINING, game.getRemainingGuesses());
		}

	}

	private String getMessage(String code, Object... args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}


}
