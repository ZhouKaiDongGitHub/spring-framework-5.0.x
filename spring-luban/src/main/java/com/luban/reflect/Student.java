package com.luban.reflect;

public class Student {
	private Integer studentId;
	private User user;

	@Override
	public String toString() {
		return "StudentId:"+studentId+"  User:"+user;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
