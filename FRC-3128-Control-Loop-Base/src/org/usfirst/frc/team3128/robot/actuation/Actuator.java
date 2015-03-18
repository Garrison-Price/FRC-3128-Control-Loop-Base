package org.usfirst.frc.team3128.robot.actuation;

import org.usfirst.frc.team3128.robot.logging.Log;

public abstract class Actuator {
	private boolean loggingEnabled;
	protected Log log;
	private double inputUpperBound;
	private double inputLowerBound;
	
	public abstract void set(double input);
	
	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}
	public void setLoggingEnabled(boolean loggingEnabled) {
		this.loggingEnabled = loggingEnabled;
	}
	
	public double getInputUpperBound() {
		return inputUpperBound;
	}
	public void setInputUpperBound(double inputUpperBound) {
		this.inputUpperBound = inputUpperBound;
	}

	public double getInputLowerBound() {
		return inputLowerBound;
	}

	public void setInputLowerBound(double inputLowerBound) {
		this.inputLowerBound = inputLowerBound;
	}
}
