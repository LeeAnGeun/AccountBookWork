package main;

public class MainClass {

	public static void main(String[] args) {
		/*
			가계부
			
			날짜, 용도, 분류(수입/지출), 금액, 내용
			date use classify    money memo
			
			추가
			삭제
			검색
			수정
			모두 출력
			종료
		 */
		
		AccountManage aManage = new AccountManage();
		
		aManage.choiceManu();
	}

}
