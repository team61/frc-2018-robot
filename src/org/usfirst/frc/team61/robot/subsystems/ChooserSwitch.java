package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChooserSwitch extends Subsystem {

	DigitalInput chooserSwitch = new DigitalInput(RobotMap.chooserSwitch);

    public void initDefaultCommand() {
    }
    
    public boolean getChooserSwitch() {
    	return !chooserSwitch.get();
    }
    
}

