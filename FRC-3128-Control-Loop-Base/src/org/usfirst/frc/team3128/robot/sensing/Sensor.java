package org.usfirst.frc.team3128.robot.sensing;

import org.usfirst.frc.team3128.robot.logging.Log;

public abstract class Sensor {
	private boolean loggingEnabled;
	protected Log log;
	private double maxValue;
	private double minValue;
	
	public abstract double getValue();

	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}

	public void setLoggingEnabled(boolean loggingEnabled) {
		this.loggingEnabled = loggingEnabled;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}
}
