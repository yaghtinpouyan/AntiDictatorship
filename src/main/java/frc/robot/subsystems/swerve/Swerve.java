package frc.robot.subsystems.swerve;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Swerve extends SubsystemBase {
  private final SwerveIO io;
  private final SwerveIOInputsAutoLogged inputs = new SwerveIOInputsAutoLogged();

  public Swerve(SwerveIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Swerve", inputs);
  }

  public void drive(double xSpeedMetersPerSecond, double ySpeedMetersPerSecond, double omegaRadiansPerSecond) {
    io.drive(xSpeedMetersPerSecond, ySpeedMetersPerSecond, omegaRadiansPerSecond);
    Logger.recordOutput("Swerve/CommandedXSpeedMps", xSpeedMetersPerSecond);
    Logger.recordOutput("Swerve/CommandedYSpeedMps", ySpeedMetersPerSecond);
    Logger.recordOutput("Swerve/CommandedOmegaRadPerSec", omegaRadiansPerSecond);
  }

  public void stop() {
    io.stop();
    Logger.recordOutput("Swerve/Stopped", true);
  }
}
