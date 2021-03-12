package top.qianxinyao.main;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Main
{
	
	public static final Logger logger = Logger.getLogger(Main.class);
    
	//选择要在推荐系统中运行的推荐算法
	public static void main(boolean enableCF,boolean enableCB,boolean enableHR,long uid)
	{
		//在测试数据上运行
		//new TestDataRunner().runTestData();
		

		List<Long> userList=new ArrayList<>();
		userList.add(uid);

		//为指定用户执行一次推荐
		new JobSetter(enableCF,enableCB,enableHR).executeInstantJobForCertainUsers(userList);
		//为活跃用户执行定时推荐
//		new JobSetter(enableCF,enableCB,enableHR).executeQuartzJobForActiveUsers();
	}
	
	
	
}

