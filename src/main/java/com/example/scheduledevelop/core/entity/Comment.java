package com.example.scheduledevelop.core.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne()
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Comment(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public void setSchedule(Schedule schedule){
        this.schedule = schedule;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public void updateComment(String content){
        this.content = content;
    }
}
