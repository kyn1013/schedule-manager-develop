CREATE TABLE member
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '회원 식별자',
    name       VARCHAR(200) NOT NULL COMMENT '이름',
    email      VARCHAR(50) NOT NULL COMMENT '이메일',
    password   VARCHAR(50) NOT NULL COMMENT '비밀번호',
    created_at TIMESTAMP NOT NULL COMMENT '작성일',
    updated_at TIMESTAMP NOT NULL COMMENT '수정일'
);

CREATE TABLE schedule
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    member_id  BIGINT COMMENT '작성자 식별자',
    title      VARCHAR(200) NOT NULL COMMENT '제목',
    content    TEXT NOT NULL COMMENT '일정 내용',
    created_at TIMESTAMP NOT NULL COMMENT '작성일',
    updated_at TIMESTAMP NOT NULL COMMENT '수정일',
    FOREIGN KEY (member_id) REFERENCES member(id)
);