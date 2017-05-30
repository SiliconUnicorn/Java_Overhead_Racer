import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinuxRacer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinuxRacer extends Racer
{
    /**
     * Act - do whatever the LinuxRacer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }    
    public void movement(){
        if (Greenfoot.isKeyDown("up")){
            move(0);
        }
    }
}
