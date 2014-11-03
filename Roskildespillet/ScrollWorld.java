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

    /**
     * Constructor for objects of class Background1.
     * 
     */
    public ScrollWorld()
    {    
        _timer = new Timer();
        _beerAdder = new Adder(_timer, 2000);
        _foodAdder = new Adder(_timer, 1000);
        _condomsAdder = new Adder(_timer, 3000);
        _thiefAdder = new Adder(_timer, 2000);
        _drugsAdder = new Adder(_timer, 3500);
        _obstacleAdder = new Adder(_timer, 5000);
        

        GreenfootImage background = new GreenfootImage(320, 568);
        scrollingImage = getScrollingImage(320, 568);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);
        initializeScore();
        
        addObject(new Character(), 160, 480);
        
        
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
            // random top edge location  
            int x = Greenfoot.getRandomNumber(218) + 50;  
            // spawn  
            addObject(new Beer(), x, 0);  
        }
     
    }
    
    public void addCondoms(){
        if (_condomsAdder.shouldAdd())  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(218) + 50;  
            // spawn  
            addObject(new Condoms(), x, 0);  
        }
     
    }
    
    public void addFood(){
        if (_foodAdder.shouldAdd())  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(218) + 50;  
            // spawn  
            addObject(new Food(), x, 0);  
        }
     
    }
    
    public void addThief(){
        if (_thiefAdder.shouldAdd())  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(218) + 50;  
            // spawn  
            addObject(new Thief(), x, 0);  
        }
     
    }
    
    public void addDrugs(){
        if (_drugsAdder.shouldAdd())  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(218) + 50;  
            // spawn  
            addObject(new Drugs(), x, 0);  
        }
     
    }
    
    public void addObstacle(){
        if(_obstacleAdder.shouldAdd()){
            //random top edge location
            int x = Greenfoot.getRandomNumber(218) + 50;
            //spawn
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
}
