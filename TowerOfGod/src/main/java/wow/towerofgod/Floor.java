/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wow.towerofgod;

/**
 *
 * @author Students Account
 */
public abstract class Floor {
    
    protected String floorName;
    public abstract void enter();

    // Story of the tower
    public void introStory() {
        System.out.println("Intro of the floor");
    }
    
    public void outroStory() {
        System.out.println("Outro of the floor");
    }
    
}
