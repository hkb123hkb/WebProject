package ssh.hkb.sqgs.entities;
/**
 * 漫画图片类
 */
public class CartoonImage {
	
	private Integer id; // 漫画id 
	
	private String image; // 漫画（路径）
	private Integer pageNum; // 漫画页码
	
	private CartoonInfo info; // 外键，关联的漫画信息

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public CartoonInfo getInfo() {
		return info;
	}

	public void setInfo(CartoonInfo info) {
		this.info = info;
	}

	public CartoonImage() {

	}

	/**
	 * 
	 * @param id 漫画图片id
	 * @param image 漫画图片
	 * @param pageNum 漫画页码
	 * @param info 关联的漫画信息，外键
	 */
	public CartoonImage(Integer id, String image, Integer pageNum,
			CartoonInfo info) {
		super();
		this.id = id;
		this.image = image;
		this.pageNum = pageNum;
		this.info = info;
	}

	@Override
	public String toString() {
		return "CartoonImage [id=" + id + ", image=" + image + ", pageNum="
				+ pageNum + "]";
	}

}
