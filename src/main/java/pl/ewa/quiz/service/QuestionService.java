package pl.ewa.quiz.service;

import lombok.NoArgsConstructor;
import pl.ewa.quiz.model.Domain;
import pl.ewa.quiz.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ej on 09/02/2019.
 */
public class QuestionService {

    private final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    public QuestionService() {
        ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void addQuestion(){

    }

    public Question drawRandomQuestion(Domain domain){

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String queryAmount = "SELECT COUNT(q) FROM Question q WHERE q.domain LIKE :domain";
        Query q = em.createQuery(queryAmount);
        q.setParameter("domain", domain);
        Long amount = (Long)q.getSingleResult();

        String queryQuestion = "SELECT q FROM Question q WHERE q.id like :randomId";
        Random r = new Random();
        Question question = em.createQuery(queryQuestion, Question.class)
                .setParameter("randomId", (long)(r.nextInt(amount.intValue()) + 1)) //TODO na pewno nie tak!
                .getSingleResult();
        em.close();
        return question;
    }

    public List<Question> getQuestions(Domain domain){

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String queryQuestions = "SELECT q FROM Question q LEFT JOIN FETCH q.answers a WHERE q.domain LIKE :domain";

        List<Question> questions = em.createQuery(queryQuestions, Question.class)
                .setParameter("domain", domain)
                .getResultList();

        em.close();

        return questions;
    }

    public void modifyQuestion(){

    }

    public void deleteQuestion(){

    }


}
