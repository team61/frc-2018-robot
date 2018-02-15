package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightB extends CommandGroup {

    public AutoRightB() {
    	addSequential(new DriveForDistance(299, 1));
    }
}
