
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCounter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ScoreCounter extends World {

    private int _eatenBeer = 0;
    private int _eatenFood = 0;
    private int _eatenCondoms = 0;
    private int _eatenThief = 0;
    private int _eatenDrugs = 0;
    private int _eatenPoints = 0;

    /**
     * Constructor for objects of class ScoreCounter.
     *
     */
    public ScoreCounter() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(320, 568, 1);
    }

    public int getEatenBeer() {
        return _eatenBeer;
    }

    public int getEatenFood() {
        return _eatenFood;
    }

    public int getEatenCondoms() {
        return _eatenCondoms;
    }

    public int getEatenThief() {
        return _eatenThief;
    }

    public int getEatenDrugs() {
        return _eatenDrugs;
    }

    public int getEatenPoints() {
        return _eatenPoints;
    }

    public void eatBeer(Beer beer) {
        _eatenBeer += Beer.SCORE;

        removeObject(beer);
    }

    public void eatFood(Food food) {
        _eatenFood += Food.SCORE;

        removeObject(food);
    }

    public void eatCondoms(Condoms condoms) {
        _eatenCondoms += Condoms.SCORE;

        removeObject(condoms);
    }

    public void eatThief(Thief thief) {
        _eatenThief += Thief.SCORE;

        removeObject(thief);
    }

    public void eatDrugs(Drugs drugs) {
        _eatenDrugs += Drugs.SCORE;

        removeObject(drugs);
    }

    public void eatPoints(int points) {
        _eatenPoints += points;
    }
}
