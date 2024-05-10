package com.exam.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;
    private String title;
    private String description;
    private String maxMarks;
    private String numberOfQuestions;
    private  boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz",orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }



    public Quiz() {
    }

    public Long getQId() {
        return qId;
    }

    public void setQId(Long qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
