package frc.robot;

import edu.wpi.first.math.MathUtil;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
//Commands and Controllers\\
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_robotDrive;

  // Initializes the controller (Xbox)
  private final CommandXboxController m_driverController =
      new CommandXboxController(OIConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Initializes the subsystems
    m_robotDrive = new DriveSubsystem();
    // Gets controller binding
    configureBindings();
    // Sets joystick to drive
    m_robotDrive.setDefaultCommand(
      new RunCommand(
        () -> m_robotDrive.drive(
        -MathUtil.applyDeadband(m_driverController.getRawAxis(1), OIConstants.kDriveDeadband), 
        -MathUtil.applyDeadband(m_driverController.getRawAxis(2), OIConstants.kDriveDeadband), 
        -MathUtil.applyDeadband(m_driverController.getRawAxis(4), OIConstants.kDriveDeadband), 
        true),
      m_robotDrive));
  }
  // Sets up controller bindings
  private void configureBindings() {
    // Initiallizyng Buttons
    //new JoystickButton(m_driverController, 0).whileTrue(new CMD(subsystem, value))
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }*/
}
