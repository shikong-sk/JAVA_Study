package cn.skcks.dynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;

public class DynamicCompile {
	public static void main(String[] args) {

		String code = "public class TestCompile{\r\n" +
				"    public static void main (String[] args){\r\n" +
				"        System.out.println(\"TestCompile：Hello World !\");\r\n" +
				"    }\r\n" +
				"}";

		String path = System.getProperty("user.dir") + "/src/cn/skcks/dynamicCompile/TestCompile.java";
		path = path.replace("/",File.separator).replace("\\",File.separator);

		// 通过 IO流 将代码写入临时文件 然后进行动态编译
		System.out.println(code);
		System.out.println("写入文件:" + path);
		try {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path)));

			bufferedOutputStream.write(code.getBytes(StandardCharsets.UTF_8));

			bufferedOutputStream.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}


		// 动态编译
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

		int res = javaCompiler.run(null,null,null,path);
		if(res == 0)
		{
			System.out.println("编译成功");
		}
		else{
			System.out.println("编译失败");
		}

		// 通过 Runtime.getRuntime() 运行编译好的类
//		String classPath = path.substring(0,path.lastIndexOf(File.separator));
//		String className = path.substring(path.lastIndexOf(File.separator) + 1 ,path.lastIndexOf("."));
//		Runtime runtime = Runtime.getRuntime();
//		try {
//			Process process = runtime.exec("java -cp \"" + classPath + "\" " + className);
//
//			InputStream inputStream = process.getInputStream();
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//			String info;
//			while ((info = bufferedReader.readLine()) != null)
//			{
//				System.out.println(info);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// 通过反射运行编译好的类
		try{
			URL[] urls = new URL[]{new URL("file:/" + path)};
			URLClassLoader classLoader = new URLClassLoader(urls);

			@SuppressWarnings("rawtypes")
			Class clz = classLoader.loadClass(path.substring(path.lastIndexOf(File.separator) + 1 ,path.lastIndexOf(".")));

			@SuppressWarnings("unchecked")
			Method main =  clz.getMethod("main",String[].class);
			// 调用静态对象无需传入 obj 参数 为 null 即可
			// 传入数组需转换为 Object 对象
			main.invoke(null, (Object) new String[]{});


		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
