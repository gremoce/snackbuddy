import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends SuperSmoothMover
{
    private boolean isMoving = false;
    private int startX;
    private int endX;
    private double speed;
    
    
    public Platform(String costumeName) {
        isMoving = false;
        setImage(costumeName); 
    }
    
    public Platform(String costumeName, int startX, int endX, double speed) {
        this.startX = startX;
        this.endX = endX;
        this.speed = speed;
        
        isMoving = true;
        setImage(costumeName);
        
    }
    
    public boolean isMoving() {
        return isMoving;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void act() {
        if(isMoving) {
            move(speed);
            
            if(getX() <= endX || getX() >= startX) {
                speed = -speed;
            }             
        }
    }
}
