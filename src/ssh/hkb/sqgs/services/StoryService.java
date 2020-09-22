package ssh.hkb.sqgs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssh.hkb.sqgs.dao.StoryDao;
import ssh.hkb.sqgs.entities.Story;
import ssh.hkb.sqgs.tools.PageUtil;

@Service
public class StoryService {
	
	@Autowired
	private StoryDao storyDao;
	
	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}
	
	/**
	 * 根据分类查询故事（分页查询）
	 * @param kind 故事种类
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return 
	 */
	public PageUtil<Story> listStoryByKind(String kind, Integer currentPage, Integer pageSize) {
		return storyDao.listStoryByKind(kind, currentPage, pageSize);
	}
	
	/**
	 * 根据标题查询故事（分页查询、模糊查询）
	 * @param title 故事标题
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return
	 */
	public PageUtil<Story> listStoryByTitle(String title, Integer currentPage, Integer pageSize) {
		return storyDao.listStoryByTitle(title, currentPage, pageSize);
	}
	
	/**
	 * 根据id查询故事信息
	 * @param id 故事id
	 * @return
	 */
	public Story getStory(Integer id) {
		return storyDao.getStory(id);
	}

}
