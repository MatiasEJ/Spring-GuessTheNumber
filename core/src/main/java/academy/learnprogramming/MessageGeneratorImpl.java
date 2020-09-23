package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j
@Component
public class MessageGeneratorImpl implements  MessageGenerator{

	private final Game game;

	public MessageGeneratorImpl(Game game) {
		this.game = game;
	}

	@PostConstruct
	public void init(){
		log.info("In postContruct, game not null = {}",game.getRemainingGuesses());
	}

	@Override
	public String getMainMessage() {
		return "Number is between "+
				game.getSmallest()+" and "+
				game.getBiggest()+
				" can you guess it?.";
	}

	@Override
	public String getResultMessage() {
		if(game.isGameWon()){
			return "you guest it!, the number was "+game.getNumber() + "ammount of guesses "+game.getRemainingGuesses();
		}else if(game.isGameLost()){
			return "you lost the number was"+game.getNumber();
		}else if(!game.isValidNumberRange()){
			return "invalid number range";
		}else if (game.getRemainingGuesses() == game.getGuessCount()){
			return "what is your first guess?";
		}else{
			String direction = "lower";
			 if(game.getGuess() < game.getNumber()){
			 	direction = "higher";
			 }
			 return direction +" you have "+ game.getRemainingGuesses() + "guesses left";
		}

	}
}
