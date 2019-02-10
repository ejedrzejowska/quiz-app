package pl.ewa.quiz.controller;

import pl.ewa.quiz.model.Domain;
import pl.ewa.quiz.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ej on 09/02/2019.
 */
@WebServlet(urlPatterns = {
        QuizServlet.CHOICE_ACTION,
        QuizServlet.QUESTIONNAIRE_ACTION
})
public class QuizServlet extends HttpServlet {
    public static final String TEXT_HTML =     "text/html";

    public static final String CHOICE_ACTION =    "/";
    public static final String QUESTIONNAIRE_ACTION = "/questionnaire";

    private QuestionService questionService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals(CHOICE_ACTION)) {
            choiceForm(request, response);
        }
    }

    private void choiceForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("choice.jsp").forward(request, response);
    }

    private void questionForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", questionService.drawRandomQuestion(Domain.ENGLISH));
        request.getRequestDispatcher("questionnaire.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getServletPath().equals(CHOICE_ACTION)) {
            choiceForm(request, response);
        } else if(request.getServletPath().equals(QUESTIONNAIRE_ACTION)){
            String choice = request.getParameter("choice");
            questionForm(request, response);
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
        questionService = new QuestionService();
    }
    
}
