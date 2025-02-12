package com.example.scheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@EnableJpaAuditing // Auditing 기능(entity 생성, 수정 시간 자동으로 기록) 활성화
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO) // Page 객체에서 필요한 부분만 조회할 수 있음
@SpringBootApplication
public class ScheduleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopApplication.class, args);
    }

}
