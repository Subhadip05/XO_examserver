package com.exam.service.impl;

import com.exam.Repo.QuizRepo;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepo.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {

//        this.quizRepo.deleteById(quizId);

        Quiz quiz = new Quiz();
        quiz.setQId(quizId);
        this.quizRepo.delete(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepo.findAll());
    }
}
