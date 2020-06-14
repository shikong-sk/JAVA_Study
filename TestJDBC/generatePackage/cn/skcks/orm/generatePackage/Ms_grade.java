package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_grade {

	private String departmentName;
	private String majorId;
	private String grade;
	private String departmentId;
	private String majorName;
	private String classNum;

	public String getDepartmentName(){
		return departmentName;
	}
	public String getMajorId(){
		return majorId;
	}
	public String getGrade(){
		return grade;
	}
	public String getDepartmentId(){
		return departmentId;
	}
	public String getMajorName(){
		return majorName;
	}
	public String getClassNum(){
		return classNum;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setMajorId(String majorId){
		this.majorId = majorId;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public void setMajorName(String majorName){
		this.majorName = majorName;
	}
	public void setClassNum(String classNum){
		this.classNum = classNum;
	}
}
