package ssh.hkb.sqgs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssh.hkb.sqgs.dao.BaseDao;
import ssh.hkb.sqgs.dao.CartoonInfoDao;
import ssh.hkb.sqgs.entities.CartoonInfo;
import ssh.hkb.sqgs.tools.PageUtil;

@Repository
public class CartoonInfoDaoImpl extends BaseDao implements CartoonInfoDao {
	private String hql;
	
	@Override
	public CartoonInfo savaOrUpdateCTInfo(CartoonInfo info) {
		getSession().saveOrUpdate(info);
		return info;
	}

	@Override
	public CartoonInfo deleteCTInfo(Integer id) {
		CartoonInfo info = (CartoonInfo)getSession().get(CartoonInfo.class, id);
		
		if (null != info) {
			hql = "DELETE FROM CartoonInfo c WHERE c.id = :id";
			getSession().createQuery(hql);
		}
		
		return info;
	}

	@Override
	public CartoonInfo getCTInfo(Integer id) {
		return (CartoonInfo)getSession().get(CartoonInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<CartoonInfo> listCTInfo(Integer currentPage,
			Integer pageSize) {
		PageUtil<CartoonInfo> pageUtil = new PageUtil<CartoonInfo>();
		hql = "FROM CartoonInfo";
		
		Integer count = ((Long)getSession()
						.createQuery("SELECT COUNT(*) FROM CartoonInfo")
						.iterate()
						.next())
						.intValue();
		Integer countPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		List<CartoonInfo> list = (List<CartoonInfo>)getSession().createQuery(hql)
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
