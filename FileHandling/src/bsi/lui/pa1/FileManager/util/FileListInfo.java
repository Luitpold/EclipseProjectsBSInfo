package bsi.lui.pa1.FileManager.util;

public class FileListInfo {
	private String name;
	private int level;
	
	public FileListInfo(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLevel(){
		return level;
	}
}
