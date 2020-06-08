package cn.skcks.chainOfResponse.classPackage;

/*
	总经理
 */
public class GeneralManager extends Leader {
	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void request(LeaveRequest leaveRequest) {
		if (leaveRequest.getDay() < 30) {
			System.out.println(
					"总经理："
							+ name
							+ " 批准 " + leaveRequest.getName()
							+ " 请假 " + leaveRequest.getDay()
							+ " 天，请假理由:" + leaveRequest.getReason());
		} else {
			System.out.println("时间过长 不批准");
		}
	}
}
