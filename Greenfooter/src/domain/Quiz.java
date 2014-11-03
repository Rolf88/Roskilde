package domain;

import java.util.List;
import java.util.UUID;

public class Quiz {

    private final UUID artistId;
    private final String question;
    private final List<QuizAnswer> answers;

    public Quiz(UUID artistId, String question, List<QuizAnswer> answers) {
        this.artistId = artistId;
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<QuizAnswer> getAnswers() {
        return answers;
    }

    public UUID getArtistId() {
        return artistId;
    }
}
