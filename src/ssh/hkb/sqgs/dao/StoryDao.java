package ssh.hkb.sqgs.dao;

import ssh.hkb.sqgs.entities.Story;
import ssh.hkb.sqgs.tools.PageUtil;

/**
 * 故事类接口
 */
public interface StoryDao {
	
	/**
	 * 新增或修改一条故事信息
	 * @param story 要新增或修改的故事对象
	 * @return 新增或修改后的故事对象
	 */
	Story saveOrUpdateStory(Story story);
	
	/**
	 * 删除一条故事信息
	 * @param id 要删除的故事的id
	 * @return 删除的故事对象
	 */
	Story deleteStory(Integer id);
	
	/**
	 * 查询一条故事信息
	 * @param id 要查询的故事的id
	 * @return 查询到的故事对象
	 */
	Story getStory(Integer id);
	
	/**
	 * 根据分类查询故事（分页查询）
	 * @param kind 故事种类
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return 
	 */
	PageUtil<Story> listStoryByKind(String kind, Integer currentPage, Integer pageSize);
	
	/**
	 * 根据标题查询故事（分页查询、模糊查询）
	 * @param title 故事标题
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return
	 */
	PageUtil<Story> listStoryByTitle(String title, Integer currentPage, Integer pageSize);

}
