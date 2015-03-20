package org.usfirst.frc.team3128.robot.control;

import org.usfirst.frc.team3128.robot.Global;
import org.usfirst.frc.team3128.robot.actuation.Actuator;
import org.usfirst.frc.team3128.robot.logging.Log;

public abstract class Controller implements Runnable {
	private int frequency; //Hertz
	private boolean loggingEnabled;
	protected Log log;
	protected Actuator actuator;
	private boolean running;
	private boolean firstStart;
	
	public Controller(int frequency, Log log, boolean loggingEnabled) {
		this.frequency = frequency;
		this.log = log;
		this.loggingEnabled = loggingEnabled;
		firstStart = true;
	}
	
	/**
	 * This function starts the control loop. It will create
	 * and initialize the thread if this is the first time
	 * that start has been called.
	 */
	public void start() {
		running = true;
		if(firstStart)
			(new Thread(this)).start();
		firstStart = false;
	}
	
	/**
	 * This function pauses the control loop. A simple spin lock 
	 * is used to pause the thread and shouldn't be used frequently.
	 */
	public void stop() {
		running = false;
	}
	
	/** 
	 * This function will halt the control loop. Call this only when
	 * you no longer need this control loop to run.
	 */
	public void kill() {
		Thread.currentThread().interrupt();
	}
	
	/**
	 * This function is where you will write all of your control loop
	 * code. This function will be called automatically at the specified
	 * frequency.
	 */
	protected abstract void controlLoop();
	
	/**
	 * This is Runnable's run function. It will be called repeatedly by 
	 * the thread. You do not need to call this function.
	 */
	public void run() {
		while(!running);
		this.controlLoop();
		try {
			Thread.sleep(1000/frequency);
		} catch(Exception e) {
			if(loggingEnabled)
				log.LogMessage(Global.LOG_DEBUG, e.toString());
		}
	}
	
	/**
	 * Frequency Getter
	 * @return frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * Frequency Setter
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * Checks the logging enabled flag.
	 * @return loggingEnabled
	 */
	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}

	/**
	 * Enable Logging
	 */
	public void enableLogging() {
		loggingEnabled = true;
	}
	
	/**
	 * Disable Logging
	 */
	public void disableLogging() {
		loggingEnabled = false;
	}

	/**
	 * Log Getter
	 * @return log
	 */
	public Log getLog() {
		return log;
	}

	/**
	 * Log Setter
	 * @param log
	 */
	public void setLog(Log log) {
		this.log = log;
	}
}
