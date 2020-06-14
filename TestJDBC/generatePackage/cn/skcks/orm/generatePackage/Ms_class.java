package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_class {

	private String departmentName;
	private String classId;
	private String majorId;
	private String grade;
	private String departmentId;
	private String majorName;
	private String _Class;
	private String studentNum;
	private String years;

	public String getDepartmentName(){
		return departmentName;
	}
	public String getClassId(){
		return classId;
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
	public String get_Class(){
		return _Class;
	}
	public String getStudentNum(){
		return studentNum;
	}
	public String getYears(){
		return years;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setClassId(String classId){
		this.classId = classId;
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
	public void set_Class(String _Class){
		this._Class = _Class;
	}
	public void setStudentNum(String studentNum){
		this.studentNum = studentNum;
	}
	public void setYears(String years){
		this.years = years;
	}
}
