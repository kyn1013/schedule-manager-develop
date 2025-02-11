package com.example.scheduledevelop.member.repository;

import com.example.scheduledevelop.core.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
