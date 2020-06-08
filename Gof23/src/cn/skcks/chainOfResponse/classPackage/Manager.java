package cn.skcks.chainOfResponse.classPackage;

/*
	经理
 */
public class Manager extends Leader {
	public Manager(String name) {
		super(name);
	}

	@Override
	public void request(LeaveRequest leaveRequest) {
		if (leaveRequest.getDay() < 10) {
			System.out.println(
					"经理："
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
