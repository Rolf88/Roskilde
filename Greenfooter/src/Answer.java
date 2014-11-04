import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Answer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends Actor
{
    private Svar1 _question;
    private boolean _isCorrect;
    
    public Answer(Svar1 question, String answer, boolean isCorrect){
        _question = question;
        _isCorrect = isCorrect;
        
        setImage(new GreenfootImage(answer, 20, Color. BLACK, null));
    }
    
    /**
     * Act - do whatever the Answer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if(_isCorrect)
                _question.onCorrect();
            else 
                _question.onIncorrect();
        }
    }    
}
