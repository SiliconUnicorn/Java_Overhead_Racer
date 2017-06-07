import greenfoot.*;

/**
 * LinuxRacer is the player's racer. It is a subclass of class Racer,
 * so it is able to simulate its own physics.
 * 
 * @author Micah Hansonbrook & Zachary Siegel 
 * @version 1.0
 */
public class LinuxRacer extends Racer
{
    private double minimumSpeed = 1.2;
    /**
     * act - Move around, simulate physics, record if it isn't
     * touching the track, and records when it reaches the finish line.
     */
    public void act() {
        super.act();
        movement();
        if(isTouching(Finishline.class)){
            finished = true;
        }
        if(isTouching(TrackComponent.class) != true){
            returnToStart = true;
        }
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
        if((Greenfoot.isKeyDown("right"))&& 
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation -= (0.375 - deltaSpeed/20)/2;
        }
        if((Greenfoot.isKeyDown("left"))&&
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation += (0.375 - deltaSpeed/20)/2;
        }
    }
}
