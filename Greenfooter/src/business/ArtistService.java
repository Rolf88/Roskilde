package business;

import data.ArtistRepository;
import domain.Artist;
import java.util.List;
import java.util.UUID;

public class ArtistService {

    private final ArtistRepository artistRepository = new ArtistRepository();

    public List<Artist> findAll() {
        return this.artistRepository.findAll();
    }
    
    public Artist getById(UUID artistId){
        return this.artistRepository.getById(artistId);
    }
}
