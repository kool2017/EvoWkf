/**
 * @PROJECT 
 * @DATE 2018年2月13日 上午10:36:33
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import org.apache.log4j.Logger;

/**
 * @DESCRIBE Alice, the core role of evoWkf engine.
 * @AUTHOR LUYU
 * @DATE 2018年2月13日 上午10:36:33
 *
 */
public class Alice {
	private Alice() {
	}

	private static Alice me;
	private static Object lock = new Object();
	private static Logger logger = Logger.getLogger(Alice.class);
	private IStart startWorker;
	private ISchedule scheduleWorker;
	private ICheck checkWorker;
	private IStep stepWorker;
	private IOperations operationWorker;
//	private Map<String, String> mapCfg;
	
	public static Alice getInstance() {
		if (null == me) {
			synchronized (lock) {
				if (null == me) {
					me = new Alice();
					me.init();
					logger.info("Alice is created");
				}
			}
		}

		return me;
	}

	private void init() {
		logger.info("Alice is initing ...");

		logger.info("init startWorker");
		startWorker = new SimpleStartImp();

		logger.info("init scheduleWorker");
		scheduleWorker = new SimpleScheduleImp();

		logger.info("init checkWorker");
		checkWorker = new SimpleCheckImp();

		logger.info("init stepWorker");
		stepWorker = new SimpleStepImp();

		logger.info("init operationWorker");
		operationWorker = new SimpleOperationsImp();

		logger.info("Alice finished initing");
	}

	public void reset() {
		logger.info("Alice is reseting ...");

		logger.info("Alice finished reseting");
	}
	
	/**
	 * @return the startWorker
	 */
	public IStart getStartWorker() {
		return startWorker;
	}

	/**
	 * @param startWorker the startWorker to set
	 */
	public void setStartWorker(IStart startWorker) {
		this.startWorker = startWorker;
	}

	/**
	 * @return the scheduleWorker
	 */
	public ISchedule getScheduleWorker() {
		return scheduleWorker;
	}

	/**
	 * @param scheduleWorker the scheduleWorker to set
	 */
	public void setScheduleWorker(ISchedule scheduleWorker) {
		this.scheduleWorker = scheduleWorker;
	}

	/**
	 * @return the checkWorker
	 */
	public ICheck getCheckWorker() {
		return checkWorker;
	}

	/**
	 * @param checkWorker the checkWorker to set
	 */
	public void setCheckWorker(ICheck checkWorker) {
		this.checkWorker = checkWorker;
	}

	/**
	 * @return the stepWorker
	 */
	public IStep getStepWorker() {
		return stepWorker;
	}

	/**
	 * @param stepWorker the stepWorker to set
	 */
	public void setStepWorker(IStep stepWorker) {
		this.stepWorker = stepWorker;
	}

	/**
	 * @return the operationWorker
	 */
	public IOperations getOperationWorker() {
		return operationWorker;
	}

	/**
	 * @param operationWorker the operationWorker to set
	 */
	public void setOperationWorker(IOperations operationWorker) {
		this.operationWorker = operationWorker;
	}

}
