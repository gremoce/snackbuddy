import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    Timer timer = new Timer();
    Coin coins = new Coin();
    
    public Screen(String type) {
        if(type.equals("level summary")) {
            levelSummary();
        }
        if(type.equals("instructions")) {
            infoScreen("instructions.png");
        }
        if(type.equals("credits")) {
            infoScreen("credits.png");
        }
        if(type.equals("levels")) {
            levelsScreen();
        }
    }
    
    private void levelsScreen() {        
        GreenfootImage background = new GreenfootImage(960, 720);
        background.setColor(new Color(0, 0, 0, 100));
        background.fillRect(0, 0, 960, 720);
        
        GreenfootImage screen = new GreenfootImage("levels_screen.png");
        int width = screen.getWidth();
        int height = screen.getHeight();
        
        int x = (960 - width) / 2;
        int y = (720 - height) / 2;        
        background.drawImage(screen, x, y);
        
        setImage(background);
    }
    
    private void infoScreen(String image) {
        GreenfootImage background = new GreenfootImage(960, 720);
        background.setColor(new Color(0, 0, 0, 100));
        background.fillRect(0, 0, 960, 720);
        
        GreenfootImage screen = new GreenfootImage(image);
        int width = screen.getWidth();
        int height = screen.getHeight();
        
        int x = (960 - width) / 2;
        int y = (720 - height) / 2;        
        background.drawImage(screen, x, y);
        
        setImage(background);
    }
    
    private void levelSummary() {
        String time = timer.getTime();
        int score = 0;
        int totalTime = timer.getTotalTime();
        int coinsCollected = coins.coinsCollected();
        
        if(totalTime <= 20) {
            score += 80;
        } else {
            int extra = totalTime - 20;
            score = Math.max(0, 80 - extra);
        }
        
        score += 20 - 5 * (4 - coinsCollected);
        
        GreenfootImage background = new GreenfootImage(960, 720);
        background.setColor(new Color(0, 0, 0, 100));
        background.fillRect(0, 0, 960, 720);
        
        GreenfootImage screen = new GreenfootImage("summary_screen.png");
        int width = screen.getWidth();
        int height = screen.getHeight();
        
        int x = (960 - width) / 2;
        int y = (720 - height) / 2;
        
        screen.setColor(new Color(67, 74, 95));
        screen.setFont(new Font("Consolas", true, false, 48));
        screen.drawString("PASS", 140, 64);
        
        screen.setFont(new Font("Consolas", true, false, 20));
        screen.drawString("Score: " + score, 140, 85);
        
        GreenfootImage timeIcon = new GreenfootImage("time.png");
        screen.drawImage(timeIcon, 48, 100);
        screen.setFont(new Font("Consolas", true, false, 24));
        screen.drawString("------------- " + time, 80, 120);
        
        GreenfootImage coinIcon = new GreenfootImage("coin_4.png");
        screen.drawImage(coinIcon, 48, 148);
        screen.drawString("------------- x" + coinsCollected, 80, 168);

        background.drawImage(screen, x, y);
        
        setImage(background);
        
        Greenfoot.playSound("win.wav");
    }
}
