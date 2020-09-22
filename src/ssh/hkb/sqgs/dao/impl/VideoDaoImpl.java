package ssh.hkb.sqgs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssh.hkb.sqgs.dao.BaseDao;
import ssh.hkb.sqgs.dao.VideoDao;
import ssh.hkb.sqgs.entities.Video;
import ssh.hkb.sqgs.tools.PageUtil;

@Repository
public class VideoDaoImpl extends BaseDao implements VideoDao {
	
	private String hql;

	@Override
	public Video saveOrUpdateVideo(Video video) {
		getSession().saveOrUpdate(video);
		return video;
	}

	@Override
	public Video deleteVideo(Integer id) {
		Video video = (Video)getSession().get(Video.class, id);
		
		if ( null != video) {
			hql = "DELETE FROM Video v WHERE v.id = :id";
			getSession().createQuery(hql).setInteger("id", id);
		}

		return video;
	}

	@Override
	public Video getVideo(Integer id) {
		return (Video)getSession().get(Video.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<Video> listVideos(Integer currentPage, Integer pageSize) {
		PageUtil<Video> pageUtil = new PageUtil<Video>();
		hql = "FROM Video";
		
		Integer count = ((Long)getSession()
						.createQuery("SELECT COUNT(*) FROM Video")
						.iterate()
						.next())
						.intValue();
		Integer countPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		List<Video> list = (List<Video>)getSession().createQuery(hql)
							.setFirstResult((currentPage - 1) * pageSize)
							.setMaxResults(pageSize)
							.list();
		
		pageUtil.setCurrentPage(currentPage);// 设置当前页码
		pageUtil.setPageSize(pageSize);// 设置每页显示记录数
		pageUtil.setCount(count);// 设置总记录数
		pageUtil.setPageCount(countPage);// 设置总页数 
		pageUtil.setRows(list);// 设置当前页记录数据
		
		return pageUtil;
	}

}
