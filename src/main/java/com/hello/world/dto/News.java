package com.hello.world.dto;

public class News {
	
	private String title;
	private String originallink;
	private String description;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginallink() {
		return originallink;
	}
	public void setOriginallink(String originallink) {
		this.originallink = originallink;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "News [title=" + title + ", originallink=" + originallink
				+ ", description=" + description + "]";
	}
	
	
	
}
