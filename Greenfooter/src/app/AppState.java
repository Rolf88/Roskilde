package app;

import java.util.Observable;

public class AppState extends Observable {
    
    private static AppState instance;

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }

        return instance;
    }

    private AppStates state;

    public void setState(AppStates state) {
        this.state = state;
        
        setChanged();
        notifyObservers();
    }

    public AppStates getState() {
        return state;
    }
}
