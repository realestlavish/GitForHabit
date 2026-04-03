# 📌 GitForHabit

**A Terminal-Based Personal Habit Tracker (Java CLI App)**

GitForHabit is a lightweight command-line application that helps you build and maintain daily habits by tracking your progress, calculating streaks, and storing your consistency history — all directly from the terminal.

* Each day = a commit
* Each habit = a tracked entity
* Your streak = contribution consistency


---

## 🚀 Features

* ➕ **Add Habits**
  Create and manage your personal habits easily.

* 🔥 **Streak Tracking**
  Automatically calculates streaks to keep you motivated.

* 📜 **Persistent Storage (JSON)**
  Saves your habits using a JSON file (`habits.json`) so your data is never lost.

* 💻 **Terminal-Based Interface**
  Fast, simple, and distraction-free experience.

* 🧠 **Git-style Habit Tracking Concept**
  Think of each day as a commit and your consistency as a contribution graph.

---

## 🛠️ Tech Stack

* **Java** (Core logic)
* **Gson** (JSON handling)
* **CLI (Terminal-based UI)**

---

## 📂 Project Structure

```
GitForHabit/
│
├── src/
│   └── com/lavish/habittracker/
│       ├── MainHabit.java
│       ├── Habit.java
│       ├── HabitMethods.java
│       ├── HabitStorage.java
│       └── streakDisplay.java
│
├── lib/
│   └── gson-2.10.1.jar
│
├── habits.json
├── run.bat
├── run.sh
└── README.md
```

---

## ▶️ How to Run

### 🪟 Windows

```
run.bat
```

### 🐧 Mac/Linux

```
chmod +x run.sh
./run.sh
```

---

## ⚙️ Manual Run (Alternative)

### Windows

```
javac -cp ".;lib/gson-2.10.1.jar" -d . src/com/lavish/habittracker/*.java
java -cp ".;lib/gson-2.10.1.jar" com.lavish.habittracker.MainHabit
```

### Mac/Linux

```
javac -cp ".:lib/gson-2.10.1.jar" -d . src/com/lavish/habittracker/*.java
java -cp ".:lib/gson-2.10.1.jar" com.lavish.habittracker.MainHabit
```

---

## 📁 Data Storage

* All habits are stored in:

  ```
  habits.json
  ```
* If the file does not exist, it is automatically created.
* Default format:

  ```
  []
  ```

---

## ⚠️ Notes

* `.class` files are ignored using `.gitignore`
* Ensure Java is installed and configured (`java -version`)
* Gson library is required (already included in `/lib`)

---

## 🤝 Contributing

Feel free to fork this repository and improve it!

---

## 📜 License

This project is open-source and available under the MIT License.
