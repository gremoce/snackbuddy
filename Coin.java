import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private String[] costumes = {"coin_1.png", "coin_2.png", "coin_3.png", "coin_4.png", "coin_5.png", "coin_6.png",};
    private int costumeIndex = 0; 
    private int animationCount = 0;
    
    private static int coinsCollected = 0;
    
    public void act()
    {
        animate();
        checkCollected();
    }
    
    private void animate() {
        animationCount++;
        if (animationCount % 5 == 0) {             
            costumeIndex = (costumeIndex + 1) % costumes.length; 
            setImage(costumes[costumeIndex]);
        }
    }
    
    private void checkCollected() {
        if(isTouching(Player.class)) {
            coinsCollected++;
            getWorld().removeObject(this);
            Greenfoot.playSound("collect.mp3");
        }
    }
    
    public int coinsCollected() {
        return coinsCollected;
    }
    
    public static void resetCoins() {
        coinsCollected = 0;
    }
}
