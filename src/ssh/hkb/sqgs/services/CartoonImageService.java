package ssh.hkb.sqgs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssh.hkb.sqgs.dao.CartoonImageDao;
import ssh.hkb.sqgs.entities.CartoonImage;
import ssh.hkb.sqgs.tools.PageUtil;

@Service
public class CartoonImageService {
	
	@Autowired
	private CartoonImageDao cartoonImageDao;

	public void setCartoonImageDao(CartoonImageDao cartoonImageDao) {
		this.cartoonImageDao = cartoonImageDao;
	}
	
	public PageUtil<CartoonImage> listCartoonImage(Integer infoId, Integer currentPage, Integer pageSize) {
		return cartoonImageDao.listCTImageByCTInfo(infoId, currentPage, pageSize);
	}

}
