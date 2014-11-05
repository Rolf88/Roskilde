
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import java.awt.Color;
import java.awt.Font;

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
        GreenfootImage image = new GreenfootImage(320, 50);
        image.setFont(new java.awt.Font("Helvetica", Font.BOLD, 16));
        image.drawString(question, 10, 25);
        setImage(image);
    }
}
