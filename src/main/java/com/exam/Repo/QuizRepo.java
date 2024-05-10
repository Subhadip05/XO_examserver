package com.exam.Repo;

import com.exam.entity.exam.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM quiz where qid=?1",nativeQuery = true)
    public void deletdQuiz(Long qid);

}
