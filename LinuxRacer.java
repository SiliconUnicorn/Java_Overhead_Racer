import greenfoot.*;

/**
 * LinuxRacer is the player's racer. It is a subclass of class Racer,
 * so it is able to simulate its own physics.
 * 
 * @author Micah Hansonbrook & Zachary Siegel 
 * @version 0.2
 */
public class LinuxRacer extends Racer
{
    private double minimumSpeed = 1.2;
    /**
     * act - Move around and simulate physics.
     */
    public void act() {
        movement();
        physics();
    }
    /**
     * movement - This method accepts keyboard input to drive the
     * LinuxPlayer object.
     */
    public void movement(){
        if(Greenfoot.isKeyDown("up")){
            deltaSpeed += 0.75;
        }
        if(Greenfoot.isKeyDown("down")){
            deltaSpeed -= 0.75;
        }
        if(Greenfoot.isKeyDown("right") && 
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation -= 0.375 - deltaSpeed/20;
        }
        if(Greenfoot.isKeyDown("left")  &&
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation += 0.375 - deltaSpeed/20;
        }
    }
}
