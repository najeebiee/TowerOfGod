
package wow.towerofgod;

import java.util.Scanner;

public class FinalFloorBoss extends Floor {

    @Override
    public void introStory() {
        System.out.println("\n🔥 === Final Floor: The Test of Transcendence ===");
        System.out.println("A colossal Shinsoo entity emerges, shaped by your journey.");
        System.out.println("It speaks: \"You have climbed far. Now face the Tower’s will.\"");
    }

    @Override
    public void enter(Player player) {
        Scanner s = new Scanner(System.in);

        // Floor 1
        System.out.println("\nPhase 1: Memory Echo");
        Floor1Stack phase1 = new Floor1Stack();
        phase1.enter(player);
        if (!player.isAlive()) return;

        // Floor 2
        System.out.println("\nPhase 2: Tactical Response");
        Floor2Queue phase2 = new Floor2Queue();
        phase2.enter(player);
        if (!player.isAlive()) return;

        // Floor 3
        System.out.println("\nPhase 3: Shinsoo Signature Match");
        Floor3HashMap phase3 = new Floor3HashMap();
        phase3.enter(player);
        if (!player.isAlive()) return;

        // Floor 4
        System.out.println("\nPhase 4: Path of Judgment");
        Floor5Graph phase4 = new Floor5Graph();
        phase4.enter(player);
        if (!player.isAlive()) return;

        // Lasr Floor
        System.out.println("\nFinal Phase: Shinsoo Clash");
        LastBattle finalPhase = new LastBattle();
        finalPhase.startCombat(player);

        
    }

    @Override
    public void outroStory() {
        System.out.println("The Shinsoo entity dissolves into light.");
        System.out.println("You have transcended the Tower’s trials. You are no longer a Regular.");
    }
}

