package com.exam.controller;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        System.out.println(question);
        System.out.println("adding question successful");
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //get all question af any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Question> questions=quiz.getQuestions();
        int totalQuestions=Integer.parseInt(quiz.getNumberOfQuestions());
        List list=new ArrayList(questions);
        if(list.size()>totalQuestions)
        {
            list=list.subList(0,totalQuestions+1);
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getAllQuestionsOfQuizAdmin(@PathVariable("qid") Long qid)
    {
        Quiz quiz=new Quiz();
        quiz.setQId(qid);
        Set<Question>list=this.service.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(list);
    }

    //get a single question
    @GetMapping("/{qid}")
    public Question getQuestion(@PathVariable("qid") Long qid)
    {
        return this.service.getQuestion(qid);
    }


    //delete a single question
    @DeleteMapping("{qid}")
    public void deleteQuestion(@PathVariable("qid") Long qid)
    {
        this.service.deleteQuestion(qid);
    }
}
