import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    private static int level;
    private boolean summaryDisplayed = false;
    
    Button restart = new Button("restart.png", "restart_2.png");
    Button home = new Button("home.png", "home_2.png");
    Button next = new Button("next.png", "next_2.png");
    Timer timer = new Timer();
    
    
    public Door(int level) {
        this.level = level;
    }
    
    public void act()
    {
        checkReached();
        if (Greenfoot.mouseClicked(restart)){
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld (new GameWorld(level));
        }
        if (Greenfoot.mouseClicked(home)){
            Greenfoot.playSound("click.wav");
            Greenfoot.setWorld (new StartWorld());
        }
        if (Greenfoot.mouseClicked(next)){
            if(level < 3) {
                level++;
                Greenfoot.playSound("click.wav");
                Greenfoot.setWorld (new GameWorld(level));
            } else {
                Greenfoot.playSound("click.wav");
                Greenfoot.setWorld (new StartWorld());

            }
        }
    }
    
    private void checkReached() {
        if(!summaryDisplayed && isTouching(Player.class)) {
            Player player = (Player) getWorld().getObjects(Player.class).get(0);
            player.setLocation(getX(), getY());
            player.stopMoving();
            
            displaySummary();
            summaryDisplayed = true;
            timer.stop();
        }
    }
    
    private void displaySummary() {
        World world = getWorld();
        Screen summary = new Screen("level summary");
        
        world.addObject(summary, world.getWidth() / 2, world.getHeight() / 2);
        world.addObject(restart, world.getWidth() / 2 - 72, world.getHeight() / 2 + 72);
        world.addObject(home, world.getWidth() / 2, world.getHeight() / 2 + 72);
        world.addObject(next, world.getWidth() / 2 + 72, world.getHeight() / 2 + 72);
    }
}
