package cn.skcks.chainOfResponse.classPackage;

/*
	主任
 */
public class Director extends Leader {
	public Director(String name) {
		super(name);
	}

	@Override
	public void request(LeaveRequest leaveRequest) {
		if (leaveRequest.getDay() < 3) {
			System.out.println(
					"主任："
							+ name
							+ " 批准 " + leaveRequest.getName()
							+ " 请假 " + leaveRequest.getDay()
							+ " 天，请假理由:" + leaveRequest.getReason());
		} else {
			if (this.nextLeader != null) {
				this.nextLeader.request(leaveRequest);
			}
		}
	}
}
