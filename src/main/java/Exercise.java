public class Exercise {

    protected int reps, weight;
    protected String variation;

    public void setReps(int repNumber) {
        this.reps = repNumber;
    }

    public int getReps() {
        return reps;
    }

    public void setWeight(int weightAmount) {
        this.weight = weightAmount;
    }

    public int getWeight() {
        return weight;
    }

    public void setVariation(String var) {
        this.variation = var;
    }

    public String getVariation() {
        return variation;
    }

}

class Snatch extends Exercise {

    public Snatch() {
        variation = "Snatch";
    }
}

class CleanAndJerk extends Exercise {

    public CleanAndJerk() {
        variation = "Clean and jerk";
    }
}

class Squat extends Exercise {

    public Squat() {
        variation = "Back squat";
    }
}

class Pull extends Exercise {

    public Pull() {
        variation = "Deadlift";
    }
}

class UpperBody extends Exercise {

    public UpperBody() {
        variation = "Push press";
    }
}

class Accessory extends Exercise {

    public Accessory() {
        variation = "Biceps curl";
    }
}
