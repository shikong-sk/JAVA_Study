package cn.skcks.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    自定义注解   JDK5 之后引入

    元注解：
    @Target 用于描述注解的使用范围 即被描述的注解可以用于什么地方
        ElementType
            PACKAGE         包
            TYPE            类、接口、枚举、Annotation 类
            CONSTRUCTOR     用于描述构造器
            FIELD           用于描述类成员
            METHOD          用于描述方法
            LOCAL_VARIABLE  用于描述局部变量
            PARAMETER       用于描述参数
    用法：@Target(value = {ElementType.PACKAGE,ElementType.TYPE})

    @Retention 注解保留策略 表示需要在什么级别保留注解信息
        RetentionPolicy
            SOURCE  在源文件中保留
            CLASS   在 class 文件中保留
            RUNTIME 在运行时保留 可以被反射机制读取

    @Documented
    @Inherited
 */

@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotationSimple {
    // 注解元素
    // 注解元素必须有值 通常使用 default 设置默认值  通常使用 "" -1 等 表示不存在
    String[] value();
}
