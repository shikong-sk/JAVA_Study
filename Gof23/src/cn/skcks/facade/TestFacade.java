package cn.skcks.facade;

import cn.skcks.facade.classPackage.RegisterFacade;

/*
	外观(门面)模式
 */
public class TestFacade {
	public static void main(String[] args) {
		new RegisterFacade().register();
	}
}
