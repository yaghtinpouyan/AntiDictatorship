package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.IntakeCommand;
import frc.robot.subsystems.Intake;

public class RobotContainer {

    private final Intake intake = new Intake();

    private final CommandXboxController controller = new CommandXboxController(0);
    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        controller.x().whileTrue(new IntakeCommand(intake));
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}