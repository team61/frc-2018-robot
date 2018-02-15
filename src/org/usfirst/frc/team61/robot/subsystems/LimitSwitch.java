package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitch extends Subsystem {
	
	DigitalInput limitSwitchA = new DigitalInput(RobotMap.limitSwitchA);

    public void initDefaultCommand() {
    }
    /**
     * Gets the state of the limitswitch
     * @author Team 61 Programming
     * @return True if limitswitch is pressed
     */
	public boolean isSwitchSet() {
		return limitSwitchA.get();
	}
	
    /**
     * Determine if the limitswitch is pressed or not
     * @author Team 61 Programming
     * @return False if limitswitch is pressed, True if it is not
     */
    public boolean getReadyState() {
    	if (isSwitchSet()) {
    		return false;
    	} else {
    		return true;
    	}
    }
}

