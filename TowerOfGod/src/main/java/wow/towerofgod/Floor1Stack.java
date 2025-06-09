package wow.towerofgod;

import java.util.Scanner;
import java.util.Stack;

public class Floor1Stack extends Floor {

    private final String[] whispers = {
        "Ignite", "Flow", "Resonate", "Pulse", "Echo"
    };

    @Override
    public void enter(Player player) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> whisperStack = new Stack<>();

        System.out.println("\n🌀 === Floor 1: The Administrator's Whisper ===");
        System.out.println("A deep, ancient voice echoes in your mind...");
        System.out.println("\"Repeat my whispers... in reverse... or be consumed by the Shinsoo.\"\n");

        // Dito na yung Whispering phase
        System.out.println("The Administrator whispers:");
        for (String word : whispers) {
            System.out.println("🔊 " + word);
            whisperStack.push(word);
        }

        System.out.println("\nNow, repeat the whispers in reverse order.");
        boolean success = true;

        for (int i = 0; i < whispers.length; i++) {
            System.out.print("Word " + (i + 1) + ": ");
            String input = scanner.nextLine().trim();

            String expected = whisperStack.pop();
            if (!input.equalsIgnoreCase(expected)) {
                success = false;
                break;
            }
        }

        if (success) {
            System.out.println("\n✅ The whispers fade... A hidden path opens before you.");
        } else {
            System.out.println("\n❌ The whispers scream in your ears! You failed to repeat them correctly.");
            System.out.println("Shinsoo backlash surges through your body...");
            player.drainShinsoo(25);
        }
    }
}
