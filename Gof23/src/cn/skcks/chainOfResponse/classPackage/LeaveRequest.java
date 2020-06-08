package cn.skcks.chainOfResponse.classPackage;

/*
	封装请假基本信息
 */
public class LeaveRequest {
	private String name;
	private int day;
	private String reason;

	public LeaveRequest(String name, int day, String reason) {
		this.name = name;
		this.day = day;
		this.reason = reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
