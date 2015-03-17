package org.usfirst.frc.team3128.robot.control;

import org.usfirst.frc.team3128.robot.Global;
import org.usfirst.frc.team3128.robot.logging.Log;

public abstract class Controller implements Runnable {
	private int frequency; //Hertz
	private boolean loggingEnabled;
	private Log log;
	private boolean running;
	private boolean firstStart;
	
	public Controller(int frequency, Log log, boolean loggingEnabled) {
		this.frequency = frequency;
		this.log = log;
		this.loggingEnabled = loggingEnabled;
		firstStart = true;
	}
	
	public void start() {
		running = true;
		if(firstStart)
			(new Thread(this)).start();
		firstStart = false;
	}
	
	public void stop() {
		running = false;
	}
	
	public abstract void controlLoop();
	
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
	
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}

	public void enableLogging() {
		loggingEnabled = true;
	}
	
	public void disableLogging() {
		loggingEnabled = false;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
}
