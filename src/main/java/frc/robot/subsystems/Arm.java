package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private SparkMax ArmMotor = new SparkMax(1, MotorType.kBrushless);
  private SparkClosedLoopController pidController;
  private RelativeEncoder encoder;

  private static Arm arm = null;

  private static final double Position_Up =10.0;
  private static final double Position_Defualt =0.0;

  private static final double kP = 0.1;
  private static final double kI = 0.0;
  private static final double kD = 0.0;

  
  public static Arm getInstance(){
    if (arm == null){
      arm = new Arm();
    }
    return arm;
  }

  public Arm(){
    encoder = ArmMotor.getEncoder();
    pidController = ArmMotor.getClosedLoopController();

    SparkMaxConfig config = new SparkMaxConfig();
    config.closedLoop
      .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
      .p(kP)
      .i(kI)
      .d(kD)
      .outputRange(-0.7, 0.7);

    ArmMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    encoder.setPosition(0);
  }
   public void setArmMotor(Boolean aButton, Boolean bButton){
    if(aButton){
      pidController.setSetpoint(Position_Up, ControlType.kPosition);
    }
    else if(bButton){
      pidController.setSetpoint(Position_Defualt, ControlType.kPosition);
    }

  SmartDashboard.putNumber("Arm Target", aButton ? Position_Up: bButton ? Position_Defualt:-1);
  SmartDashboard.putNumber("Arm Position", encoder.getPosition());

  }

}