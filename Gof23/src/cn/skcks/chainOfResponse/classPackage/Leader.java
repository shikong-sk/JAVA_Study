package cn.skcks.chainOfResponse.classPackage;

/*
	抽象类
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;

	public Leader(String name) {
		this.name = name;
	}

	// 设定下一级对象
	public void setNextLeader(Leader nextLeader){
		this.nextLeader = nextLeader;
	}

	// 请求处理方法
	public abstract void request(LeaveRequest leaveRequest);
}
