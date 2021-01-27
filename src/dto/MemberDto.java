package dto;

import java.util.Calendar;

public class MemberDto {
	Calendar cal = Calendar.getInstance();
	
	private String date;
	private String use;
	private String classify;
	private String money;
	private String memo;
	


	public String getDate() {
		return date;
	}

	public void setDate() {
		String month = Integer.toString(cal.get(Calendar.MONTH) +1); // Calendar.MONTH의 범위는 0 ~ 11이다.
		String day = Integer.toString(cal.get(Calendar.DATE));
		this.date = month + "/"+ day;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "MemberDto [date=" + date + ", use=" + use + ", classify=" + classify + ", money=" + money + ", memo="
				+ memo + "]";
	}

}
