package org.usfirst.frc.team3128.robot.actuation;

import org.usfirst.frc.team3128.robot.sensing.CurrentSensor;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;

public class Motor extends Actuator {
	private int motorType;
	private int motorControllerType;
	private int motorControllerChannel;
	private SpeedController motorController;
	private CurrentSensor currentSensor;
	
	/**
	 * Initializes all of the important parts of the Motor class.
	 * Motor types can be found in Global.
	 * Motor Controller types can be found in Global.
	 * Motor Controller channel is the roboRIO channel that the controller is plugged in to.
	 * PowerDistributionPanel is the CAN link to the Power Distribution Panel
	 * PDPChannel is the power distribution channel that the motor controller is powered from.
	 * @param motorType
	 * @param motorControllerType
	 * @param motorControllerChannel
	 * @param powerDistributionPanel
	 * @param PDPChannel
	 */
	public Motor(int motorType, int motorControllerType, int motorControllerChannel, PowerDistributionPanel powerDistributionPanel, int PDPChannel) {
		super(1.0,-1.0);
		this.motorType = motorType;
		this.motorControllerType = motorControllerType;
		this.motorControllerChannel = motorControllerChannel;
		motorController = new Jaguar(motorControllerChannel);
		currentSensor = new CurrentSensor(powerDistributionPanel,PDPChannel);
	}

	/**
	 * Sets the speed of the motor controller. 
	 * Input is between 1.0 and -1.0.
	 * @param input
	 */
	public void set(double input) {
		motorController.set(input);
	}
}
