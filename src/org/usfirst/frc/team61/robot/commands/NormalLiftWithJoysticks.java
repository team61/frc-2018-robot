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
        	// commands to occur when torque toggle is pressed
        	// we only want the moveAllMotors command in TorqueLift to
        	// run so we will do nothing here
        	
        	if (!limitswitch.getReadyState()) {
        		lift.moveLift(oi.getLiftYUpSpeed());
        	}
        } else {
        	//the commands here will be what normally runs
        	if (limitswitch.getReadyState()) {
        		if(lift.getLiftEncoder() < RobotMap.liftMaxHeight) {
                	torquelift.sSet();
                	lift.moveLift(oi.getLiftSpeed());
        		} else {
        			lift.moveLift(oi.getLiftYDownSpeed());
        		}
            	System.out.println("Encoder Value = " + lift.getLiftEncoder());
        	} else {
        		lift.resetEncoder();
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
