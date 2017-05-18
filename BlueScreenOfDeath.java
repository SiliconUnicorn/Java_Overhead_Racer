/**
*
*
@author Seagull Soars and Silicon Unicorn
version 0.1
*/
private int numberOfOpponentRacers=10;
public class BlueScreenOfDeath{
  
  }
public void act(){
  setupRacers();
  setUpTrack();
   }
  public void setupTrack(){
    
  }
public void setupRacers(int numberOfOpponentRacers){
      while(numberOfOpponentRacers > 0){
      OpponentRacer opponentRacer = new OpponentRacer();
      addObject(new opponentRacer(), _x, _y); 
}
  
