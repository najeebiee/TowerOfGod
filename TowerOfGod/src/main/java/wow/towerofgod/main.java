package wow.towerofgod;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int currentFloor = 1;
        int shinsooLevel = 100;

        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor1Stack());
        floors.add(new Floor2Queue());
        floors.add(new Floor3HashMap());
        floors.add(new Floor4LinkedList());
        floors.add(new Floor5Graph());

        // Intro
        System.out.println("=======================================");
        System.out.println("     🌌 Welcome to the Tower of God 🌌");
        System.out.println("=======================================");
        System.out.println("Only those chosen by the Tower may climb.");
        System.out.println("Each floor holds a trial of wit, will, and Shinsoo.");
        System.out.println();

        // Ask for player name
        System.out.print("What is your name, Regular? : ");
        String name = s.nextLine();

        Player player = new Player(name, shinsooLevel, currentFloor);

        System.out.println("\nWelcome, " + name + ".");
        System.out.println("Your Shinsoo Level: " + player.getShinsooLevel());
        System.out.println("Prepare to ascend...\n");

        // Floor loop
        for (Floor floor : floors) {
            System.out.println("=======================================");
            System.out.println("         Entering Floor " + player.getCurrentFloor());
            System.out.println("=======================================");

            floor.enter(player);

            if (!player.isAlive()) {
                System.out.println("\n💀 Your Shinsoo has been depleted...");
                System.out.println("You have failed to climb the Tower.");
                break;
            }

            player.advanceFloor();
            System.out.println("\n✅ Floor cleared! Shinsoo Level: " + player.getShinsooLevel());
            System.out.println("Ascending to the next floor...\n");
        }

        if (player.isAlive()) {
            System.out.println("🏆 Congratulations, " + player.getName() + "!");
            System.out.println("You have conquered the Tower's trials... for now.");
        }

        s.close();
    }
}
