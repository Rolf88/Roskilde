
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rolf
 */
public class Question extends Actor {

    public Question(String question) {
        setImage(new GreenfootImage(question, 20, Color.BLACK, null));
    }
}
