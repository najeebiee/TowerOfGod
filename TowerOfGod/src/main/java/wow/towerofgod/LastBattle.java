
package wow.towerofgod;

import java.util.Scanner;

public class LastBattle {
    private int playerHP = 100;
    private int bossHP = 150;
    private boolean playerCharged = false;
    private boolean bossCharged = false;

    private Scanner scanner = new Scanner(System.in);

    public void startCombat(Player player) {
        System.out.println("\n🔥 Final Phase: Shinsoo Clash Begins!");
        System.out.println("You face the Tower’s Shinsoo Avatar in a duel of will and power!");

        while (playerHP > 0 && bossHP > 0) {
            System.out.println("\nYour HP: " + playerHP + " | Boss HP: " + bossHP);
            System.out.println("Choose your action:");
            System.out.println("[1] Attack\n[2] Defend\n[3] Charge Shinsoo\n[4] Use Memory");

            String choice = scanner.nextLine().trim();
            int bossAction = (int)(Math.random() * 3) + 1; // 1: Attack, 2: Charge, 3: Special

            switch (choice) {
                case "1": // Attack
                    int damage = playerCharged ? 30 : 15;
                    bossHP -= damage;
                    System.out.println("You strike the boss for " + damage + " damage!");
                    playerCharged = false;
                    break;

                case "2": // Defend
                    System.out.println("You brace yourself for the next attack.");
                    break;

                case "3": // Charge
                    playerCharged = true;
                    System.out.println("You gather Shinsoo... Next attack will be stronger!");
                    break;

                case "4": // Use Memory
                    System.out.println("Answer this: What Shinsoo property is linked to the Crimson Core?");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("Heat")) {
                        System.out.println("Correct! You unleash a powerful memory strike!");
                        bossHP -= 25;
                    } else {
                        System.out.println("Wrong! The memory backfires.");
                        playerHP -= 10;
                    }
                    break;

                default:
                    System.out.println("Invalid action. You hesitate...");
                    break;
            }

            // Boss Turn
            if (bossHP > 0) {
                switch (bossAction) {
                    case 1: // Attack
                        int bossDamage = bossCharged ? 25 : 15;
                        if (choice.equals("2")) bossDamage /= 2;
                        playerHP -= bossDamage;
                        System.out.println("The boss attacks you for " + bossDamage + " damage!");
                        bossCharged = false;
                        break;

                    case 2: // Charge
                        bossCharged = true;
                        System.out.println("The boss gathers Shinsoo...");
                        break;

                    case 3: // Special
                        System.out.println("The boss unleashes a Shinsoo wave!");
                        playerHP -= 20;
                        break;
                }
            }
        }

        if (playerHP <= 0) {
            System.out.println("\n💀 You have fallen in the final battle...");
            player.drainShinsoo(player.getShinsooLevel()); // Set Shinsoo to 0
        } else {
            System.out.println("\n🏆 You have defeated the Shinsoo Avatar!");
        }
    }
}

