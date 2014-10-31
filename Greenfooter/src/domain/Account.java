package domain;

import java.util.UUID;

public class Account {

    private final UUID id;
    private String name;
    private String ticketCode;
    private UUID artistId;

    public Account(UUID id, String name, String ticketCode, UUID artistId) {
        this.id = id;
        this.name = name;
        this.ticketCode = ticketCode;
        this.artistId = artistId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }
}
