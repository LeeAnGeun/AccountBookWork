package main;

import java.util.Calendar;
import java.util.Scanner;

import dto.MemberDto;

public class AccountManage {
	Scanner sc = new Scanner(System.in);
	
	String Menu[] = {"1. 추가 ", "2. 삭제", "3. 검색", "4. 수정", "5. 모두 출력", "6. 종료"};
	MemberDto mDto[] = new MemberDto[100]; // 저장할  정보 
	int searchNum;
	int mCount = 0;
	int sCount = 0;
	String date;
	
	public void choiceManu() {
		boolean b= true;
		while(b) {
			// Menu
			System.out.println("==Manu==");
			for (int i = 0; i < Menu.length; i++) {
				System.out.println(Menu[i]);
			}
			// 입력 1_6
			int worknum;          // Menu 선택을 위한 변수
			System.out.print("항목선택 : ");
			worknum = sc.nextInt();
			System.out.println("===============");
			
			switch(worknum) {  // 해당 Menu로 가기 위한 switch 문
				case 1:
					intsert();  // 추가
					mCount++;
					break;
				case 2:
					delete();  // 삭제 
					break;
				case 3:
					search();  // 검색
					break;
				case 4:
					cerrect();  // 수정
					break;
				case 5: 
					output();  // 모두 보기
					break;
				case 6:
					System.out.println("친구저장하기를 종료합니다");  // 종료
					b = false;
					break; 	
			}
			
		}
	}
	
	void intsert() {
		
		while(true) {      
			mDto[mCount] = new MemberDto();
			
			if(mDto[mCount].getDate() != null ) {  
				System.out.println("이미 저장되어 있습니다. 다른 번호를 선택해 주십시오.");
				continue;
			}
			else {  
				System.out.print("날짜 : ");
				mDto[mCount].setDate();
				System.out.println(mDto[mCount].getDate());
				System.out.print("용도 : ");
				mDto[mCount].setUse(sc.next());
				System.out.print("분류(수입/지출) : ");
				mDto[mCount].setClassify(sc.next());
				System.out.print("금액 : ");
				mDto[mCount].setMoney(sc.next());
				System.out.print("내용 : ");
				mDto[mCount].setMemo(sc.next());
				
				break;
			}
		}
		System.out.println("==================");
	}
	
	void delete() {
		search();
		
		int a_choice;
		System.out.print("삭제하려는 번호를 고르세요 : ");
		a_choice =sc.nextInt();
		
		mDto[a_choice].setUse(null);
		mDto[a_choice].setClassify(null);
		mDto[a_choice].setMoney(null);
		mDto[a_choice].setMemo(null);
		
		
	}
	
	void search() {
		
		System.out.print("검색할 데이터의 날짜는 무엇입니까? ");
		date = sc.next();
		searchNum = 0;

		while(true) {
			searchNum = searchMember(date, searchNum);

			
			if(searchNum == -1) {
				System.out.println("해당 번호에는 아무런 정보가 없거나 더 이상 찾을 정보가 없습니다");
				break;
			} 
			else {
				System.out.println(searchNum + "번");
				System.out.print("날짜");
				System.out.println(mDto[searchNum].getDate());
				System.out.print("용도");
				System.out.println(mDto[searchNum].getUse());
				System.out.print("분류(수입/지출)");
				System.out.println(mDto[searchNum].getClassify());
				System.out.print("금액");
				System.out.println(mDto[searchNum].getMoney());
				System.out.print("내용");
				System.out.println(mDto[searchNum].getMemo());
				System.out.println("-------------------------");
				searchNum += 1;
			}
		}
	}
	
	void cerrect() {
		search();
		
		int a_choice;
		System.out.print("수정하려는 번호를 고르세요 : ");
		a_choice =sc.nextInt();
		
		System.out.println("날짜 수정 : ");
		mDto[a_choice].setDate();
		System.out.print("사용 수정 : ");
		mDto[a_choice].setUse(null);
		mDto[a_choice].setUse(sc.next());
		System.out.print("용도 수정 : ");
		mDto[a_choice].setClassify(null);
		mDto[a_choice].setClassify(sc.next());
		System.out.print("금액 수정 : ");
		mDto[a_choice].setMoney(null);
		mDto[a_choice].setMoney(sc.next());
		System.out.print("메모 수정 : ");
		mDto[a_choice].setMemo(null);
		mDto[a_choice].setMemo(sc.next());
		
	}
	
	void output() {
		
		for (int i = 0; i < mDto.length; i++) {
			if(mDto[i] == null) {
				continue;
			}
			else {
			System.out.println(i + "번 " + mDto[i].toString());
			}
		}
	}
	
	int searchMember(String date, int searchNum) {
		
		for (int i = searchNum; i < mDto.length; i++) {
			if(mDto[i] == null) {
				searchNum = -1;
				continue;
			}
			if(date.equals(mDto[i].getDate())) {
				searchNum = i;
				break;
			}
		}
		return searchNum;
	}
	
}

