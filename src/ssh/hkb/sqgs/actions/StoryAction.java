package ssh.hkb.sqgs.actions;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import ssh.hkb.sqgs.entities.Story;
import ssh.hkb.sqgs.services.StoryService;
import ssh.hkb.sqgs.tools.PageUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class StoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private StoryService storyService;
	
	private Gson gson;
	private PageUtil<Story> pageUtil;
	private String data;
	private String kind;
	private String title;
	private Integer id;
	private Integer currentPage;
	private Integer pageSize;
	
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
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
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String listStoryByKind() {
		try {
			gson = new Gson();

			pageUtil = storyService.listStoryByKind(kind, currentPage, pageSize);
			
			if (pageUtil != null && pageUtil.getRows().size() > 0) {
				data = gson.toJson(pageUtil);
//				System.out.println(pageUtil.getRows());
				return "list";
			} else {
				pageUtil = storyService
						.listStoryByKind(new String(kind.getBytes("ISO-8859-1"), "UTF-8"), currentPage, pageSize);
				
				if (pageUtil != null && pageUtil.getRows().size() > 0) {
					data = gson.toJson(pageUtil);
					return "list";
				} 
			}
			
			return ERROR;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ERROR;
	}
	
	public String listStoryByTitle() {
		try {
			gson = new Gson();

			pageUtil = storyService.listStoryByTitle(title, currentPage, pageSize);
			
			if (pageUtil != null && pageUtil.getRows().size() > 0) {
				data = gson.toJson(pageUtil);
//				System.out.println(pageUtil.getRows());
				return "list";
			} else {
				pageUtil = storyService
						.listStoryByTitle(new String(title.getBytes("ISO-8859-1"), "UTF-8"), currentPage, pageSize);
				
				if (pageUtil != null && pageUtil.getRows().size() > 0) {
					data = gson.toJson(pageUtil);
					return "list";
				} 
			}
			
			return ERROR;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ERROR;
	}
	
	public String getStory() {
		gson = new Gson();

		Story story = storyService.getStory(id);
		
		if (story != null) {
			data = gson.toJson(story);
//				System.out.println(story);
			return "success";
		} 
		
		return ERROR;
	}
}
