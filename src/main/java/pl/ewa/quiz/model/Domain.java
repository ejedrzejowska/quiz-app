package pl.ewa.quiz.model;

/**
 * Created by ej on 09/02/2019.
 */
public enum Domain {
    ENGLISH("Angielski"),
    MULTIPLICATION("Mnożenie"),
    FRACTIONS("Ułamki");

    private String description;

    Domain(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return this.name();
    }
}
