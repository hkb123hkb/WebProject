package ssh.hkb.sqgs.dao;

import ssh.hkb.sqgs.entities.Video;
import ssh.hkb.sqgs.tools.PageUtil;

/**
 * 视频类接口
 */
public interface VideoDao {
	
	/**
	 * 新增或修改一条视频信息
	 * @param video 要新增或修改的视频对象
	 * @return 新增或修改后的视频对象
	 */
	Video saveOrUpdateVideo(Video video);
	
	/**
	 * 删除一条视频信息
	 * @param id 要删除的视频信息的id
	 * @return 删除的视频对象
	 */
	Video deleteVideo(Integer id);
	
	/**
	 * 查询一条视频信息
	 * @param id 要查询的视频的id
	 * @return 查询到的视频对象
	 */
	Video getVideo(Integer id);
	
	/**
	 * 查询所有视频（分页查询）
	 * @param currentPage 当前页码
	 * @param pageSize 每页要显示的记录数
	 * @return 
	 */
	PageUtil<Video> listVideos(Integer currentPage, Integer pageSize);

}
