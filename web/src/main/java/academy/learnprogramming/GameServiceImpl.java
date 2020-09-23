package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
	private final Game             game;
	private final MessageGenerator messageGenerator;

	public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
		this.game = game;
		this.messageGenerator = messageGenerator;
	}

	@PostConstruct
	public void init(){
		log.debug("Main message = {} ", messageGenerator.getMainMessage());
		log.debug("The number is = {} ", game.getNumber());
	}

	@Override
	public boolean isGameOver() {
		return game.isGameLost() || game.isGameWon();
	}

	@Override
	public String getMainMessage() {
		return messageGenerator.getMainMessage();
	}

	@Override
	public String getResultMessage() {
		return messageGenerator.getResultMessage();
	}

	@Override
	public void checkGuess(int guess) {
		game.setGuess(guess);
		game.check();
	}

	@Override
	public void reset() {
		game.reset();
	}
}
