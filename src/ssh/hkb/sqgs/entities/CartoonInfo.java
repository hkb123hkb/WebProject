package ssh.hkb.sqgs.entities;

import java.util.Set;

/**
 * 漫画信息类
 */
public class CartoonInfo {
	
	private Integer id; // 漫画id
	
	private String title; // 漫画标题
	private String author; // 漫画作者
	private String date; // 漫画发表日期
	private String cover; // 漫画封面
	private String summary; // 漫画简介

	private transient Set<CartoonImage> images; // 外键，漫画图片集

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set<CartoonImage> getImages() {
		return images;
	}

	public void setImages(Set<CartoonImage> images) {
		this.images = images;
	}

	public CartoonInfo() {
		
	}

	/**
	 * 
	 * @param id 漫画信息id
	 * @param title 标题
	 * @param author 作者
	 * @param date 发表时间
	 * @param cover 封面全名称
	 * @param summary 简介
	 * @param images 关联的漫画图片，外键
	 */
	public CartoonInfo(Integer id, String title, String author, String date,
			String cover, String summary, Set<CartoonImage> images) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.cover = cover;
		this.summary = summary;
		this.images = images;
	}

	@Override
	public String toString() {
		return "CartoonInfo [id=" + id + ", title=" + title + ", author="
				+ author + ", date=" + date + ", cover=" + cover + ", summary="
				+ summary + ", images=" + images + "]";
	}

}
