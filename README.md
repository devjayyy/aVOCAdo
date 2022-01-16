# aVOCAdo
데이터베이스 프로그래밍, 웹 응용 프로그램 미니 프로젝트 과제 : 영어 단어 리스트

#1. Description

aVOCAdo는 사용자의 영어단어 학습을 위한 웹 응용 프로그램이다. 
- 사용자에게 필요한 단어를 사용자 스스로 단어장에 추가함으로써 영어단어를 암기할 수 있도록 도와준다. 
- 사용자가 스터디를 만들어 스터디원을 모집해 더 능동적으로 영어단어를 학습하도록 유도한다.


#2. Development Environment
- Oracle SQL Developer @21.2.1.204
- Apache9 Server
- java
- Eclipse IDE for Enterprise Java and Web Developers


#3. 필요한 사전 설정

  3.1. Database connection parameter를 다음과 같이 설정한다. 
  - db.driver=oracle.jdbc.driver.OracleDriver
  - db.url=jdbc:oracle:thin:@202.20.119.117:1521:orcl
  - db.username=dbpro0208
  - db.password=dbp08

#4. 테스트용 ID/PW

4.1. 관리자 모드
- ID : admin
- PW : admin

4.2. 사용자 모드
- ID : avocado
- PW : avocado

#5. 이용방법
 
5.1. index.jsp로 처음 실행한다. 

5.2. 관리자는 관리자 id/pw, 사용자는 사용자 id/pw로 로그인 한다. 

5.3.　로그인 한 경우,
 
 5.3.1. 사용자 관리 - 사용자 목록, 사용자 추가
  - 사용자 목록에서 사용자 전체 리스트를 확인한다.
  - 사용자 이름을 클릭하면 사용자 정보를 조회할 수 있다.
  - 관리자는 사용자 정보를 수정, 삭제할 수 있다.
  - 스터디 이름을 클릭하면 스터디 정보를 조회할 수 있다. 
  - 관리자는 스터디 정보를 수정할 수 있다.
  - 사용자 추가에서 사용자를 추가한다.
 
 5.3.2. 스터디 관리 - 스터디 목록, 스터디 추가
  - 스터디 목록에서 스터디 전체 리스트를 확인한다.
  - 스터디 이름을 클릭하면 스터디 정보를 조회할 수 있다. 
  
 5.3.3. 단어 관리 - 단어 목록
  - 전체 단어 리스트를 조회할 수 있다.
  - 단어를 클릭하면 단어 정보를 조회할 수 있다.
  - 단어장에 추가를 클릭하면 해당 단어가 단어장으로 추가된다.
  
 5.3.4. 단어장 관리 - 단어 목록
  - 단어장에 추가된 단어 리스트를 조회할 수 있다.

5.3.5 로그아웃
