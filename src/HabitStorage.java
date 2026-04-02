package src;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Habit.Habit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class HabitStorage {
    private static final String FILE_PATH = "habits.Json";

    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /*To Save the Data into the file */
    public static void saveData(ArrayList<Habit> habits) {
        ArrayList<HabitData> dataList = new ArrayList<>();
        for (Habit habit : habits) {
            dataList.add(toAddData(habit));
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(dataList, writer);
            System.out.println("Data Succesfully Saved !! ");
        } catch (IOException e) {
            System.out.println("Error Saving HabitData !!" + e.getMessage());
        }
    }

    /* To Load Data from File When Starting the Program */
    public static ArrayList<Habit> loadData() {
        try (FileReader fReader = new FileReader(FILE_PATH)) {
            // TypeToken tells Gson we want an ArrayList of HabitData specifically
            java.lang.reflect.Type type = new TypeToken<ArrayList<HabitData>>() {
            }.getType();
            ArrayList<HabitData> dataList = gson.fromJson(fReader, type);

            if (dataList == null)
                return new ArrayList<>();

            ArrayList<Habit> dataLoadedHabits = new ArrayList<>();
            for (HabitData habit : dataList) {
                dataLoadedHabits.add(fromData(habit));
            }
            return dataLoadedHabits;
        } catch (IOException e) {
            System.out.println("No Saved Habits Found. Have a fresh start" + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static class HabitData {
        private int habitId;
        private String habitName = "";
        private String habitDescription = "";
        private String frequency; // daily weekly
        private int target; // only for weekly
        private Map<String, Boolean> streakHistory;
        ArrayList<HabitData> dataList = new ArrayList<>();
    }

    /*
     * from Habit -> HabitData, because JSon does not accept LocalDate, so we input
     * date as string in HabitData.
     */
    private static HabitData toAddData(Habit habit) {
        HabitData data = new HabitData();
        data.habitId = habit.getHabitId();
        data.habitName = habit.getHabitName();
        data.habitDescription = habit.getHabitDescription();
        data.frequency = habit.getFrequency();
        data.target = habit.getTarget();
        Map<String, Boolean> stringHistory = new HashMap<>();
        for (Map.Entry<LocalDate, Boolean> entry : habit.getStreakHistory().entrySet()) {
            stringHistory.put(entry.getKey().toString(), entry.getValue());
        }
        data.streakHistory = stringHistory; // assigns stringHistory to streakHistory.
        return data;
    }

    /*
     * from HabitData -> Habit, as we input date as string in HabitData. then when
     * fetching and showing the user the Data,
     * we have to reconvert that string to a LocalDate Format.
     */
    private static Habit fromData(HabitData data) {
        Habit habit = new Habit(data.habitId, data.habitName, data.habitDescription, data.frequency, data.target);
        for (Map.Entry<String, Boolean> dataEntry : data.streakHistory.entrySet()) {
            habit.getStreakHistory().put(LocalDate.parse(dataEntry.getKey()), dataEntry.getValue());
        }
        return habit;
    }
}
