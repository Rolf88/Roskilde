import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollWorld extends World
{
    private static final GreenfootImage bgImage = new GreenfootImage("Background1.png");
    private static final int scrollSpeed = -3;

    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;

    /**
     * Constructor for objects of class Background1.
     * 
     */
    public ScrollWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 960, 1); 

        GreenfootImage background = new GreenfootImage(640, 960);
        scrollingImage = getScrollingImage(640, 960);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);

        
        addObject(new Character(), 320, 480);
        
        
    }

    public void act()
    {
        if(scrollSpeed > 0 && scrollPosition <= 0) {
            scrollPosition = getHeight();
        }
        if(scrollSpeed < 0 && scrollPosition >= getHeight()) {
            scrollPosition = 0;
        }
        scrollPosition -= scrollSpeed;
        paint(scrollPosition);
        
        addBeer();
        addCondoms();
        addFood();
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
        if (Greenfoot.getRandomNumber(100) == 1)  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(getWidth());  
            // spawn  
            addObject(new Beer(), x, 0);  
        }
     
    }
    
    public void addCondoms(){
        if (Greenfoot.getRandomNumber(100) == 1)  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(getWidth());  
            // spawn  
            addObject(new Condoms(), x, 0);  
        }
     
    }
    
    public void addFood(){
        if (Greenfoot.getRandomNumber(100) == 1)  
        {  
            // random top edge location  
            int x = Greenfoot.getRandomNumber(getWidth());  
            // spawn  
            addObject(new Food(), x, 0);  
        }
     
    }
}
