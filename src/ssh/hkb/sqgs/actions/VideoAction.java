package ssh.hkb.sqgs.actions;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import ssh.hkb.sqgs.entities.Video;
import ssh.hkb.sqgs.services.VideoService;
import ssh.hkb.sqgs.tools.PageUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class VideoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private VideoService videoService;

	private Gson gson;
	private PageUtil<Video> pageUtil;
	private String data;
	private Integer currentPage;
	private Integer pageSize;

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
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

	public String listVideos() {
		gson = new Gson();

		pageUtil = videoService.listVideos(currentPage, pageSize);

		if (pageUtil != null && pageUtil.getRows().size() > 0) {
			data = gson.toJson(pageUtil);
//			System.out.println(pageUtil.getRows());
			return "list";
		} 

		return ERROR;
	}
}
