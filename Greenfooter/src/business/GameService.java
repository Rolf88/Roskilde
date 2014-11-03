package business;

import data.HighscoreRepository;
import data.QuizRepository;
import domain.Account;
import domain.HighscoreItem;
import domain.Quiz;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameService {

    private final Random random = new Random();
    private final HighscoreRepository highscoreRepository = new HighscoreRepository();
    private final QuizRepository quizRepository = new QuizRepository();

    public void addHighscore(Account account, int score) {
        if (account == null) {
            throw new NullPointerException("account");
        }

        if (score < 0) {
            throw new IndexOutOfBoundsException("score is required to be greater than or equal 0");
        }

        highscoreRepository.add(account.getId(), account.getName(), score);
    }

    public Quiz getRandomQuizQuestion(UUID artistId) {
        //This could be improved by having a method on quizRepository that filtered all the questions when fetching
        List<Quiz> questions = quizRepository.findAll().stream()
                .filter((quiz) -> quiz.getArtistId().equals(artistId))
                .collect(Collectors.toList());

        int randomNumber = random.nextInt(questions.size());

        return questions.get(randomNumber);
    }

    public List<HighscoreItem> getHighscores() {
        List<HighscoreItem> highscores = highscoreRepository.getHighscore();
        
        Collections.sort(highscores, new HighscoreSorter());
        
        return highscores;
    }
}
