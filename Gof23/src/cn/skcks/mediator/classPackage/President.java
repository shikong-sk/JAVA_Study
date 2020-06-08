package cn.skcks.mediator.classPackage;

import cn.skcks.mediator.interfacePackage.Department;
import cn.skcks.mediator.interfacePackage.Mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {

	private final Map<String,Department> map = new HashMap<>();

	@Override
	public void register(String departmentName, Department department) {
		map.put(departmentName,department);
	}

	@Override
	public void command(String departmentName) {
		map.get(departmentName).selfAction();
	}
}
