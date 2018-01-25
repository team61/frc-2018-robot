
package org.usfirst.frc.team61.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team61.robot.commands.AutonomousBase;
import org.usfirst.frc.team61.robot.commands.ExampleCommand;
import org.usfirst.frc.team61.robot.commands.GlobalCommand;
import org.usfirst.frc.team61.robot.subsystems.DriveTrain;
import org.usfirst.frc.team61.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
    public final String teamNo = "  61";
    public final String versionNo = "1-18-2018.$";

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
	    // Initialize all subsystems
	    GlobalCommand.init();
		
		//chooser stuff
		chooser.addDefault("Default Auto", new AutonomousBase());
		chooser.addObject("My Auto", new ExampleCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
        // Ouput program info to system log.
        System.out.println("+----------------------------------------------+");
        System.out.println("| Team "+teamNo+" - Software Version: "+versionNo+" |");
        System.out.println("+----------------------------------------------+");
    }

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		System.out.println("Disabled Intitiated");
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
        // instantiate the command used for the autonomous period (the chooser on the smart dashboard will pick this)
		autonomousCommand = chooser.getSelected();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
		
		System.out.println("Autonomous Initiated");
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// stop the autonomous as soon as teleop starts
		if (autonomousCommand != null) autonomousCommand.cancel();
		
		System.out.println("Teleop Initiated");
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
