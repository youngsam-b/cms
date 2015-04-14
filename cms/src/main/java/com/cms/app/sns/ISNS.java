package com.cms.app.sns;

import com.cms.app.model.User;

public interface ISNS {	
	User signIn();
	User write(Thread t);
}
