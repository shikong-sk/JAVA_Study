package cn.skcks.mediator.interfacePackage;

public interface Mediator {
	void register(String departmentName, Department department);

	void command(String departmentName);
}
