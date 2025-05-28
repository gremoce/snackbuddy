import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    private String[] costumes = {"snackbuddy.png", "snackbuddy_2.png", "snackbuddy_3.png", "snackbuddy_2.png"};
    private int costumeIndex = 0; 
    private int animationCount = 0;
    
    public void act()
    {
        animate();
    }
    
    private void animate() {
        animationCount++;
        if (animationCount % 20 == 0) {             
            costumeIndex = (costumeIndex + 1) % costumes.length; 
            setImage(costumes[costumeIndex]);
        }
    }
}
