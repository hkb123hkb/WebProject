package ssh.hkb.sqgs.dao;

import ssh.hkb.sqgs.entities.CartoonImage;
import ssh.hkb.sqgs.tools.PageUtil;

/**
 * 漫画图片类接口
 */
public interface CartoonImageDao {
	
	/**
	 * 新增或修改一条漫画图片信息
	 * @param image 要新增或修改的漫画图片信息
	 * @return 新增或修改后的漫画图片对象
	 */
	CartoonImage saveOrUpdateCTImage(CartoonImage image);
	
	/**
	 * 删除一天漫画图片信息
	 * @param id 要删除的漫画id
	 * @return 删除的漫画图片对象
	 */
	CartoonImage deleteCTImage(Integer id);
	
	/**
	 * 查询一条漫画信息
	 * @param id 要查询的漫画id
	 * @return 查询到的漫画图片对象
	 */
	CartoonImage getCTImage(Integer id);
	
	/**
	 * 根据相关联的漫画信息id查询漫画图片（分页查询）
	 * @param infoId 要查询漫画图片的漫画信息id
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return
	 */
	PageUtil<CartoonImage> listCTImageByCTInfo(Integer infoId, Integer currentPage, Integer pageSize);

}
