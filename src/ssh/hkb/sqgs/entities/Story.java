package ssh.hkb.sqgs.entities;
/**
 * 故事类 
 */
public class Story {

	private Integer id; // 故事id

	private String kind; // 故事分类
	private String title; // 故事标题
	private String image; // 故事封面（路径）
	private String story; // 故事

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Story() {
		
	}

	/**
	 * 
	 * @param id 故事id
	 * @param kind 故事种类
	 * @param title 故事标题
	 * @param image 故事封面
	 * @param story 故事
	 */
	public Story(Integer id, String kind, String title, String image,
			String story) {
		this.id = id;
		this.kind = kind;
		this.title = title;
		this.image = image;
		this.story = story;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", kind=" + kind + ", title=" + title
				+ ", image=" + image + ", story=" + story + "]";
	}

}
