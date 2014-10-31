package data;

import domain.Account;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountRepository {

    private final String AccountFileName = "Accounts.csv";

    public List<Account> findAll() {
        try {
            ArrayList<String> strPersons = new ArrayList();

            try (Scanner scanner = new Scanner(new File(AccountFileName))) {
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

    public void add(Account account) {
        try {
            StringBuilder strBuilder = new StringBuilder();

            try (Scanner scanner = new Scanner(new File(AccountFileName))) {
                while (scanner.hasNextLine()) {
                    strBuilder.append(scanner.nextLine()).append("\n");
                }
            }

            try (FileWriter output = new FileWriter(new File(AccountFileName))) {
                if (strBuilder.length() > 0) {
                    output.write(strBuilder.toString());
                }

                output.write(serialize(account));
            }
        } catch (IOException ex) {
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
        }

    }

    private Account deserialize(String str) {
        String[] strArr = str.split(",");

        UUID id = UUID.fromString(strArr[0].trim());
        String name = strArr[1].trim();
        String ticketCode = strArr[2].trim();
        UUID artistId = UUID.fromString(strArr[3].trim());

        return new Account(id, name, ticketCode, artistId);
    }

    private String serialize(Account account) {
        return account.getId() + "," + account.getName() + ","
                + account.getTicketCode() + "," + account.getArtistId();
    }
}
