package ssh.hkb.sqgs.tools;

import java.util.List;

public class PageUtil<T> {

	private int currentPage;// 当前页数
	private int pageSize;// 每页显示的记录数
	private int count;// 总记录数
	private int pageCount;// 总页数
	private List<T> rows;// 每页显示的记录数

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
