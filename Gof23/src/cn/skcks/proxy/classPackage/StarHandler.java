package cn.skcks.proxy.classPackage;

import cn.skcks.proxy.interfacePackage.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
	Star star;

	public StarHandler(Star star) {
		this.star = star;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object object = null;

		if (method.getName().equals("sing"))
		{
			object = method.invoke(star,args);
		}

		return object;
	}
}
