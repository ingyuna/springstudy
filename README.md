# TestProgram1 결함 조치 내용

1. lombok 디펜던시를 pop.xml에서 추가해준다.
2. BeanConfiguration.java 파일에서 @Configuration이 빠져있어서 추가해줬다.
3. board.xml에서 mapper의 namespace가 board로 되어있어서 BoardDAO로 수정해줬다.
4. 게시판으로 이동할 수 있는 index.jsp가 없어서 추가해줬다.
5. BoardDAO.java에는 selectBoardCount가 있는데 board.xml에서 sql 작성문이 빠져있어서 추가해줬다.
6. BoardDAO에서 ArrayList가 아니라 list로 수정.
7. insert.jsp에서 <form>의 아이디가 없고 위에 f만 있어서, 아이디를 추가해줬다.
