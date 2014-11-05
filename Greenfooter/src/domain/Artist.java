package domain;

import java.util.UUID;

public class Artist {
    private UUID id;
    private String name;
    private String soundFileName;

    public Artist(UUID id, String name, String soundFileName){
        this.id = id;
        this.name = name;
        this.soundFileName = soundFileName;
    }
    
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
 
    public String getSoundFileName(){
        return this.soundFileName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
