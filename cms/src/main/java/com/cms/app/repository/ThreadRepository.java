package com.cms.app.repository;

public interface ThreadRepository {
	 boolean write(Thread t);
	 boolean read(int id);
	 boolean update(Thread t);
	 boolean delete(int id);		
	 Thread[] list(int pageNo); 
}
