import domain.Quiz;
import domain.QuizAnswer;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class Svar1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Svar1 extends Actor
{
   public static int INCORRECTPOINTS = -5;
   public static int CORRECTPOINTS = 10;
   private String _quizspørgsmål;
   private List<QuizAnswer> _answers;
   
   public Svar1(Quiz quiz){
      
       _quizspørgsmål = quiz.getQuestion();
      _answers = quiz.getAnswers();
       
   }
   
   public void build(){        
       int y = 150;
       for(QuizAnswer answer : _answers){
           getWorld().addObject(new Answer(this, answer.getAnswer(),answer.isIsCorrect()), 50, y);
           
           y += 50;
        }
               getWorld().addObject(new Question(_quizspørgsmål),120,50);
               
    }
   
    public void onCorrect(){
        ScoreCounter scorecounter = (ScoreCounter)getWorld();
        scorecounter.eatPoints(CORRECTPOINTS);
        ScrollWorld scrollworld = (ScrollWorld)getWorld();
        scrollworld.setIsInQuizMode(false);
        ScrollWorld.scrollSpeed -= 1;
        Collectables.GAMESPEED -= 1;
    }
   
    public void onIncorrect(){
        ScoreCounter scorecounter = (ScoreCounter)getWorld();
        scorecounter.eatPoints(INCORRECTPOINTS);
        ScrollWorld scrollworld = (ScrollWorld)getWorld();
        scrollworld.setIsInQuizMode(false);
        ScrollWorld.scrollSpeed -= 1;
        Collectables.GAMESPEED -= 1;
    }
    
   public void act(){
   }
   
}
    

