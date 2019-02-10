package pl.ewa.quiz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ej on 09/02/2019.
 */
@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answer;

    private boolean isCorrect;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question question;

}
