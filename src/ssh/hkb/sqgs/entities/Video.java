package ssh.hkb.sqgs.entities;
/**
 * 视频类
 */
public class Video {

	private Integer id; // 视频id

	private String title; // 标题
	private String summary; // 简介
	private String video; // 视频（路径）
	private String image; // 视频封面（路径）

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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Video() {

	}
	
	/**
	 * 
	 * @param id 视频id
	 * @param title 标题
	 * @param summary 简介
	 * @param video 视频
	 * @param image 视频封面
	 */
	public Video(Integer id, String title, String summary, String video,
			String image) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.video = video;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", summary=" + summary
				+ ", video=" + video + ", image=" + image + "]";
	}

}
