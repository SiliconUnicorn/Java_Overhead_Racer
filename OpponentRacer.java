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
     * act - Simulate physics and allow the AI to make decisions.
     */
    public void act() {
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
            
        }
    }
    /**
     * setNextActionRandomly - Set the AI's next action randomly.
     */
    public void setNextActionRandomly(){
        
    }
    /**
     * think - Allow the AI to execute the decisions that it has already
     * made and to reccomend new actions for itself based off the actions
     * that it takes.
     */
    public void actUponDecision() {
        switch (currentAction){
            case IDLE: break;
        }
    }
}
enum AIActionPossibilities{
    IDLE
}
