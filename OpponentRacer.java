import greenfoot.*;

/**
 * OpponentRacer is a subclass of Racer. It includes an integrated AI,
 * allowing it to make logical and complex decisions.
 * 
 * @author Micah Hansonbrook & Zachary Siegel
 * @version 0.3
 */
public class OpponentRacer extends Racer{
    AIActionPossibilities reccommendedAction = AIActionPossibilities.IDLE;
    AIActionPossibilities currentAction = AIActionPossibilities.IDLE;
    int roundsToNextAction = 0;
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
        super.act();
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
        if (reccommendedAction != AIActionPossibilities.IDLE && 
        Greenfoot.getRandomNumber(21) != 20){
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
        switch (Greenfoot.getRandomNumber(4)){
            case 1: chosenAction = AIActionPossibilities.IDLE;
            case 2: chosenAction = 
            AIActionPossibilities.ROTATIONAL_SWITCH;
            case 3: chosenAction = AIActionPossibilities.MOVE;
            default: chosenAction = AIActionPossibilities.IDLE;
        }
        return chosenAction;
    }
    /**
     * think - Allow the AI to execute the decisions that it has already
     * made and to reccomend new actions for itself based off the actions
     * that it takes.
     */
    public void actUponDecision() {
        switch (currentAction){
            case IDLE: break;
            case ROTATIONAL_SWITCH: break;
            case MOVE: move(); break;
        }
    }
    /**
     * move - Increase the velocity of the AI racer so that it moves
     * forward more quickly.
     */
    public void move() {
        deltaSpeed += 0.75;
    }
}
/**
* AIActionPossibilities - The decisions that the AI can possibly make.
*/
enum AIActionPossibilities{
    IDLE, ROTATIONAL_SWITCH, MOVE
}
