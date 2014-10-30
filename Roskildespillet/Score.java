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
        setScore(0);
    }
    
    public void setScore(int amount)
    {
        ScoreCounter level = (ScoreCounter)getWorld();
    
        _score = (level.getEatenBeer() + level.getEatenFood() + level.getEatenCondoms()
        - level.getEatenThief() - level.getEatenDrugs());
        
        
        GreenfootImage newImage = getImage();
        newImage.clear();
        //newImage.setColor(new Color(127, 127, 127, 127));
        //newImage.fill();
        newImage.setColor(Color.white);
        newImage.setFont(new Font("Helvetica", Font.BOLD, 30));
        newImage.drawString("Score: " + _score, 10, 30);
        setImage(newImage);
        
    }
    
    public int getScore()
    {
        return _score;
    }
}
