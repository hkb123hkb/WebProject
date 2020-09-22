package ssh.hkb.sqgs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssh.hkb.sqgs.dao.VideoDao;
import ssh.hkb.sqgs.entities.Video;
import ssh.hkb.sqgs.tools.PageUtil;

@Service
public class VideoService {
	
	@Autowired
	private VideoDao videoDao;
	
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao =  videoDao;
	}
	
	public PageUtil<Video> listVideos(Integer currentPage, Integer pageSize) {
		return videoDao.listVideos(currentPage, pageSize);
	}

}
