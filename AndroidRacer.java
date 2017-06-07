import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * AndroidRacer is the second player in this game.
 * 
 * @author Micah Hansonbrook & Zachary Siegel
 * @version 1.0
 */
public class AndroidRacer extends Racer
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
     * AndroidRacer object.
     */
    public void movement(){
        if(Greenfoot.isKeyDown("W")){
            deltaSpeed += 0.75;
        }
        if(Greenfoot.isKeyDown("S")){
            deltaSpeed -= 0.75;
        }
        if((Greenfoot.isKeyDown("D"))&& 
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation -= (0.375 - deltaSpeed/20)/2;
        }
        if((Greenfoot.isKeyDown("A"))&&
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
            deltaRotation += (0.375 - deltaSpeed/20)/2;
        }
    }
}
