import greenfoot.*;
/**
 * The Racer class is the superclass for all of the racers. It implements
 * simple physics, rotation, and movement.
 * 
 * @author Micah Hansonbrook & Zachary Siegel
 * @version 0.2
 */
public class Racer extends Actor
{
    double deltaRotation = 0.0;
    double deltaSpeed = 0.0;
    double health = 30.0;
    boolean harmIfNotTouching = false;
    boolean finished = false;
    /**
     * act - This method should be overriden by all subclasses. In
     * this class it will only simulate physics.
     */
    public void act() {
        physics();
    }    
    /**
     * physics - This method will simulate physics by allowing this
     * object to continue to move while friction is applied to it.
     */
    public void physics(){
        frictionalSlow(1);
        moveAsExpected();
    }
    /**
     * moveAsExpected - This method will move this object by the
     * expected amount (on the x axis, y axis, and rotationally).
     */
    public void moveAsExpected(){
        move((int) deltaSpeed/2);
        setRotation(getRotation() + (int)deltaRotation);
    }
    /**
     * frictionalSlow - This method slows down this object slightly
     * each time that it is called.
     */
    public void frictionalSlow(double resistance){
        deltaSpeed -= deltaSpeed/20 * resistance;
        if (deltaRotation > 0){
            deltaRotation -= deltaRotation/20 * resistance;
        }
        if (deltaRotation < 0){
            deltaRotation -= deltaRotation/20 * resistance;
        }
    }
    /**
     * moveTo - A utility method for moving the Racer to a
     * TrackComponent instantly.
     */
    public void moveTo(TrackComponent trackSection){
        setLocation(trackSection.getX(), trackSection.getY());
        setRotation(trackSection.getRotation());
    }
}
