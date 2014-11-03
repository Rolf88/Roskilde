package app;

import app.domain.AppStates;
import business.GameService;
import domain.Account;
import game.GameResult;
import game.GameState;
import java.util.Observable;
import java.util.Observer;

public class AppState extends Observable implements Observer {

    private static AppState instance;

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }

        return instance;
    }

    private AppStates state;
    private final GameState gameState;
    private final GameService gameService = new GameService();
    private Account account;

    public AppState() {
        this.gameState = new GameState();
        this.gameState.addObserver(this);
    }

    public void setState(AppStates state) {
        setState(state, null);
    }

    public void setState(AppStates state, Object obj) {
        this.state = state;

        setChanged();
        notifyObservers(obj);
    }

    public AppStates getState() {
        return state;
    }

    @Override
    public void update(Observable o, Object obj) {
        GameResult gameResult = (GameResult) obj;

        gameService.addHighscore(getAccount(), gameResult.getScore());
        
        setState(AppStates.LOST, obj);
    }

    public GameState getGameState() {
        return gameState;
    }

    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
}
