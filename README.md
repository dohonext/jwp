2014년 개발 경험 프로젝트
=========

1. 로컬 개발 환경에 Tomcat 서버를 시작한 후 http://localhost:8080으로 접근하면 질문 목록을 확인할 수 있다. http://localhost:8080으로 접근해서 질문 목록이 보이기까지의 소스 코드의 호출 순서 및 흐름을 설명하라.

## 1. http://localhost:8080으로 접근하면 web.xml의 welcome file 에 의해 index.jsp가 실행
## 2. index.jsp 의 스크립틀릿에 의해 /list.next로 redirection
### (1) (core.mvc.RequestMapping 에서 /list.next가 ListController()로 매핑되어있)
## 3. next.controller.ListController의 excute() 메서드 실행
### (1) QuestionDao questionDao 생성
### (2) questionDao.findAll() 메서드 실행
#### - 쿼리문 실행하고 jdbcTemplate.list(sql, rm) return
## 4. Dao에서 리턴된 jdbcTemplate.list(sql, rm)를 ListController의 멤버 question에 받아옴.
### (1) ModelAndView mav 생성하여 addObject("questions", questions)메서드로 questions에 "questions"를 setAttribute
### (2) questions를 list.jsp로 redirect 하여 list.jsp에서 foreach문을 통해 뿌려준다.
    
