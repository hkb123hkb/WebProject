package ssh.hkb.sqgs.dao;

import ssh.hkb.sqgs.entities.CartoonInfo;
import ssh.hkb.sqgs.tools.PageUtil;

/**
 * 漫画信息接口
 */
public interface CartoonInfoDao {
	
	/**
	 * 新增或修改一条漫画信息
	 * @param info 要新增或修改的漫画对象
	 * @return 新增或修改后的漫画对象
	 */
	CartoonInfo savaOrUpdateCTInfo(CartoonInfo info);
	
	/**
	 * 删除一条漫画信息
	 * @param id 要删除的漫画id
	 * @return 删除的漫画对象
	 */
	CartoonInfo deleteCTInfo(Integer id);
	
	/**
	 * 查询一条漫画信息
	 * @param id 要查询的漫画的id
	 * @return 查询到的漫画对象
	 */
	CartoonInfo getCTInfo(Integer id);
	
	/**
	 * 查询所有漫画信息
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return
	 */
	PageUtil<CartoonInfo> listCTInfo(Integer currentPage, Integer pageSize);

}
