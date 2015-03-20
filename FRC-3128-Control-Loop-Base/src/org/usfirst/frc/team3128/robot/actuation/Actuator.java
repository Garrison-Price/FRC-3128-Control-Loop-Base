package org.usfirst.frc.team3128.robot.actuation;

import org.usfirst.frc.team3128.robot.logging.Log;

public abstract class Actuator {
	private boolean loggingEnabled;
	protected Log log;
	private double maxInput;
	private double minInput;
	
	public Actuator(double maxInput, double minInput) {
		this.maxInput = maxInput;
		this.minInput = minInput;
	}
	
	public abstract void set(double input);
	
	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}
	
	public void setLoggingEnabled(boolean loggingEnabled) {
		this.loggingEnabled = loggingEnabled;
	}
	
	public double getInputUpperBound() {
		return maxInput;
	}
	
	public void setInputUpperBound(double inputUpperBound) {
		this.maxInput = inputUpperBound;
	}

	public double getInputLowerBound() {
		return minInput;
	}

	public void setInputLowerBound(double inputLowerBound) {
		this.minInput = inputLowerBound;
	}
}
