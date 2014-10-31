import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor 
{
    private int _score = 0;
    /**
     * Constructor for objects of class Score
     */
    public Score()
    {   
        setImage(new GreenfootImage(200, 45));
        //setScore(0);
    }
    
    public void setScore(int amount)
    {
        
        
        setImage(new GreenfootImage("Points: " + amount, 20, Color. WHITE, null));
        
    }
    
    public int getScore()
    {
        return _score;
    }
}
