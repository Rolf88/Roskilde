import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollWorld extends ScoreCounter
{
    private static final GreenfootImage bgImage = new GreenfootImage("Background2.png");
    private static final int scrollSpeed = -3;

    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;
    
    private Adder _obstacleAdder;
    private Adder _beerAdder;
    private Adder _foodAdder;
    private Adder _condomsAdder;
    private Adder _thiefAdder;
    private Adder _drugsAdder;
    private Timer _timer;
    
    private Score _score;
    private LifeScore _life;
    private Character _player = new Character();
    private Beer _beer = new Beer();

    /**
     * Constructor for objects of class Background1.
     * 
     */
    public ScrollWorld()
    {    
        _timer = new Timer();
        _beerAdder = new Adder(_timer, 2100);
        _foodAdder = new Adder(_timer, 1000);
        _condomsAdder = new Adder(_timer, 3000);
        _thiefAdder = new Adder(_timer, 1800);
        _drugsAdder = new Adder(_timer, 3500);
        _obstacleAdder = new Adder(_timer, 5000);
        

        GreenfootImage background = new GreenfootImage(320, 568);
        scrollingImage = getScrollingImage(320, 568);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);
        initializeScore();
        initializeLifeScore();
        
        addObject(_player, 160, 480);
        
        
    }

    public void act()
    {
        _timer.tick();
        
        if(scrollSpeed > 0 && scrollPosition <= 0) {
            scrollPosition = getHeight();
        }
        if(scrollSpeed < 0 && scrollPosition >= getHeight()) {
            scrollPosition = 0;
        }
        scrollPosition -= scrollSpeed;
        paint(scrollPosition);
        
    
        _score.setScore(getEatenBeer() + getEatenFood() + getEatenCondoms()
        - getEatenThief() - getEatenDrugs());
        
        _life.setLifeScore(_player.getLife());
        
        addBeer();
        addCondoms();
        addFood();
        addThief();
        addDrugs();
        addObstacle();
        
        
    }

    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, 0, position);
        bg.drawImage(scrollingImage, 0, position - scrollingImage.getHeight());
    }

    /**
     * Returns an image with the given dimensions.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
    
    public void addBeer(){
        if (_beerAdder.shouldAdd())  
        {  
           boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay);  
            // spawn  
            addObject(_beer, x, 0);
            
        }
     
    }
    
    public void addCondoms(){
        if (_condomsAdder.shouldAdd())  
        {  
            boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay);
            
            // spawn  
            addObject(new Condoms(), x, 0);  
        }
     
    }
    
    public void addFood(){
        if (_foodAdder.shouldAdd())  
        {  
            boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay);  
            // spawn
            addObject(new Food(), x, 0);  
        }
     
    }
    
    public void addThief(){
        if (_thiefAdder.shouldAdd())  
        {  
            boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay);
            // spawn
            addObject(new Thief(), x, 0);  
           
        }
     
    }
    
    public void addDrugs(){
        if (_drugsAdder.shouldAdd())  
        {  
            boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay); 
            addObject(new Drugs(), x, 0);  
        }
     
    }
    
    public void addObstacle(){
        if(_obstacleAdder.shouldAdd()){
            boolean isOkay = false;
            int x;
            do{                
                // random top edge location  
                x = Greenfoot.getRandomNumber(218) + 50;  
                
                isOkay = getObjectsAt(x, 0, Collectables.class).size() > 0;
            }while(isOkay);
            addObject(new Obstacle(), x, 0);
        }
    }
    
    public void initializeScore()
    {
        _score = new Score();
        addObject(_score, 40,  40);
    }
    
    public Score getScore() 
    {
        return _score;
    }
    
    public void initializeLifeScore()
    {
        _life = new LifeScore();
        addObject(_life, 280, 40);
    }
    
    public void die()
    {
        if(_player.getLife() < 1)
        {
         //insert code
        }
    }
}
