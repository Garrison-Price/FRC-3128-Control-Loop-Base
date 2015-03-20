package org.usfirst.frc.team3128.robot.control;

import org.usfirst.frc.team3128.robot.logging.Log;
import org.usfirst.frc.team3128.robot.sensing.Sensor;

public abstract class TargetBasedController extends Controller{
	private double target;
	private Sensor sensor;
	
	public TargetBasedController(Sensor sensor, int frequency, Log log, boolean loggingEnabled) {
		super(frequency, log, loggingEnabled);
		this.sensor = sensor;
	}
	
	protected void controlLoop() {
		//Simple error driven control loop
		double error = normalizeOutput(target-sensor.getValue());
		actuator.set(error);
	}

	/**
	 * Maps the output to the actuator input.
	 * @param output
	 * @return output
	 */
	protected double normalizeOutput(double output) {
		//Convert the error to a percentage of the maximum sensor value
		output = output/(sensor.getMaxValue()-sensor.getMinValue());
		//Convert the percent error to an actuator value
		output = output*(actuator.getInputUpperBound()-actuator.getInputLowerBound());
		//Add the base actuator value to the error
		output = output + actuator.getInputLowerBound();
		return output;
	}

	/**
	 * Set the target for the control loop to attempt to get the actuator to.
	 * @param target
	 */
	public void setTarget(double target) {
		this.target = target;
	}
	
	/**
	 * Get the target the control loop is currently pursuing.
	 * @return target
	 */
	public double getTarget() {
		return this.target;
	}
}
