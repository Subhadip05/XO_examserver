package com.exam.service.impl;

import com.exam.Repo.QuestionRepo;
import com.exam.Repo.QuizRepo;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private QuizRepo quizRepo;

//    @Override
//    public Question addQuestion(Question question) {
//        return this.questionRepo.save(question);
//    }
//
//    @Override
//    public Question updateQuestion(Question question) {
//        return this.questionRepo.save(question);
//    }

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

    @Override
    public Question get(Long questionId) {
        return this.questionRepo.getOne(questionId);
    }

    @Override
    public List<Question> addQuestions(List<Question> questions) {
        for(Question q : questions){
            if(q.getQuiz() != null && q.getQuiz().getQId() != null){
                Quiz managedQuiz = this.quizRepo.findById(q.getQuiz().getQId())
                        .orElseThrow(()-> new RuntimeException("Create Question - Quiz is not found with Id: "+q.getQuiz().getQId()));

                q.setQuiz(managedQuiz);
            }
        }
        return this.questionRepo.saveAll(questions);
    }

    @Override
    public Question updateQuestion(Question question) {
        if (question.getQuiz() != null && question.getQuiz().getQId() != null) {
            Quiz managedQuiz = this.quizRepo.findById(question.getQuiz().getQId())
                    .orElseThrow(() -> new RuntimeException("Update Question - Quiz not found with ID: " + question.getQuiz().getQId()));

            question.setQuiz(managedQuiz);
        }
        return this.questionRepo.save(question);
    }


}
