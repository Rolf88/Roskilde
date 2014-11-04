Opsætning
========
Installér Java 8 og sæt Netbeans op til at bruge Java 8

### Kode til at afslutte et spil
    AppState.getInstance().getGameState().finishGame(new GameResult(score));

### Kode til at udhente en Quiz
    Account account = AppState.getInstance().getAccount();

    GameService gameService = new GameService();

    Quiz quiz = gameService.getRandomQuizQuestion(account.getArtistId();
    /* kode til at konvertere til Greenfoot elementer */
