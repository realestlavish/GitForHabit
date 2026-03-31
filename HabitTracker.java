import java.util.ArrayList;
import java.util.Scanner;

public final class HabitTracker {
    private static int counter = 1;
    private int habitId;
    private String habitName = "";
    private String habitDescription = "";
    private ArrayList<HabitTracker> habits = new ArrayList<>();

    public HabitTracker() {
    }

    private HabitTracker(String habitName, String habitDescription) {
        this.habitId = counter++;
        this.habitName = habitName;
        this.habitDescription = habitDescription;
    }

    public void addHabit(String habitName, String habitDescription) {
        habits.add(new HabitTracker(habitName, habitDescription));
        System.out.println("Habit added successfully.");
    }

    public void removeAHabit(int inputhabitId) {

        boolean removed = habits.removeIf(habit -> habit.getHabitId() == inputhabitId);
        if (removed) {
            System.out.println("Habit removed successfully.");
        } else {
            System.out.println("Habit with ID " + inputhabitId+ " was not found.");
        }
    }

    public int getHabitId() {
        return habitId;
    }

    public void showallHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits found.");
            return;
        }

        System.out.println("Habit List:");
        for (var habit : habits) {
            System.out.println(habit.toString());
        }
    }

    @Override
    public String toString() {
        return "ID: " + habitId +
                " | Habit: " + habitName +
                " | Description : " + habitDescription;
    }

    public void removeallHabits() {
        habits.clear();
        counter = 1;
        System.out.println("All habits cleared.");
    }

    public void main(String[] args) {
        try (Scanner inputHabit = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nChoose an action:");
                System.out.println("1. Add Habit");
                System.out.println("2. Remove Habit");
                System.out.println("3. List Habits");
                System.out.println("4. Clear List");
                System.out.println("5. Exit");

                int choice = inputHabit.nextInt();
                inputHabit.nextLine();

                switch (choice) {
                    case 1:

                        System.out.println("Please enter the Habit Name:");
                        String habitInputString = inputHabit.nextLine();

                        System.out.println("Please enter the Habit Description:");
                        String habitInputDescString = inputHabit.nextLine();

                        addHabit(habitInputString, habitInputDescString);
                        break;
                    case 2:
                        System.out.println("Please input id to be deleted:");
                        int delId = inputHabit.nextInt();
                        inputHabit.nextLine();
                        removeAHabit(delId);
                        break;
                    case 3:
                        showallHabits();
                        break;
                    case 4:
                        removeallHabits();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Please choose a valid option.");
                }
            }
        }
    }
}
