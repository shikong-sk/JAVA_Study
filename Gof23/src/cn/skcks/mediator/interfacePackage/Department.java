package cn.skcks.mediator.interfacePackage;

// 同事类接口
public interface Department {
	// 做本部门的事情
	void selfAction();

	// 向上级发出申请
	void outAction();
}
