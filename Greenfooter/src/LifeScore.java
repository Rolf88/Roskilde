import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class LifeScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeScore extends Actor
{
    
    public LifeScore()
    {
        setImage(new GreenfootImage(280, 40));
    }
    
    public void setLifeScore(int amount)
    {
        setImage(new GreenfootImage("Lifes: " + amount, 20, Color. WHITE, null));
    }
    
}
