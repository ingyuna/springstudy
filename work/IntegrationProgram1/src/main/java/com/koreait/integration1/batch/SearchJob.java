package com.koreait.integration1.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SearchJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		String[] genre = {"코미디", "공포", "멜로", "드라마", "SF"};
		
		
		
	}

}
