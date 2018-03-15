package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightB extends CommandGroup {
    public AutoRightB() {
    	addSequential(new DriveForDistance(290, .8, 10));
    	addSequential(new DriveForDistance(10, .3, 5));
    }
}
