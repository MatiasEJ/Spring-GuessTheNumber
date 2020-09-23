package academy.learnprogramming;

import academy.learnprogramming.config.MaxNumber;
import academy.learnprogramming.config.MinNumber;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;

@Getter
@Component
public class NumberGeneratorImp implements NumberGenerator{
    // Fields
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    public NumberGeneratorImp(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }

}
