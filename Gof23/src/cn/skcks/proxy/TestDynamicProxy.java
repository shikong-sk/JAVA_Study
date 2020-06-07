package cn.skcks.proxy;

import cn.skcks.proxy.classPackage.RealStar;
import cn.skcks.proxy.classPackage.StarHandler;
import cn.skcks.proxy.interfacePackage.Star;

import java.lang.reflect.Proxy;

/*
	动态代理
 */
public class TestDynamicProxy {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler starHandler = new StarHandler(realStar);

		Star proxyStar = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},starHandler);

		proxyStar.confer();
		proxyStar.bookTicket();
		proxyStar.signContract();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
