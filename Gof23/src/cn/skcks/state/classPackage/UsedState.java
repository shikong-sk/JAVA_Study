package cn.skcks.state.classPackage;

import cn.skcks.state.interfacePackage.State;

public class UsedState implements State {
	@Override
	public void handle() {
		System.out.println("正在被使用");
	}
}
