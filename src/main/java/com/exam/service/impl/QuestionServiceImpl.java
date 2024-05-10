package com.exam.service.impl;

import com.exam.Repo.QuestionRepo;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepo.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepo.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qid) {
//        this.questionRepo.deleteById(qid);
        Question question = new Question();
        question.setQuesId(qid);
        this.questionRepo.delete(question);
    }
}
