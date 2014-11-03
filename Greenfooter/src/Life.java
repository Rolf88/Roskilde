import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Life
     */
    public Life()
    {
        setImage(new GreenfootImage(200, 45));
    }
    
    public void setLife(int amount){
        
        setImage(new GreenfootImage("Life: " + amount, 20, Color. WHITE, null));
    }

}
