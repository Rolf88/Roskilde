package data;

import domain.HighscoreItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class HighscoreRepository {

    private final String HighscoreFileName = "Highscores.csv";

    public void add(UUID accountId, String accountName, int score) {
        try {
            StringBuilder strBuilder = new StringBuilder();

            try (Scanner scanner = new Scanner(new File(HighscoreFileName))) {
                while (scanner.hasNextLine()) {
                    strBuilder.append(scanner.nextLine()).append("\n");
                }
            }

            try (FileWriter output = new FileWriter(new File(HighscoreFileName))) {
                if (strBuilder.length() > 0) {
                    output.write(strBuilder.toString());
                }

                output.write(serialize(accountId, accountName, score));
            }
        } catch (IOException ex) {
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
        }
    }
    
    
    public List<HighscoreItem> getHighscore() {
        try {
            ArrayList<String> strPersons = new ArrayList();

            try (Scanner scanner = new Scanner(new File(HighscoreFileName))) {
                while (scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();

                    strPersons.add(currentLine);
                }
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

    private String serialize(UUID accountId, String accountName, int score) {
        return accountId + "," + accountName + "," + score;
    }

    private HighscoreItem deserialize(String str) {
        String[] strArr = str.split(",");
        
        UUID accountId = UUID.fromString(strArr[0]);
        String accountName = strArr[1];
        int score = Integer.parseInt(strArr[2]);
        
        return new HighscoreItem(accountId, accountName, score);
    }
}
