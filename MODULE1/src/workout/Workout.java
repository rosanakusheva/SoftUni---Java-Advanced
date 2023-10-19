package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(exercise ->
                exercise.getName().equals(name) &&
                        exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter(exercise ->
                        exercise.getName().equals(name) &&
                                exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int calories = 0;
        if (this.exercises.size() > 0) {
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() > calories) {
                    calories = ex.getBurnedCalories();
                }
            }
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() == calories) {
                    exercise = ex;
                    break;
                }
            }
        }

        return exercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Workout type: %s", this.type));

        this.exercises.forEach(exercise -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(exercise);
        });

        return stringBuilder.toString();
    }
}
