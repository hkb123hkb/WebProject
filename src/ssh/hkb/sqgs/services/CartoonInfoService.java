package ssh.hkb.sqgs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssh.hkb.sqgs.dao.CartoonInfoDao;
import ssh.hkb.sqgs.entities.CartoonInfo;
import ssh.hkb.sqgs.tools.PageUtil;

@Service
public class CartoonInfoService {
	
	@Autowired
	private CartoonInfoDao cartoonInfoDao;
	
	public void setCartoonInfoDao(CartoonInfoDao cartoonInfoDao) {
		this.cartoonInfoDao = cartoonInfoDao;
	}
	
	public PageUtil<CartoonInfo> listCartoonInfo(Integer currentPage, Integer pageSize) {
		return cartoonInfoDao.listCTInfo(currentPage, pageSize);
	}
	
}
