package ssh.hkb.sqgs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssh.hkb.sqgs.dao.BaseDao;
import ssh.hkb.sqgs.dao.StoryDao;
import ssh.hkb.sqgs.entities.Story;
import ssh.hkb.sqgs.tools.PageUtil;

@Repository
public class StoryDaoImpl extends BaseDao implements StoryDao {
	private String hql = null;
	PageUtil<Story> pageUtil = null;
	Story story = null;

	@Override
	public Story saveOrUpdateStory(Story story) {
		getSession().saveOrUpdate(story);
		return story;
	}

	@Override
	public Story deleteStory(Integer id) {
		story = (Story)getSession().get(Story.class, id);
		
		if (null != story) {
			hql = "DELETE FROM Story s WHERE s.id = :id";
			getSession().createQuery(hql).setInteger("id", id);
		}
		
		return story;
	}

	@Override
	public Story getStory(Integer id) {
		return (Story)getSession().get(Story.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<Story> listStoryByKind(String kind, Integer currentPage, Integer pageSize) {
		pageUtil = new PageUtil<Story>();
		hql = "FROM Story s WHERE s.kind = :kind";
		
		Integer count = ((Long)getSession()
						.createQuery("SELECT COUNT(*) FROM Story s WHERE s.kind = :kind")
						.setString("kind", kind)
						.iterate()
						.next())
						.intValue();
		Integer pageCount = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		List<Story> list = (List<Story>)getSession().createQuery(hql)
							.setString("kind", kind)
							.setFirstResult((currentPage - 1) * pageSize)
							.setMaxResults(pageSize)
							.list();
		
		pageUtil.setCurrentPage(currentPage);// 设置当前页码
		pageUtil.setPageSize(pageSize);// 设置每页显示记录数
		pageUtil.setCount(count);// 设置总记录数
		pageUtil.setPageCount(pageCount);// 设置总页数 
		pageUtil.setRows(list);// 设置当前页记录数据
		
		return pageUtil;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<Story> listStoryByTitle(String title, Integer currentPage, Integer pageSize) {
		pageUtil = new PageUtil<Story>();
		hql = "FROM Story s WHERE s.title LIKE '%" + title + "%'";
		
		Integer count = ((Long)getSession()
						.createQuery("SELECT COUNT(*) FROM Story s WHERE s.title LIKE '%" + title + "%'")
						.iterate()
						.next())
						.intValue();
		Integer pageCount = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		List<Story> list = (List<Story>)getSession().createQuery(hql)
							.setFirstResult((currentPage - 1) * pageSize)
							.setMaxResults(pageSize)
							.list();
		
		pageUtil.setCurrentPage(currentPage);// 设置当前页码
		pageUtil.setPageSize(pageSize);// 设置每页显示记录数
		pageUtil.setCount(count);// 设置总记录数
		pageUtil.setPageCount(pageCount);// 设置总页数 
		pageUtil.setRows(list);// 设置当前页记录数据
		
		return pageUtil;
	}

}