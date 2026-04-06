package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private SparkMax ArmMotor = new SparkMax(1, MotorType.kBrushless);
  private static Arm arm = null;
  
  public static Arm getInstance(){
    if (arm == null){
      arm = new Arm();
    }
    return arm;
  }

  public Arm(){
    
  }
   public void setArmMotor(Boolean aButton, Boolean bButton){
    if(aButton == true){
      ArmMotor.set(0.7);
    }
    else if(bButton == true){
      ArmMotor.set(-0.7);
    }
    else{
      ArmMotor.set(0);
    }

  SmartDashboard.putBoolean("we are climbing up", aButton);
  SmartDashboard.putBoolean("we are climbing down", bButton);

  }

}