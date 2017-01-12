package model;

public class OutPutMessage {
	private String name;
	private String content;
	private String time;
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public OutPutMessage(){
		
	}
	
	public OutPutMessage(final String path, final String name, final String content, final String time){
		this.path = path;
		this.name = name;
		this.content = content;
		this.time = time;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
