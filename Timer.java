import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int acts = 0;
    private static int minutes = 0;
    private static int seconds = 0;
    private static String time;
    private static boolean start = true;
    
    GreenfootImage timer = new GreenfootImage(192, 48); 
    
    public Timer() {
        timer.setColor(new Color(67, 74, 95));
        timer.setFont(new Font("Consolas", true, false, 30));
        getImage().clear();
        timer.drawString("00:00", 72, 24);
        setImage(timer);
    }
    
    public void act()
    {
        if(start) {
            // Adding to timer every second
            acts++;
            if(acts % 60 == 0) {
                seconds++;
                if(minutes < 10 && seconds < 10) {
                    time = "0" + minutes + ":0" + seconds;
                    displayTime();
                } else if(minutes < 10 && seconds >= 10) {
                    time = "0" + minutes + ":" + seconds;
                    displayTime();
                } else if (minutes >= 10 && seconds < 10) {
                    time = minutes + ":0" + seconds;
                    displayTime();
                } else if (minutes >= 10 && seconds >= 10) {
                    time = minutes + ":" + seconds;
                    displayTime();
                }
                
            }
            
            if(seconds == 59) {
                minutes++;
                seconds = -1;
            }
        } 
    }
    
    private void displayTime() {
        getImage().clear();
        timer.drawString(time, 72, 24);                
        setImage(timer);
    }
    
    public void stop() {
        start = false;
    }
    
    public void start() {
        start = true;
    }
    
    public String getTime() {
        return time;
    }
    
    public void resetTimer() {
        minutes = 0;
        seconds = 0;
    }
    
    public int getTotalTime() {
        return minutes * 60 + seconds;
    }
}
