package business;

import data.ArtistRepository;
import domain.Artist;
import java.util.List;

public class ArtistService {

    private final ArtistRepository artistRepository = new ArtistRepository();

    public List<Artist> findAll() {
        return this.artistRepository.findAll();
    }
}
