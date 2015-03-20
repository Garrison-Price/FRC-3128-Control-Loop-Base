package org.usfirst.frc.team3128.robot.actuation;

import org.usfirst.frc.team3128.robot.sensing.CurrentSensor;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;

public class Motor extends Actuator {
	private int motorType;
	private int motorControllerType;
	private int motorControllerChannel;
	private SpeedController motorController;
	private CurrentSensor currentSensor;
	
	public Motor(int motorType, int motorControllerType, int motorControllerChannel, int PDPChannel) {
		super(1.0,-1.0);
		this.motorType = motorType;
		this.motorControllerType = motorControllerType;
		this.motorControllerChannel = motorControllerChannel;
		motorController = new Jaguar(motorControllerChannel);
	}

	@Override
	public void set(double input) {

	}
}
