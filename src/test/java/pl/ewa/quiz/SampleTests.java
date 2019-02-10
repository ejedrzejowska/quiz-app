package pl.ewa.quiz;

import org.junit.Test;
import pl.ewa.quiz.model.Domain;
import pl.ewa.quiz.model.Question;
import pl.ewa.quiz.service.QuestionService;

import java.util.List;

/**
 * Created by ej on 09/02/2019.
 */
public class SampleTests {

    @Test
    public void getQuestionTest(){

        QuestionService qs = new QuestionService();

        List<Question> questions = qs.getQuestions(Domain.MULTIPLICATION);
        System.out.println("rozmiar " + questions.size());
    }

    @Test
    public void getRandomQuestionTest(){
        QuestionService qs = new QuestionService();

        Question q = qs.drawRandomQuestion(Domain.ENGLISH);
        System.out.println(q.getQuestion());
    }
}
