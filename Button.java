import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    String image;
    String imageHovered;
    
    public Button(String image, String imageHovered) {
        this.image = image;
        this.imageHovered = imageHovered;
        
        setImage(image);
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
            setImage(imageHovered);
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            setImage(image);
    }
}
