## 일정관리 시스템 API
| **기능**          | **HTTP Method** | **URI**               | **Request**           | **Response**          |
|--------------------|-----------------|-----------------------|-----------------------|-----------------------|
| 회원 가입         | POST            | /auth/signup          | SignupRequestDto       | SignupResponseDto      |
| 로그인            | POST            | /auth/login           | LoginRequestDto        | LoginResponseDto       |
| 로그아웃          | POST            | /auth/logout          |                         | 성공 : 200 ok          |
| 회원 조회         | GET             | /members/{id}         |                         | MemberResponseDto        |
| 회원 전체 조회    | GET             | /members              |                         | List<MemberResponseDto>      |
| 회원 수정         | PATCH           | /members/{id}         | MemberUpdateRequestDto  | MemberResponseDto       |
| 회원 삭제         | DELETE          | /members/{id}         |                        | 성공 : 200 ok / 실패 : 404      |
| 일정 생성         | POST            | /schedules            | ScheduleSaveRequestDto   | ScheduleResponseDto       |
| 일정 조회         | GET             | /schedules/{id}       |                           | ScheduleResponseDto         |
| 일정 전체 조회    | GET             | /schedules            | Query : page: 페이지번호,size: 페이지 사이즈                       | List<SchedulePageResponseDto>        |
| 일정 수정         | PATCH           | /schedules/{id}       | ScheduleUpdateRequestDto       |  ScheduleResponseDto     |
| 일정 삭제         | DELETE          | /schedules/{id}       |                       | 성공 : 200 ok / 실패 : 404       |
| 댓글 등록         | POST            | /comments             | CommentSaveRequestDto        | CommentResponseDto       |
| 댓글 조회         | GET             | /comments/{id}        |                           | CommentResponseDto        |
| 댓글 전체 조회    | GET             | /comments             |           | List<CommentResponseDto>        |
| 댓글 수정         | PATCH           | /comments/{id}        | CommentUpdateRequestDto        | CommentResponseDto       |
| 댓글 삭제         | DELETE          | /comments/{id}        |      | 성공 : 200 ok / 실패 : 404       |


---
## ERD
![Image](https://github.com/user-attachments/assets/a786b6b6-9b0d-48cd-b463-1bc59c284846)
---

## 기능

### 1. 회원 관리 기능
- **회원 가입**
- **회원 조회 및 수정**
- **회원 삭제**
- **로그인 및 로그아웃**: Cookie/Session을 활용한 로그인 및 로그아웃 기능
- **비밀번호 암호화**: BCrypt를 사용하여 회원 비밀번호 암호화

### 2. 일정 관리 기능
- **일정 생성**: 일정 추가
- **일정 조회**: 특정 일정을 조회하거나, 전체 일정을 페이징 처리하여 조회
- **일정 수정 및 삭제**

### 3. 댓글 관리 기능
- **댓글 작성**: 특정 일정에 댓글 추가
- **댓글 조회**: 특정 댓글 또는 전체 댓글을 조회
- **댓글 수정 및 삭제**

---

## 기술 스택

- **Backend**: Spring Boot, JPA
- **Database**: MySQL
- **Authentication**: Cookie/Session 기반 인증
- **Password Encryption**: BCrypt
- **API 개발**: RESTful API
- **Exception Handling**: @ExceptionHandler 및 @ControllerAdvice

---
### 로그인 및 회원가입 관련 JSON

##### LoginRequestDto
```json
{
	"email" : string,
	"password" : string
}
```

##### LoginResponseDto
```json
{
	"id" : Long
}
```

##### SignupRequestDto
```json
{
	"memberId": Long,
	"title": string,
	"content": string
}
```

##### SignupResponseDto
```json
{
	"id": Long,
	"author": string,
	"title": string,
	"content": string,
}
```

### 회원 관련 JSON

##### MemberSaveRequestDto
```json
{
   "name": string,
	"email" : string,
	"password" : string
}
```

##### MemberUpdateRequestDto
```json
{
   "name": string,
	"email" : string,
}
```

##### MemberResponseDto
```json
{
    "id": Long,
   "name": string,
	"email" : string,
}
```

### 일정 관련 JSON

##### ScheduleSaveRequestDto
```json
{
	"memberId": Long,
    "title": String,
    "content": String
}
```

##### ScheduleUpdateRequestDto
```json
{
	"memberId": Long,
	"title": string,
	"content": string
}
```

##### ScheduleResponseDto
```json
{
	"id": Long,
	"author": string,
	"title": string,
	"content": string,
}
```

##### ScheduleListResponseDto
```json
[
	{
	"id": Long,
	"content": string,
	“author”: string,
	"title": string,
	},
	{
	"id": Long,
	"content": string,
	“author”: string,
	"title": string,
}
	// ...
]
```

##### SchedulePageResponseDto
```json
{
  {
    "content": [
        {
            "title": "  title1",
            "content": "content1",
            "author": "author1",
            "commentCount": 0,
            "createdAt": "2025-02-13T11:52:05.702314",
            "modifiedAt": "2025-02-13T11:52:05.702314"
        },
        {
            "title": "title2",
            "content": "content2",
            "author": "author2",
            "commentCount": 0,
            "createdAt": "2025-02-13T11:52:10.698909",
            "modifiedAt": "2025-02-13T11:52:10.698909"
        }
    ],
    "page": {
        "size": 3,
        "number": 1,
        "totalElements": 5,
        "totalPages": 2
    }
}
}
```

### 댓글 관련 JSON

##### CommentSaveRequestDto
```json
{
  "scheduleId": "Long",
  "memberId": "Long",
  "comment": "String"
}
```

##### CommentResponseDto
```json
{
  "id": "Long",
  "author": "String",
  "comment": "String"
}
```

##### CommentUpdateRequestDto
```json
{
	"comment": "String"
}
```