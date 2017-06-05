import greenfoot.*;

/**
 * OpponentRacer is a subclass of Racer. It includes an integrated AI,
 * allowing it to make logical and complex decisions.
 * 
 * @author Micah Hansonbrook & Zachary Siegel
 * @version 0.4
 */
public class OpponentRacer extends Racer{
    AIActionPossibilities reccommendedAction = AIActionPossibilities.IDLE;
    AIActionPossibilities currentAction = AIActionPossibilities.IDLE;
    int roundsToNextAction = 0;
    private double minimumSpeed = 1.2;
    /**
     * constructer - Create an image for the AI racer so that the 
     * player can actually see it (games are better that way).
     */
    public OpponentRacer(String image){
        this.setImage(image);
    }
    /**
     * act - Simulate physics and allow the AI to make decisions.
     */
    public void act() {
        System.out.println("Acting!");
        super.act();
        roundsToNextAction -= 1;
        if (roundsToNextAction <= 0){
            think();
        }
        if (roundsToNextAction == 1){
            actUponDecision();
        }
    }
    /**
     * think - Allow the AI to make decisions about what it should do
     * next.
     */
    public void think() {
        System.out.println("Thinking");
        if (reccommendedAction != AIActionPossibilities.IDLE && 
        Greenfoot.getRandomNumber(10) != 9){
            currentAction = reccommendedAction;
        }else{
            currentAction = getRandomAction();
        }
    }
    /**
     * getRandomAction - Get a random action that the AI can perform.
     */
    public AIActionPossibilities getRandomAction(){
        AIActionPossibilities chosenAction = AIActionPossibilities.IDLE;
        int randomValue = Greenfoot.getRandomNumber(4);
        System.out.println(randomValue);
        switch (randomValue){
            case 1: chosenAction = AIActionPossibilities.IDLE;
            roundsToNextAction = 2; break;
            case 2: chosenAction = 
            AIActionPossibilities.ROTATIONAL_SWITCH;
            roundsToNextAction = 5; break;
            case 3: chosenAction = AIActionPossibilities.MOVE;
            roundsToNextAction = 5; break;
            default: chosenAction = AIActionPossibilities.ROTATIONAL_SWITCH; 
            break;
        }
        return chosenAction;
    }
    /**
     * think - Allow the AI to execute the decisions that it has already
     * made and to reccomend new actions for itself based off the actions
     * that it takes.
     */
    public void actUponDecision() {
        System.out.println("Acting upon Decision!");
        switch (currentAction){
            case IDLE: break;
            case ROTATIONAL_SWITCH: switchRotation(); break;
            case MOVE: move(); break;
        }
    }
    /**
     * move - Bring the rotation of the OpponentRacer closer to the
     * rotation of the trackComponent that is on by altering the
     * deltaRotation of the OpponentRacer.
     */
    public void move() {
        System.out.println("Moving");
        deltaSpeed += 0.75;
    }
    /**
     * switchRotation - Increase the velocity of the AI racer so that
     * it moves forward more quickly.
     */
    public void switchRotation() {
        System.out.println("Turning");
        if (isTouching(TrackComponent.class)){
            final Actor REFERENCE = 
            getOneIntersectingObject(TrackComponent.class);
            System.out.println("Is Turning");
            if (REFERENCE.getRotation() > this.getRotation()&& 
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
                deltaRotation += 0.375 - deltaSpeed/20;
            }
            if (REFERENCE.getRotation() < this.getRotation()&&
        (deltaSpeed > minimumSpeed || deltaSpeed < -1 * minimumSpeed)){
                deltaRotation -= 0.375 - deltaSpeed/20;
            }
        }
    }
}
/**
* AIActionPossibilities - The decisions that the AI can possibly make.
*/
enum AIActionPossibilities{
    IDLE, ROTATIONAL_SWITCH, MOVE
}
