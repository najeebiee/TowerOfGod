import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Floor2Queue {
    private Queue<String> fateLine;
    private int shinsooEnergy;
    private boolean penaltyActive;

    public Floor2Queue () {
        fateLine = new LinkedList<>();
        initializeTasks();
        shinsooEnergy = 100;
        penaltyActive = false;
    }

    private void initializeTasks() {
        fateLine.add("Defeat the Mimic");
        fateLine.add("Retrieve the Orb");
        fateLine.add("Answer the Riddle");
        fateLine.add("Disarm the Trap");
        fateLine.add("Light the Brazier");
    }

    public void displayPuzzle() {
        System.out.println("\n=== Floor 2: The Line of Fate ===");
        System.out.println("A towering figure draped in clockwork robes materializes before you.");
        System.out.println("\"I am the Keeper of Order. You shall face your trials... IN SEQUENCE.\"");
        System.out.println("Its skeletal finger points to a glowing queue of tasks hanging in mid-air.");
        System.out.println("\nYour Energy: " + shinsooEnergy);
        printCurrentTask();
    }

    private void printCurrentTask() {
        if (!fateLine.isEmpty()) {
            System.out.println("\nCurrent Task: " + fateLine.peek());
            System.out.println("Remaining Tasks: " + fateLine.size());
        }
    }

    public boolean solve(Scanner scanner) {
        while (!fateLine.isEmpty() && shinsooEnergy > 0) {
            if (penaltyActive) {
                System.out.println("\nThe Keeper booms: \"BACK OF THE LINE!\"");
                System.out.println("A wave of temporal energy drains your Shinsoo!");
                shinsooEnergy -= 30;
                penaltyActive = false;
                if (shinsooEnergy <= 0) break;
            }

            System.out.println("\nWhat will you do?");
            System.out.println("[1] Attempt current task");
            System.out.println("[2] View all tasks (Costs 5 Shinsoo)");
            System.out.print("Choice: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                attemptTask(scanner);
            } else if (input.equals("2")) {
                if (shinsooEnergy >= 5) {
                    shinsooEnergy -= 5;
                    System.out.println("\nFull Line of Fate:");
                    System.out.println(fateLine);
                    System.out.println("Energy: " + shinsooEnergy);
                } else {
                    System.out.println("Not enough Shinsoo!");
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }

        if (fateLine.isEmpty()) {
            System.out.println("\nThe Keeper's voice echoes: \"Order is maintained. You may proceed.\"");
            return true;
        } else {
            System.out.println("\nYour Energy is depleted! The Keeper condemns you to restart the floor.");
            return false;
        }
    }

    private void attemptTask(Scanner scanner) {
        String currentTask = fateLine.peek();
        System.out.println("\nAttempting: " + currentTask);

        switch (currentTask) {
            case "Defeat the Mimic":
                System.out.println("A treasure chest sprouts teeth and leaps at you!");
                System.out.print("Do you [stab] or [dodge]? ");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("stab")) {
                    completeTask();
                } else {
                    failTask();
                }
                break;

            case "Retrieve the Orb":
                System.out.println("A glowing orb floats just out of reach.");
                System.out.print("Do you [jump] or [use hook]? ");
                action = scanner.nextLine();
                if (action.equalsIgnoreCase("use hook")) {
                    completeTask();
                } else {
                    failTask();
                }
                break;

            case "Answer the Riddle":
                System.out.println("A spectral voice asks: \"What walks on four legs at dawn, two at noon, and three at twilight?\"");
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("man")) {
                    completeTask();
                } else {
                    failTask();
                }
                break;

            case "Disarm the Trap":
                System.out.println("You spot pressure plates on the floor.");
                System.out.print("Disarm by cutting [red] or [blue] wire? ");
                action = scanner.nextLine();
                if (action.equalsIgnoreCase("blue")) {
                    completeTask();
                } else {
                    failTask();
                }
                break;

            case "Light the Brazier":
                System.out.println("An ancient brazier awaits flame.");
                System.out.print("Use [fire spell] or [torch]? ");
                action = scanner.nextLine();
                if (action.equalsIgnoreCase("fire spell")) {
                    completeTask();
                } else {
                    failTask();
                }
                break;
        }
    }

    private void completeTask() {
        System.out.println("Success! " + fateLine.poll() + " completed.");
        printCurrentTask();
    }

    private void failTask() {
        System.out.println("Wrong choice! The Keeper enforces order...");
        
        Queue<String> tempQueue = new LinkedList<>();
        while (!fateLine.isEmpty()) {
            tempQueue.add(fateLine.poll());
        }
        fateLine = tempQueue;
        
        penaltyActive = true;
    }

    public String getHint() {
        return "The Keeper demands strict sequence. Peek at the queue's head before acting. Wrong choices send you to the back!";
    }
}
