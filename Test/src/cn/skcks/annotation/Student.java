package cn.skcks.annotation;

@TableAnnotation("ms_student")
public class Student {
    @FieldAnnotation(fieldName = "studentId",fieldType = "char",length = 10)
    private int studentId;
    @FieldAnnotation(fieldName = "studentName",fieldType = "varcher",length = 15)
    private String studentName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
