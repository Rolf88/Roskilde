package data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TicketRepository {

    private final String TicketFileName = "tickets.csv";

    public boolean containsTicket(String ticketCode) {

        try {
            try (Scanner scanner = new Scanner(new File(TicketFileName))) {
                while (scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();

                    if (currentLine.contains(ticketCode)) {
                        return true;
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
        }

        return false;
    }
}
