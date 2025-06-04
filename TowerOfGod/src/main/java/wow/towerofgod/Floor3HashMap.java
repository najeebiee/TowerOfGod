package wow.towerofgod;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Floor3HashMap {
     private static final Map<String, String> CATALYST_PROPERTIES = new HashMap<>();
    private static final String[] PROPERTIES = {"Heat", "Water", "Wind", "Gravity", "Light", "Storm", "Mist", "Void"};
    private static final Random random = new Random();
    private static int shinsooEnergy = 100;
    private static int correctAnswers = 0;
    private static final int PUZZLE_REQUIREMENT = 3;
    
    static {
        // Simplified catalyst-property pairs
        CATALYST_PROPERTIES.put("Crimson Core", "Heat");
        CATALYST_PROPERTIES.put("Azure Gem", "Water");
        CATALYST_PROPERTIES.put("Verdant Shard", "Wind");
        CATALYST_PROPERTIES.put("Obsidian Fragment", "Gravity");
        CATALYST_PROPERTIES.put("Golden Prism", "Light");
        CATALYST_PROPERTIES.put("Violet Crystal", "Storm");
        CATALYST_PROPERTIES.put("Silver Orb", "Mist");
        CATALYST_PROPERTIES.put("Ebony Stone", "Void");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Shinsoo Resonance Chamber ===");
        System.out.println("Administrator: \"Match catalysts to their Shinsoo properties.\"");
        System.out.println("               \"Answer 3 correctly to solve my puzzle.\"\n");
        
        while (shinsooEnergy > 0) {
            String catalyst = getRandomCatalyst();
            String correctProperty = CATALYST_PROPERTIES.get(catalyst);
            String[] options = generateOptions(correctProperty);
            
            System.out.println("\nEnergy: " + shinsooEnergy + "% | Correct: " + correctAnswers + "/" + PUZZLE_REQUIREMENT);
            System.out.println("\nCatalyst: " + catalyst);
            System.out.println("Properties:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i+1) + ") " + options[i]);
            }
            
            System.out.print("Choose (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice >= 1 && choice <= 4 && 
                options[choice-1].equalsIgnoreCase(correctProperty)) {
                correctAnswers++;
                shinsooEnergy = Math.min(100, shinsooEnergy + 10);
                System.out.println("\nCorrect! Energy +10");
                
                if (correctAnswers >= PUZZLE_REQUIREMENT) {
                    if (solvePuzzle(scanner)) {
                        System.out.println("\nAdministrator: \"You may proceed.\"");
                        break;
                    } else {
                        correctAnswers = 0;
                    }
                }
            } else {
                int damage = 15 + random.nextInt(10);
                shinsooEnergy -= damage;
                System.out.println("\nWrong! Energy -" + damage + " | Correct: " + correctProperty);
                if (shinsooEnergy <= 0) {
                    System.out.println("\nYou collapsed! Game Over.");
                }
            }
        }
        scanner.close();
    }
    
    private static String[] generateOptions(String correctProperty) {
        String[] options = new String[4];
        options[0] = correctProperty;
        
        for (int i = 1; i < 4; i++) {
            String randomProp;
            do {
                randomProp = PROPERTIES[random.nextInt(PROPERTIES.length)];
            } while (arrayContains(options, randomProp));
            options[i] = randomProp;
        }
        
        // Shuffle options
        for (int i = 0; i < options.length; i++) {
            int randomPos = random.nextInt(options.length);
            String temp = options[i];
            options[i] = options[randomPos];
            options[randomPos] = temp;
        }
        
        return options;
    }
    
    private static boolean arrayContains(String[] arr, String value) {
        for (String s : arr) {
            if (s != null && s.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean solvePuzzle(Scanner scanner) {
        System.out.println("\nAdministrator: \"Now, arrange these properties in order:\"");
        System.out.println("1) Heat\n2) Water\n3) Wind\n4) Gravity");
        System.out.print("Enter sequence (e.g., 1,2,3,4): ");
        String answer = scanner.nextLine().trim();
        return answer.equalsIgnoreCase("1,2,3,4") || 
               answer.equalsIgnoreCase("1, 2, 3, 4");
    }
    
    private static String getRandomCatalyst() {
        int index = random.nextInt(CATALYST_PROPERTIES.size());
        return (String) CATALYST_PROPERTIES.keySet().toArray()[index];
    }
}
