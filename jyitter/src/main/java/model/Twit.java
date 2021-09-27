package model;

public class Twit {
	private String name;
	private String content;
	
	private String twitTime;
	
	public Twit() {
		super();
	}
	public Twit(String name, String content, String twitTime) {
		super();
		this.name = name;
		this.content = content;
		this.twitTime = twitTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTwitTime() {
		return twitTime;
	}
	public void setTwitTime(String twitTime) {
		this.twitTime = twitTime;
	}
}
