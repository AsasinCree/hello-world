package test;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestLog4j {
	public static Logger logger = LogManager.getLogger("console");
	
	public static void main(String[] args) {
		logger.trace("entry");  //trace�������Ϣ�������г�����ϣ������ĳ���������߳����߼���ʼ��ʱ����ã���logger.trace("entry")����һ����˼
	        logger.error("Did it again!");   //error�������Ϣ�������������������Ϣ
	        logger.info("����info��Ϣ");    //info�������Ϣ
	        logger.debug("����debug��Ϣ");
	        logger.warn("����warn��Ϣ");
	        logger.fatal("����fatal��Ϣ");
	        logger.log(Level.DEBUG, "����debug��Ϣ");   //��������ƶ�Level���͵ĵ��ã�˭����û�µ��������Ҳ��һ��Ŷ��
	        logger.trace("exit");    //��entry()��Ӧ�Ľ�����������logger.trace("exit");һ����˼
	}
}
