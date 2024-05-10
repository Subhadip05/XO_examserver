package com.exam.service;

import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public Set<Quiz> getQuizzes();



}
