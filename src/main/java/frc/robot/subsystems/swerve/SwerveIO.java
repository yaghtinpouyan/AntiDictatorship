package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.AutoLog;

public interface SwerveIO {
  @AutoLog
  public static class SwerveIOInputs {
    public boolean connected = false;
    public double headingDeg = 0.0;
    public double commandedXSpeed = 0.0;
    public double commandedYSpeed = 0.0;
    public double commandedOmega = 0.0;
  }

  default void updateInputs(SwerveIOInputs inputs) {}

  default void drive(double xSpeedMetersPerSecond, double ySpeedMetersPerSecond, double omegaRadiansPerSecond) {}

  default void stop() {}
}
