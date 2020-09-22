package ssh.hkb.sqgs.actions;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import ssh.hkb.sqgs.entities.CartoonInfo;
import ssh.hkb.sqgs.services.CartoonInfoService;
import ssh.hkb.sqgs.tools.PageUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class CartoonInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CartoonInfoService cartoonInfoService;

	private PageUtil<CartoonInfo> pageUtil;
	private Gson gson;
	private String data;
	private Integer currentPage;
	private Integer pageSize;

	public void setCartoonInfoService(CartoonInfoService cartoonInfoService) {
		this.cartoonInfoService = cartoonInfoService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String listCartoonInfo() {
		gson = new Gson();

		pageUtil = cartoonInfoService.listCartoonInfo(currentPage, pageSize);
		
		if (pageUtil != null && pageUtil.getRows().size() > 0) {
			data = gson.toJson(pageUtil);
//			System.out.println(pageUtil.getRows());
			return "list";
		} 
		
		return ERROR;
	}
}
