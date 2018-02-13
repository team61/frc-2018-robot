package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NormalLiftWithJoysticks extends GlobalCommand {
    public NormalLiftWithJoysticks() {
        requires(lift);
    }

    protected void initialize() {
        lift.resetEncoder();
    }

    protected void execute() {
    	oi.updateToggleLift();
        if(oi.toggleOnLift){
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
        	if (!limitswitch.getReadyState()) {
        		lift.moveLift(oi.getLiftYUpSpeed());
        	}
        } else {
        	// The commands here will occur normally, when the TorqueLift is
        	// not activated.
        	if (limitswitch.getReadyState()) {
        		if(lift.getLiftEncoder() < RobotMap.liftMaxHeight) {
                	torquelift.sSet();
                	lift.moveLift(oi.getLiftSpeed());
                	if (lift.getLiftEncoder() < -500) {
                		if (oi.getLiftSpeed() < 0) {
                			lift.moveLift(oi.getLiftSpeed());
                		} else {
                			lift.moveLift(oi.getLiftSpeed()/3);
                		}
                	}
        		} else {
        			lift.moveLift(oi.getLiftYDownSpeed());
        		}
            	System.out.println("Encoder Value = " + lift.getLiftEncoder());
        	} else {
            	lift.moveLift(oi.getLiftYUpSpeed());
        	}
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
