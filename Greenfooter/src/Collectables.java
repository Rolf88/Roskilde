
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectables here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Collectables extends Actor {

    int GAMESPEED = -3;

    protected void moveScene() {
        int y = getY() - GAMESPEED;

        if (y >= getWorld().getHeight()) {
            getWorld().removeObject(this);
        } else {
            setLocation(getX(), y);
        }
    }
}
