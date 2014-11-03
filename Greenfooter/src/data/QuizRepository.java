package data;

import domain.Quiz;
import domain.QuizAnswer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class QuizRepository {

    private final String QuizFileName = "Quiz.csv";

    public List<Quiz> findAll() {
        try {
            ArrayList<String> strPersons = new ArrayList();

            try (Scanner scanner = new Scanner(new File(QuizFileName))) {
                StringBuilder strBuilder = new StringBuilder();

                while (scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();

                    if (currentLine.equals("")) {
                        strPersons.add(strBuilder.toString());

                        strBuilder = new StringBuilder();
                    } else {
                        strBuilder.append(currentLine).append("\n");
                    }
                }

                strPersons.add(strBuilder.toString());
            }

            return strPersons.stream()
                    .map(str -> deserialize(str))
                    .collect(Collectors.toList());

        } catch (IOException ex) {
            System.out.println("Could not load file!");
            System.out.println(ex.toString());
        }

        return new ArrayList<>();
    }

    public List<Quiz> findByArtistId(UUID artistId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Quiz deserialize(String str) {
        String[] strArr = str.split("\n");

        UUID artistId = UUID.fromString(strArr[0]);
        String question = strArr[1];

        List<QuizAnswer> answers = new ArrayList<>();

        for (int i = 2; i < strArr.length; i++) {
            String strAnswer = strArr[i].trim();
            boolean isCorrect = strAnswer.substring(0, 1).equals("+");
            String answer = strAnswer.substring(2);

            answers.add(new QuizAnswer(answer, isCorrect));
        }

        return new Quiz(artistId, question, answers);
    }

}
