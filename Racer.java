/**
 * The Racer class will be able to move throughout the screen
 * 
 * @author Silicon Unicorn
 * @version 0.1
 */
public class Racer{
    int maximumHealth=20000;
    int currentHealth;
    int deltaSpeed;
    int deltaRotation;
    public float getHealthPercentage(){
        return (float)currentHealth/(float)maximumHealth;
    }
}
