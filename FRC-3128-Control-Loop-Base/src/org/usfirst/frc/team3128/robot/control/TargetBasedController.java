package org.usfirst.frc.team3128.robot.control;

import org.usfirst.frc.team3128.robot.logging.Log;
import org.usfirst.frc.team3128.robot.sensing.Sensor;

public abstract class TargetBasedController extends Controller{
	protected double target;
	protected Sensor sensor;
	
	public TargetBasedController(Sensor sensor, int frequency, Log log, boolean loggingEnabled) {
		super(frequency, log, loggingEnabled);
		this.sensor = sensor;
	}
	
	//For this implementation, I will use a VERY simple error driven control loop
	public void controlLoop() {
		double error = normalizeOutput(target-sensor.getValue());
		actuator.set(error);
	}

	//For this implementation, I will simply map the output to fall into  
	// the actuator's maximum and minimum input.
	public double normalizeOutput(double output) {
		//TODO Something about mapping the sensor max and min to the actuator max and min
		// as the error should always be within the sensor's valid range.
		return output;
	}

	public void setTarget(double target) {
		this.target = target;
	}
	
	public double getTarget() {
		return this.target;
	}
}
