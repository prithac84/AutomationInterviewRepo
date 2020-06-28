package alpha;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class demoLog4j1 {	
 public static Logger log = LogManager.getLogger(demoLog4j1.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(demoLog4j1.class.getName());	
		BasicConfigurator.configure();
		log.debug("Debug msg");
		log.error("Error msg");
		log.fatal("Fatal msg");
		log.info("Info msg");
	
	}

}
