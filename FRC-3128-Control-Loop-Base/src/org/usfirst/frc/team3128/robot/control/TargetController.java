package org.usfirst.frc.team3128.robot.control;

import org.usfirst.frc.team3128.robot.actuation.Actuator;
import org.usfirst.frc.team3128.robot.logging.Log;
import org.usfirst.frc.team3128.robot.sensing.Sensor;
import org.usfirst.frc.team3128.robot.Global;

public abstract class TargetController extends Controller {
	private double target;
	private Sensor sensor;
	
	public TargetController(Sensor sensor, Actuator actuator, int frequency, Log log, boolean loggingEnabled) {
		super(actuator, frequency, log, loggingEnabled);
		this.sensor = sensor;
	}
	
	protected abstract void controlLoop();

	/**
	 * Maps the output to the actuator input.
	 * @param output
	 * @return output
	 */
	protected abstract double normalizeOutput(double output);

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
