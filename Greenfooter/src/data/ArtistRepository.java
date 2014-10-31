package data;

import domain.Artist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class ArtistRepository {

    private final String ArtistFileName = "Artists.csv";

    public List<Artist> findAll() {
        try {
            ArrayList<String> strPersons = new ArrayList();

            try (Scanner scanner = new Scanner(new File(ArtistFileName))) {
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

    private Artist deserialize(String str) {
        String[] strArr = str.split(",");
        
        UUID artistId = UUID.fromString(strArr[0].trim());
        String name = strArr[1].trim();
        
        return new Artist(artistId, name);
    }
}
