package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.ArmCommand;
import frc.robot.Commands.IntakeArmCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.TankCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Tank;

public class RobotContainer {

    private final Intake intake = new Intake();
    private final Arm arm = new Arm();
    private final Tank tank = new Tank();
    private final IntakeArm intakearm = new IntakeArm();

    private final CommandXboxController controller = new CommandXboxController(0);
    public RobotContainer() {
        tank.setDefaultCommand(
            new TankCommand(
                tank,
                () -> -controller.getRightX(),
                () -> -controller.getLeftY()));
        configureBindings();
    }

    private void configureBindings() {
        controller.x().whileTrue(new IntakeCommand(intake));
        controller.a().whileTrue(new ArmCommand(arm));
        controller.b().whileTrue(new IntakeArmCommand(intakearm));
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
