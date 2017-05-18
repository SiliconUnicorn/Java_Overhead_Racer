/**
 * The Racer class will be able to move throughout the screen
 * 
 * @author Silicon Unicorn and Seagull Soars
 * @version 0.1
 */
public class Racer{
    PhysicsBody physicalBody;
    int maximumHealth=20000;
    int currentHealth;
    float deltaSpeed;
    int deltaRotation;
    public float getHealthPercentage(){
        return (float)currentHealth/(float)maximumHealth;
    }
    public void act(){
        movement();
    }
    public void movement(){
        move(deltaSpeed);
    }
}
public class linuxRacer extends Racer{
    public void movement(){
        move(deltaSpeed);
        
    }
}
