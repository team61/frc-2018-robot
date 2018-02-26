package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChooserSwitch extends Subsystem {

	DigitalInput chooserSwitchA = new DigitalInput(RobotMap.chooserSwitchA);
	DigitalInput chooserSwitchB = new DigitalInput(RobotMap.chooserSwitchB);

    public void initDefaultCommand() {
    }
    
    public boolean getChooserSwitchA() {
    	return !chooserSwitchA.get();
    }
    
    public boolean getChooserSwitchB() {
    	return !chooserSwitchB.get();
    }
    
}

