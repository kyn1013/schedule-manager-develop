package com.example.scheduledevelop.core.entity;

import jakarta.persistence.*;
import lombok.Getter;

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

    public Schedule(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Schedule() {
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
