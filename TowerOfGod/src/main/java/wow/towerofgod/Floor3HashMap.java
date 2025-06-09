package wow.towerofgod;

import java.util.*;

public class Floor3HashMap extends Floor {

    private static final Map<String, String> CATALYST_PROPERTIES = new HashMap<>();
    private static final String[] PROPERTIES = {"Heat", "Water", "Wind", "Gravity", "Light", "Storm", "Mist", "Void"};
    private static final Random random = new Random();
    private static final int PUZZLE_REQUIREMENT = 3;

    static {
        CATALYST_PROPERTIES.put("Crimson Core", "Heat");
        CATALYST_PROPERTIES.put("Azure Gem", "Water");
        CATALYST_PROPERTIES.put("Verdant Shard", "Wind");
        CATALYST_PROPERTIES.put("Obsidian Fragment", "Gravity");
        CATALYST_PROPERTIES.put("Golden Prism", "Light");
        CATALYST_PROPERTIES.put("Violet Crystal", "Storm");
        CATALYST_PROPERTIES.put("Silver Orb", "Mist");
        CATALYST_PROPERTIES.put("Ebony Stone", "Void");
    }

    @Override
    public void enter(Player player) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("🌌 === Floor 3: Shinsoo Resonance Chamber ===");
        System.out.println("Administrator: \"Match catalysts to their Shinsoo properties.\"");
        System.out.println("               \"Answer 3 correctly to proceed.\"\n");

        while (player.isAlive()) {
            String catalyst = getRandomCatalyst();
            String correctProperty = CATALYST_PROPERTIES.get(catalyst);
            String[] options = generateOptions(correctProperty);

            System.out.println("\nShinsoo: " + player.getShinsooLevel() + "% | Correct: " + correctAnswers + "/" + PUZZLE_REQUIREMENT);
            System.out.println("Catalyst: " + catalyst);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }

            System.out.print("Choose (1-4): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (choice >= 1 && choice <= 4 && options[choice - 1].equalsIgnoreCase(correctProperty)) {
                correctAnswers++;
                System.out.println("✅ Correct! Shinsoo resonates with your answer.");
                if (correctAnswers >= PUZZLE_REQUIREMENT) {
                    if (solvePuzzle(scanner)) {
                        System.out.println("\nAdministrator: \"You may proceed.\"");
                        break;
                    } else {
                        correctAnswers = 0;
                        System.out.println("❌ Incorrect sequence. Try again.");
                    }
                }
            } else {
                int damage = 15 + random.nextInt(10);
                player.drainShinsoo(damage);
                System.out.println("❌ Wrong! Shinsoo backlash - " + damage + " | Correct: " + correctProperty);
                if (!player.isAlive()) {
                    System.out.println("\n💀 You collapsed from Shinsoo overload...");
                }
            }
        }
    }

    private String[] generateOptions(String correctProperty) {
        String[] options = new String[4];
        options[0] = correctProperty;

        for (int i = 1; i < 4; i++) {
            String randomProp;
            do {
                randomProp = PROPERTIES[random.nextInt(PROPERTIES.length)];
            } while (arrayContains(options, randomProp));
            options[i] = randomProp;
        }

        // Dito na mag Shuffle options sir
        for (int i = 0; i < options.length; i++) {
            int randomPos = random.nextInt(options.length);
            String temp = options[i];
            options[i] = options[randomPos];
            options[randomPos] = temp;
        }

        return options;
    }

    private boolean arrayContains(String[] arr, String value) {
        for (String s : arr) {
            if (s != null && s.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    private boolean solvePuzzle(Scanner scanner) {
        System.out.println("\nAdministrator: \"Now, arrange these properties in order:\"");
        System.out.println("1) Heat\n2) Water\n3) Wind\n4) Gravity");
        System.out.print("Enter sequence (e.g., 1,2,3,4): ");
        String answer = scanner.nextLine().trim();
        return answer.equalsIgnoreCase("1,2,3,4") || answer.equalsIgnoreCase("1, 2, 3, 4");
    }

    private String getRandomCatalyst() {
        int index = random.nextInt(CATALYST_PROPERTIES.size());
        return (String) CATALYST_PROPERTIES.keySet().toArray()[index];
    }
}
