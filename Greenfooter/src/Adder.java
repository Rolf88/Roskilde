/**
 * Write a description of class Adder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adder  
{
    private Timer _timer;
    private int _addEvery;
    private int _lastTime = 0;
    
    /**
     * Constructor for objects of class Adder
     */
    public Adder(Timer timer, int addEvery)
    {
        _timer = timer;
        _addEvery = addEvery;
    }
    
    public boolean shouldAdd()
    {
        int interval = _timer.getMillisElapsed() - _lastTime;
        
        if(interval >= _addEvery)
        {
            _lastTime = _timer.getMillisElapsed();
            return true;
        }
        
        return false;
    }
}
