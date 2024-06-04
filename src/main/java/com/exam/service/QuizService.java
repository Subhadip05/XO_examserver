package com.exam.service;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public Set<Quiz> getQuizzes();


    public List<Quiz> getQuizzesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
