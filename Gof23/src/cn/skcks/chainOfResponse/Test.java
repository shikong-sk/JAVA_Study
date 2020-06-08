package cn.skcks.chainOfResponse;

import cn.skcks.chainOfResponse.classPackage.*;

/*
	责任链模式
 */
public class Test {
	public static void main(String[] args) {
		Leader leader = new Director("时间");
		Leader leader2 = new Manager("时光");
		Leader leader3 = new GeneralManager("时空");

		// 链表方式实现责任链
		// 组织责任链
		leader.setNextLeader(leader2);
		leader2.setNextLeader(leader3);

		// 开始请假操作
		LeaveRequest request = new LeaveRequest("熊猫",5,"爬山");
		leader.request(request);

		LeaveRequest request2 = new LeaveRequest("猫熊",15,"潜水");
		leader.request(request2);

		LeaveRequest request3 = new LeaveRequest("熊",31,"吔");
		leader.request(request3);

	}
}
