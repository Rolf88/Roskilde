package domain;

import java.util.UUID;

public class HighscoreItem {

    private final UUID accountId;
    private final String accountName;
    private final int score;

    public HighscoreItem(UUID accountId, String accountName, int score) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.score = score;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getScore() {
        return this.score;
    }

}
