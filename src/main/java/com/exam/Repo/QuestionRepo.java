package com.exam.Repo;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question,Long> {

    Set<Question> findByQuiz(Quiz quiz);
}
