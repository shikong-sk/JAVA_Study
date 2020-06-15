package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_score {

	private String studentId;
	private String score;
	private String courseName;
	private String teacherId;
	private Integer flag;
	private String teacherName;
	private String studentName;
	private String courseId;

	public String getStudentId(){
		return studentId;
	}
	public String getScore(){
		return score;
	}
	public String getCourseName(){
		return courseName;
	}
	public String getTeacherId(){
		return teacherId;
	}
	public Integer getFlag(){
		return flag;
	}
	public String getTeacherName(){
		return teacherName;
	}
	public String getStudentName(){
		return studentName;
	}
	public String getCourseId(){
		return courseId;
	}
	public void setStudentId(String studentId){
		this.studentId = studentId;
	}
	public void setScore(String score){
		this.score = score;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}
	public void setFlag(Integer flag){
		this.flag = flag;
	}
	public void setTeacherName(String teacherName){
		this.teacherName = teacherName;
	}
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	public void setCourseId(String courseId){
		this.courseId = courseId;
	}
}
