package cn.skcks.scriptEngine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
	脚本引擎

	使用 脚本引擎 执行 JavaScript代码
 */
public class TestRhino {
	public static void main(String[] args){
		// 创建脚本引擎对象
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine engine = scriptEngineManager.getEngineByName("js");

		// 定义变量 存储到引擎上下文中
		engine.put("name","");
		String str = "var user = {name:'时空旅行者'};";
		str += "print('user.name = ' + user.name);";

		// 执行脚本
		try {
			engine.eval(str);
			engine.eval("name = '时空'");

			System.out.println("name = " + engine.get("name"));

			// 定义函数
			String addFun = "function add(a,b){ return a+b;}";
			engine.eval(addFun);

			// 获取函数调用接口
			Invocable addFunInvocable = (Invocable) engine;
			// 执行 js 函数
			Object res = addFunInvocable.invokeFunction("add", 0.1,0.2);
			System.out.println(res);

//			 导入 java 包,使用包中 java 的类
			// JDK 6 写法
//			String javaPackage = "importPackage(java.util);";
//			engine.eval(javaPackage);

			// JDK 6 以上版本写法
			engine.eval("var list = java.util.Arrays.asList([\"时空\",\"时间\",\"时光\"])");

			@SuppressWarnings("unchecked")
			List<String> list = (List<String>)engine.get("list");
			for(String i:list)
			{
				System.out.println(i);
			}


			// 执行 js 文件
			URL jsPath = TestRhino.class.getClassLoader().getResource("cn/skcks/scriptEngine/Test.js");
			assert jsPath != null;
			System.out.println(URLDecoder.decode(jsPath.getPath(),"UTF-8"));
			FileReader fileReader = new FileReader(URLDecoder.decode(jsPath.getPath(),"UTF-8"));
			engine.eval(fileReader);
			fileReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
