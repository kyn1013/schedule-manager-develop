package com.example.scheduledevelop.core.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Schedule(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Schedule() {
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void updateSchedule(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
