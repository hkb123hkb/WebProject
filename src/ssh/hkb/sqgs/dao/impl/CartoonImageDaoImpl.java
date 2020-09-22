package ssh.hkb.sqgs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssh.hkb.sqgs.dao.BaseDao;
import ssh.hkb.sqgs.dao.CartoonImageDao;
import ssh.hkb.sqgs.entities.CartoonImage;
import ssh.hkb.sqgs.tools.PageUtil;

@Repository
public class CartoonImageDaoImpl extends BaseDao implements CartoonImageDao {
	private String hql;

	@Override
	public CartoonImage saveOrUpdateCTImage(CartoonImage image) {
		getSession().saveOrUpdate(image);
		return image;
	}

	@Override
	public CartoonImage deleteCTImage(Integer id) {
		CartoonImage image = (CartoonImage)getSession().get(CartoonImage.class, id);
		
		if (null != image) {
			hql = "DELETE FROM CartoonImage c WHERE c.id = :id";
			getSession().createQuery(hql).setInteger("id", id);
		}
		
		return image;
	}

	@Override
	public CartoonImage getCTImage(Integer id) {
		return (CartoonImage)getSession().get(CartoonImage.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<CartoonImage> listCTImageByCTInfo(Integer infoId, Integer currentPage, Integer pageSize) {
		PageUtil<CartoonImage> pageUtil = new PageUtil<CartoonImage>();
//		hql = "FROM CartoonImage c left outer join c.info WHERE c.info.id = :id ORDER BY c.pageNum";
		hql = "FROM CartoonImage c WHERE c.info.id = :id ORDER BY c.pageNum";
//		hql = "SELECT * FROM sqgs_cartoonimages WHERE cartooninfos_id = ? ORDER BY cartoonimages_pagenum";
		Integer count = ((Long)getSession()
					.createQuery("SELECT COUNT(*) FROM CartoonImage c left outer join c.info WHERE c.info.id = :id")
					.setInteger("id", infoId)
					.iterate()
					.next())
					.intValue();
		Integer countPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		List<CartoonImage> list = (List<CartoonImage>)getSession().createQuery(hql)
							.setInteger("id", infoId)
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
