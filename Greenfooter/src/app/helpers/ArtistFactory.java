package app.helpers;

import domain.Artist;

public class ArtistFactory {

    public static Object buildComboxItem(Artist artist) {
        return new ComboItem(artist.getName(), artist.getId().toString());
    }

}
