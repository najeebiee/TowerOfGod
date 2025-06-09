package wow.towerofgod;

import java.util.*;

public class Floor5Graph extends Floor {

    private final Map<String, LinkedList<String>> labyrinth = new HashMap<>();
    private final List<String> correctPath = Arrays.asList("A", "C", "F", "G");

    @Override
    public void introStory() {
        System.out.println("\n🧭 === Floor 5: The Strategic Labyrinth ===");
        System.out.println("You enter a vast maze of floating chambers.");
        System.out.println("A cunning Administrator whispers: \"Only those who choose wisely may find the exit.\"");
        System.out.println("Each chamber connects to others. Choose your path carefully.\n");
    }

    @Override
    public void enter(Player player) {
        Scanner scanner = new Scanner(System.in);
        buildLabyrinth();

        String current = "A";
        int step = 1;

        while (!current.equals("G") && player.isAlive()) {
            System.out.println("📍 You are in Chamber " + current);
            System.out.println("Connected Chambers: " + labyrinth.get(current));
            System.out.print("Step " + step + " - Choose your next chamber: ");
            String next = scanner.nextLine().trim().toUpperCase();

            if (labyrinth.get(current).contains(next)) {
                if (next.equals(correctPath.get(step))) {
                    current = next;
                    step++;
                } else {
                    System.out.println("❌ You took a wrong turn. A Shinsoo beast attacks!");
                    player.drainShinsoo(20);
                    return;
                }
            } else {
                System.out.println("❌ Invalid move. That chamber is not connected!");
                player.drainShinsoo(10);
                return;
            }
        }

        if (current.equals("G")) {
            System.out.println("✅ You found the hidden exit of the labyrinth!");
        } else {
            System.out.println("❌ You failed to escape the maze.");
        }
    }

    @Override
    public void outroStory() {
        System.out.println("The labyrinth fades into mist as you step through the final gate.");
        System.out.println("The Administrator nods silently. You have passed the trial of strategy.");
    }

    private void buildLabyrinth() {
        labyrinth.put("A", new LinkedList<>(Arrays.asList("B", "C")));
        labyrinth.put("B", new LinkedList<>(Arrays.asList("D")));
        labyrinth.put("C", new LinkedList<>(Arrays.asList("E", "F")));
        labyrinth.put("D", new LinkedList<>(Arrays.asList("G")));
        labyrinth.put("E", new LinkedList<>(Arrays.asList("G")));
        labyrinth.put("F", new LinkedList<>(Arrays.asList("G")));
        labyrinth.put("G", new LinkedList<>());
    }
}
