import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Delay without pausing the whole game
 */
public class Delay extends Actor
{
    private static int timer = 0;
    private static boolean isDelaying = false;

    public static boolean delay(int frames)
    {
        if (!isDelaying) {
            isDelaying = true;
            timer = 0;
        }
        timer++;
        if (timer >= frames) {
            isDelaying = false;
            return true; 
        }
        return false; 
    }
}
