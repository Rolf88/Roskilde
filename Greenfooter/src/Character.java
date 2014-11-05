import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{   
    private int _life = 3;
    public static int j = 3;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+j, getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-j, getY());
        }
        
        Actor beer = getOneObjectAtOffset(0, 0, Beer.class);
        Actor food = getOneObjectAtOffset(0, 0, Food.class);
        Actor condoms = getOneObjectAtOffset(0, 0, Condoms.class);
        Actor thief = getOneObjectAtOffset(0, 0, Thief.class);
        Actor drugs = getOneObjectAtOffset(0, 0, Drugs.class);
        Actor obstacle = getOneObjectAtOffset(0, 0, Obstacle.class);
        
        if(beer !=null){
           
           ScoreCounter level = (ScoreCounter)getWorld();
           
           level.eatBeer((Beer)beer);
        }
        
        if(food !=null){
           
           ScoreCounter level = (ScoreCounter)getWorld();
           
           level.eatFood((Food)food);
        }
        
        if(condoms !=null){
           
           ScoreCounter level = (ScoreCounter)getWorld();
           
           level.eatCondoms((Condoms)condoms);
        }
        
        if(thief !=null){
           
           ScoreCounter level = (ScoreCounter)getWorld();
           
           level.eatThief((Thief)thief);
        }
        
        if(drugs !=null){
           
           ScoreCounter level = (ScoreCounter)getWorld();
           
           level.eatDrugs((Drugs)drugs);
        }
        
        if(obstacle != null)
        {   
            _life -= 1;
            
            getWorld().removeObject((Obstacle)obstacle);
        }
        
    }
    
    public int getLife()
    {
        return _life;
    }
    }   
 
