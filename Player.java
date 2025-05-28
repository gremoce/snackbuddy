import greenfoot.*; 

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SuperSmoothMover
{
    private int startX;
    private int startY;
    
    private double vY = 0; 
    private double vX = 0;
    private double gravity = 0.9; 
    private double jumpStrength = -15; 
    private double speed = 4.5;
    
    private boolean moving = true;
    
    private boolean facingRight = true;
    String key;    
    
    private String[] rightCostumes = {"right_1.png", "right_2.png"};
    private String[] leftCostumes = {"left_1.png", "left_2.png"};
    private String[] idleRightCostumes = {"idle_right_1.png", "idle_right_2.png", "idle_right_3.png", "idle_right_4.png"};
    private String[] idleLeftCostumes = {"idle_left_1.png", "idle_left_2.png", "idle_left_3.png", "idle_left_4.png"};
    private int costumeIndex = 0; 
    private int animationCount = 0;
    
    private int halfWidth = getImage().getWidth() / 2;
    private int halfHeight = getImage().getHeight() / 2;
    
    public void act()
    {
        if(moving) {
            checkKeys();
        } else {
            animate();
        }
        checkFall();
        checkTouchingEdge();
    }
    
    public Player(int x, int y) {
        startX = x;
        startY = y;
        
        moving = true;
        getImage().setTransparency(255);
    }
    
    // Move player using arrow keys
    private void checkKeys() {
        if (Greenfoot.isKeyDown("left")) {
            facingRight = false;
            key = "left";
            move(-speed);
            vX = -speed;
            animate();
        } 
        if (Greenfoot.isKeyDown("right")) {
            facingRight = true;
            key = "right";
            move(speed);
            vX = speed;
            animate();
        } 
        if (Greenfoot.isKeyDown("up") && onGround()) {
            vY = jumpStrength; 
            fall();       
            Greenfoot.playSound("jump.wav");
        } 
        else {
            key = "idle";
            animate();
        }
             
    }
    
    // Check if player is touching ground
    private void checkFall() {
        if (!onGround()) {
            fall();
        }
        if (onGround()) {
            vY = 0;
        }
    }
    
    private void fall() {
        setLocation(getX(), getY() + vY);
        vY += gravity;
        
        // Return to starting position if touching the bottom of the screen
        if (getY() + halfHeight >= getWorld().getHeight()) {
            for(int i = 255; i >= 0; i -= 51) {
                getImage().setTransparency(i);                
            }
            
            if(Delay.delay(30)) {
                facingRight = true;
                setLocation(startX, startY);
            }
        }
    }
    
    // Check if on a platform
    private boolean onGround() {
        Platform platformRight = (Platform) getOneObjectAtOffset(-12, halfWidth, Platform.class);
        Platform platformLeft = (Platform) getOneObjectAtOffset(12, halfWidth, Platform.class);
        
        // If platform exists, stop
        if (platformRight != null) {
            int platformTop = platformRight.getY() - platformRight.getImage().getHeight() / 2;
            
            if(platformRight.isMoving()) {
                setLocation(getX() + platformRight.getX() - getX(), platformTop - halfHeight);
            } else {
                setLocation(getX(), platformTop - halfHeight);
            }
            
            return true;
        } else if (platformLeft != null) {
            int platformTop = platformLeft.getY() - platformLeft.getImage().getHeight() / 2;
            
            if(platformLeft.isMoving()) {
                setLocation(getX() + platformLeft.getX() - getX(), platformTop - halfHeight);
            } else {
                setLocation(getX(), platformTop - halfHeight);
            }
            
            return true;
        }
        return false;
    }
    
    private void checkTouchingEdge() {
        Platform platform = (Platform) getOneIntersectingObject(Platform.class);
    
        if (platform != null) {
            int playerTop = getY() - halfHeight;
            int playerBottom = getY() + halfHeight;
            int playerLeft = getX() - halfWidth;
            int playerRight = getX() + halfWidth;
    
            int platformBottom = platform.getY() + platform.getImage().getHeight() / 2;
            int platformLeft = platform.getX() - platform.getImage().getWidth() / 2;
            int platformRight = platform.getX() + platform.getImage().getWidth() / 2;
            
            // Check if touching bottom of platform
            if (playerTop <= platformBottom && playerBottom >= platformBottom && vY < 0) {
                setLocation(getX(), platformBottom + halfHeight);
                vY = 0;
            }
            // Check if touching left of platform
            else if (playerRight >= platformLeft && playerLeft <= platformLeft && vX > 0) {
                setLocation(platformLeft - halfWidth, getY());
                vX = 0;
            }
            // Check if touching right of platform
            else if (playerLeft <= platformRight && playerRight >= platformRight && vX < 0) {
                setLocation(platformRight + halfWidth, getY());
                vX = 0;
            }
        }
    }
    
    public void stopMoving() {
        moving = false;
    }
    
    // Animate player
    private void animate() {
        animationCount++;
        
        if(key.equals("right")) {
            if (animationCount % 15 == 0) {             
            costumeIndex = (costumeIndex + 1) % rightCostumes.length; 
            setImage(rightCostumes[costumeIndex]);
            }
        } else if (key.equals("left")) {
            if (animationCount % 15 == 0) { 
            costumeIndex = (costumeIndex + 1) % leftCostumes.length; 
            setImage(leftCostumes[costumeIndex]);
            }
        } else if (key.equals("idle")) {
            if (animationCount % 15 == 0) { 
                if(facingRight) {
                    costumeIndex = (costumeIndex + 1) % idleRightCostumes.length; 
                    setImage(idleRightCostumes[costumeIndex]);
                } else {
                    costumeIndex = (costumeIndex + 1) % idleLeftCostumes.length; 
                    setImage(idleLeftCostumes[costumeIndex]);
                }
            }
        }
    }
    
}
