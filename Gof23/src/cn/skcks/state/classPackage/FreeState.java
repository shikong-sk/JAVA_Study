package cn.skcks.state.classPackage;

import cn.skcks.state.interfacePackage.State;

public class FreeState implements State {
	@Override
	public void handle() {
		System.out.println("空闲");
	}
}
