package org.usfirst.frc.team3128.robot.sensing;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class CurrentSensor extends Sensor {
	private int PDPChannel;
	private PowerDistributionPanel powerDistributionPanel;
	
	public CurrentSensor(PowerDistributionPanel powerDistributionPanel, int PDPChannel) {
		this.PDPChannel = PDPChannel;
		this.powerDistributionPanel = powerDistributionPanel;
	}
	
	@Override
	public double getValue() {
		return powerDistributionPanel.getCurrent(PDPChannel);
	}
}
