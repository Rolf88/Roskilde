package game;

import business.GameService;
import java.util.Observable;

public class GameState extends Observable {
    
    public void finishGame(GameResult gameResult) {        
        setChanged();
        notifyObservers(gameResult);
    }
}
