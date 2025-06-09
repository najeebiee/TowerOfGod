package wow.towerofgod;

import java.util.*;

public class Floor4LinkedList extends Floor {

    private final List<String> correctOrder = Arrays.asList(
        "The Birth of the Tower",
        "The Arrival of the First Regular",
        "The Pact with the Guardians",
        "The Great Shinsoo Flood",
        "The Rise of the 10 Great Families"
    );

    @Override
    public void introStory() {
        System.out.println("\n🌫️ === Floor 4: The Fragmented Path ===");
        System.out.println("You step onto a bridge of floating memory shards.");
        System.out.println("A voice whispers: \"Only those who remember the Tower's past may cross.\"");
        System.out.println("Reconstruct the timeline of key events to stabilize the path.\n");
    }

    @Override
    public void enter(Player player) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> fragments = new LinkedList<>(correctOrder);
        Collections.shuffle(fragments);

        System.out.println("🧩 The memory shards shimmer before you:");
        for (int i = 0; i < fragments.size(); i++) {
            System.out.println((i + 1) + ") " + fragments.get(i));
        }

        System.out.println("\nEnter the correct order by typing the numbers separated by commas (e.g., 3,1,2,4,5):");
        System.out.print("Your sequence: ");
        String input = scanner.nextLine().trim();
        String[] indices = input.split(",");

        if (indices.length != correctOrder.size()) {
            System.out.println("❌ Invalid number of entries. The path collapses!");
            player.drainShinsoo(20);
            return;
        }

        List<String> playerOrder = new ArrayList<>();
        try {
            for (String index : indices) {
                int i = Integer.parseInt(index.trim()) - 1;
                if (i < 0 || i >= fragments.size()) {
                    throw new IndexOutOfBoundsException();
                }
                playerOrder.add(fragments.get(i));
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input. The illusions distort your memory!");
            player.drainShinsoo(20);
            return;
        }

        if (playerOrder.equals(correctOrder)) {
            System.out.println("✅ The path stabilizes. You walk across safely.");
        } else {
            System.out.println("❌ The fragments shatter! Your memory falters.");
            player.drainShinsoo(20);
        }
    }

    @Override
    public void outroStory() {
        System.out.println("The illusions fade, and the bridge reforms behind you.");
        System.out.println("You feel a deeper understanding of the Tower's history.");
    }
}
