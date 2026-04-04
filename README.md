# 📌 GitForHabit

**A Terminal-Based Habit Tracker Inspired by Git**

GitForHabit is a lightweight command-line application that helps you build and maintain daily habits by tracking consistency, calculating streaks, and storing progress — all directly from your terminal.

It brings a **Git-like mindset to self-discipline**, where your daily actions become measurable contributions.

---

## 🧠 Concept

* Each day = a **commit**
* Each habit = a **tracked entity**
* Your streak = **consistency graph**

You can also define **weekly habit goals**:

* Set a minimum frequency (e.g., 4 times/week)
* If achieved, the week counts as a successful streak

---

## 🚀 Features

* ➕ **Add & Manage Habits**
  Easily create and maintain multiple habits.

* 🔥 **Daily & Weekly Streak Tracking**
  Tracks both continuous streaks and goal-based weekly consistency.

* 📜 **Persistent Storage (JSON)**
  All data is saved in `habits.json`, ensuring progress is never lost.

* 💻 **Terminal-Based Interface**
  Fast, minimal, and distraction-free workflow.

* 🧠 **Git-Inspired Tracking System**
  Encourages consistency using a version-control-like mindset.

---

## 🛠️ Tech Stack

* **Java** — Core application logic
* **Gson** — JSON serialization/deserialization
* **CLI** — Terminal-based interaction

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
java -cp ".;lib/gson-2.10.1.jar" com.lavish.habittracker.HabitApp
```

### Mac/Linux

```
javac -cp ".:lib/gson-2.10.1.jar" -d . src/com/lavish/habittracker/*.java
java -cp ".:lib/gson-2.10.1.jar" com.lavish.habittracker.HabitApp
```

---

## 📁 Data Storage

* All habits are stored in:

  ```
  habits.json
  ```
* Automatically created if missing
* Default structure:

  ```
  []
  ```

---

## ⚠️ Notes

* `.class` files are excluded via `.gitignore`
* Ensure Java is installed (`java -version`)
* Gson dependency is included in `/lib`

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork the repository and submit a pull request.

---

## 📜 License

This project is licensed under the MIT License.
