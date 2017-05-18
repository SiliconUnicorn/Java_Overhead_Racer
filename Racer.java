/**
 * The Racer class will be able to move throughout the screen
 * 
 * @author Silicon Unicorn and Seagull Soars
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
    public class linuxRacer extends Racer{
       int currentSpeed=0;
       int turningVariant=1;
       if (isKeyDown("up")==true){
       move(currentSpeed)
       currentSpeed=currentSpeed+1;
       if (currentSpeed=10*turningVariant)
       {
           deltaRotation=deltaRotation-1;
           turningVariant=turningVariant+1;
       }
           }
    }
}
