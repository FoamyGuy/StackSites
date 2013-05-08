package com.makemyandroidapp.example.stacksites;


/*
 * Data object that holds all of our information about a StackExchange Site.
 */
public class StackSite {

	private String name;
	private String link;
	private String about;
	private String imgUrl;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "StackSite [name=" + name + ", link=" + link + ", about="
				+ about + ", imgUrl=" + imgUrl + "]";
	}
}
