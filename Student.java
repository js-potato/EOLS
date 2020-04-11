package EOLS;

/**
 * 在线教学系统的学生类
 * 学号，姓名，身份证号，专业，班级，籍贯，家庭住址，专业成绩
 * @author Mr.Joker
 */
public class Student {
	public Student() {
		
	}
	
	public Student(String id, String name, String identity_number, String major, String classs, String hometown, String address, double grade) {
		this.id = id;
		this.name = name;
		this.identity_number = identity_number;
		this.major = major;
		this.classs = classs;
		this.hometown = hometown;
		this.address = address;
		this.grade = grade;
	}

	private String id;
	private String name;
	private String identity_number;
	private String major;
	private String classs;
	private String hometown;
	private String address;
	private double grade;
	
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getIdentity_number() {
		return identity_number;
	}
	void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}
	String getMajor() {
		return major;
	}
	void setMajor(String major) {
		this.major = major;
	}
	String getClasss() {
		return classs;
	}
	void setClasss(String classs) {
		this.classs = classs;
	}
	String getHometown() {
		return hometown;
	}
	void setHometown(String hometown) {
		this.hometown = hometown;
	}
	String getAddress() {
		return address;
	}
	void setAddress(String address) {
		this.address = address;
	}
	double getGrade() {
		return grade;
	}
	void setGrade(double grade) {
		this.grade = grade;
	}
	
}
