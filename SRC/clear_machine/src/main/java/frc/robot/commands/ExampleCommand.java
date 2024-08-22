/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Training;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Training m_train;
  private static int state;
  private static long time;
  private static double Right;
  private static double Left ;
  private static double Back ;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(Training subsystem) {
    m_train = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    state = 0;
    Right = (-1/2);
    Left = (1/2);
    Back = (0);
    m_train.resetGyro();
  }

  // Здесь происходит основной код
  @Override
  public void execute() 
  {

    // m_train.CaseSB.setDouble(state);

    switch (state) {
      case 0:
        time = System.currentTimeMillis();
        if (m_train.getStart())
        {
        state++;
        }
        break;
// Alga
      case 1:
        Right = (0.3);
        Left = (-0.3);
        Back = (0);


        if(System.currentTimeMillis() - time >= 2500)
        {
          state++;
        }

        break;

      case 2:
        Right = (-0.0);
        Left = (-0.0);
        Back = (0.0);
        time = System.currentTimeMillis();
        state++;
        break;
// Solga karay
      case 3:
        Right = (0.25);
        Left = (0.25);
        Back = (-0.5);

        if(System.currentTimeMillis() - time >= 3500)
        {
          state++;
        }
        break;
      case 4:
        Right = (-0.0);
        Left = (-0.0);
        Back = (0.0);
        time = System.currentTimeMillis();
        state++;
        break;
        // 90 graduska burulu solga
      //case 5:
       // Right = ((90 - m_train.getYaw())/90-0.1);
        //Left = ((90 - m_train.getYaw())/90-0.1);
       //Back = ((90 - m_train.getYaw())/90-0.1);
      // if(m_train.getYaw() <= -90)
       ///{
         // state++;
        //}
        //break;
// 90 gradus povorot
      case 5: 
       Right = (0.3);
       Left = (0.3);
       Back = (0.3);
         
           if (m_train.getYaw()<= -90)
          {
            m_train.resetGyro();
        state++;
          }
         break;

      case 6:
        Right = (-0.0);
        Left = (-0.0);
        Back = (0.0);
        time = System.currentTimeMillis();
        state++;
        break;
// Onga karay 
      case 7:
       Right = (-0.25);
       Left = (-0.25);
       Back = (0.45);

        if(System.currentTimeMillis() - time >= 4000)
        {
          state++;
        }
        break;

      case 12:
        Right = (-0.0);
        Left = (-0.0);
        Back = (0.0);
        time = System.currentTimeMillis();
        state++;
        break;

      case 15:
        Right = (-(-90 - m_train.getYaw())/90-0.1);
        Left = (-(-90 - m_train.getYaw())/90-0.1);
        Back = (-(-90 - m_train.getYaw())/90-0.1);
        if(m_train.getYaw() <= -90)
        {
          state++;
        }
        break;
      default:
        Right = (-0.0);
        Left = (-0.0);
        Back = (0.0);
        break;
    }



    if (m_train.getEMS())
    {
      m_train.setRightMotorSpeed(0);
      m_train.setLeftMotorSpeed(0);
      m_train.setBackMotorSpeed(0);
      m_train.setLiftMotorSpeed(0);


    }
    else
    {

    m_train.setRightMotorSpeed(Right);
    m_train.setLeftMotorSpeed(Left);
    m_train.setBackMotorSpeed(Back);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
