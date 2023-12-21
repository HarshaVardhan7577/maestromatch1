package com.stackroute.contentmanagementservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "ReferenceMaterials")
public class ReferenceMaterial {

	@Transient
	public static final String SEQUENCE_NAME="refmat_sequence";
    @Id 
    private int id;
    private int courseId;
    private String title;
    private String content;
    private String reflinks;

	public String getReflinks() {
		return reflinks;
	}

	public void setReflinks(String reflinks) {
		this.reflinks = reflinks;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}