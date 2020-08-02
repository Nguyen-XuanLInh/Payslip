package com.wata.payslip.model.dto;

import java.util.List;

public class PaginationList<T> {	
	public List<T> pageOfItems;
	public Integer currentPage, totalPage, pageSize, totalItem;
	
	public PaginationList( List<T> pageOfItems, Integer currentPage, Integer totalPage, Integer pageSize, Integer totalItem ) {
		this.pageOfItems = pageOfItems;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalItem = totalItem;
	}
	
	public PaginationList() {
		
	}
	
	public List<T> getPageOfItems() {
		return pageOfItems;
	}

	public void setPageOfItems(List<T> pageOfItems) {
		this.pageOfItems = pageOfItems;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

}