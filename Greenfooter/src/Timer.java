/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer  
{
    private int _millisElapsed = 0;
    private long _lastTime = 0;
    
    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
    }
    
    public int getMillisElapsed(){
        return _millisElapsed;
    }
    
    public int getSeconds(){
            return ((_millisElapsed / 1000) % 60);
    }
    
    public int getMinutes(){
            return (_millisElapsed / 60000);
    }
    
    public int getMillis(){
        return _millisElapsed % 1000;
    }
    
    public String getTimeText(){
        String millisText = String.format("%03d", getMillis());
        String secsText = String.format("%02d", getSeconds());
        String minsText = "" + getMinutes();
        
        return minsText + ":" + secsText + "." + millisText;
    }
    
    public void tick(){
        long time = System.currentTimeMillis();
        
        if(_lastTime != 0){
            _millisElapsed += (time - _lastTime);
        }
        
        _lastTime = time;
    }
}

