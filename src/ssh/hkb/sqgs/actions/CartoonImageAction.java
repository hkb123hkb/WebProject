package ssh.hkb.sqgs.actions;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import ssh.hkb.sqgs.entities.CartoonImage;
import ssh.hkb.sqgs.services.CartoonImageService;
import ssh.hkb.sqgs.tools.PageUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class CartoonImageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CartoonImageService cartoonImageService;
	
	private PageUtil<CartoonImage> pageUtil;
	private Gson gson;
	private String data;
	private Integer infoId;
	private Integer currentPage;
	private Integer pageSize;
	
	public void setCartoonImageService(CartoonImageService cartoonImageService) {
		this.cartoonImageService = cartoonImageService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String listCartoonImageByInfoId() {
		gson = new Gson();

		pageUtil = cartoonImageService.listCartoonImage(infoId, currentPage, pageSize);
		
		if (pageUtil != null && pageUtil.getRows().size() > 0) {
			data = gson.toJson(pageUtil);
//			System.out.println(pageUtil.getRows());
			return "list";
		} 
		
		return ERROR;
	}
}
