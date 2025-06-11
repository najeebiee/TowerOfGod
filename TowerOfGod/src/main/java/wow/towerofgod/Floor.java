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
        System.out.println("The Tower.  \n" +
            "A mystical structure that grants **any wish** to those who reach its summit.  \n" +
            "You are a **Regular**, chosen by Headon, the Tower’s Guardian.  \n" +
            "As you step into the **First Floor**, a floating, rabbit-like Guide greets you:  \n" +           
            "*\"Welcome, Regular. To ascend, you must conquer each floor’s trial.*  \n" +
            "*But beware—the Tower tests not just strength, but* **logic, order, and memory.**  \n" +
            "*Fail, and you’ll be erased.*\"  \n" +
            "The gates slam shut behind you. There is no turning back.  \n" +
            "**Your climb begins now.**  ");
    }
    
    public void outroStory() {
        System.out.println("At the summit, you stand before **The King of the Tower**—a being of pure code.  \n" +
            "\n" + "*\"You have proven yourself,\"* it booms. *\"But know this: the Tower is not a test…*  \n" +
            "*It is a **program**, and you are but a variable in its grand function.\"*  \n" +
            "\n" + "The screen flickers.  \n" +
            "\n" + "**GAME OVER?**  \n" +
            "**OR JUST ANOTHER LOOP?**  \n" +
            "\n" + "(New Game+ Unlocked: **Hard Mode**)  ");
    }
    
}
