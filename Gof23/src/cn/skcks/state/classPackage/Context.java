package cn.skcks.state.classPackage;


import cn.skcks.state.interfacePackage.State;

/*
	需要改变状态的对象
 */
public class Context {
	private State state;

	public void setState(State state) {
		this.state = state;
		System.out.println("状态变更");
		state.handle();
	}
}
