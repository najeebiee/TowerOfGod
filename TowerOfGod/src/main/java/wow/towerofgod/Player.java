
package wow.towerofgod;

public class Player {
    
    private String name;
    int shinsooLevel;
    int currentFloor;
    
    public Player(String name, int shinsooLevel, int currentFloor) {
        this.name = name;
        this.shinsooLevel = shinsooLevel;
        this.currentFloor = currentFloor;
    }
    
    public void drainShinsoo(int amount) {
        shinsooLevel -= amount;
        if (shinsooLevel < 0) shinsooLevel = 0;
    }
    
    public static void restoreShinsoo(int amount) {
        
    }
    
    public boolean isAlive() {
        
        return shinsooLevel > 0;
        
    }
    
    public int getShinsooLevel() {
        return shinsooLevel;
    }
    
    public int getCurrentFloor() {
        return currentFloor;
    }
    
    public String getName() {
        return name;
    }
    
    public void advanceFloor() {
        currentFloor++;
    }
    
}
