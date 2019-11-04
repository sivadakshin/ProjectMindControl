# ProjectMindControl
A software to control smart devices using neurosky EEG sensors
This Project is Developed using NetBeans IDE.
copy mindcontrol folder to netbeans project folder.
 
Please read LICENSE.txt for this software license

This Project have the following Dependencies
make sure you download the following dependencies. and add to the classpath in netbeans.
XChart library		//to draw EEG waves
https://github.com/knowm/XChart
XChart Demo library	//to draw EEG waves
https://github.com/knowm/XChart
ThinkGear.jar 		//this one is a third party library to interface with thinkgear connector.
https://github.com/borg/ThinkGear-Java-socket

A QUICK WALKTHROUGH OF THE SOURCE CODE:
1. MindControl.java-
contains the main body of the application.it is the jframe class which contains the Triggers.
It is also contains EEG machine and cloud connect/configure button. It contains the Visualize and Debug button.
2. EegMachine.java-
This class contains methods which is called continuously by the ThinkGear.jar, on receiving
the wave data. on receiving EEG datafrom Think gear connector. the ThinkGear.jar calls the methods
in EegMachine.java which adds the data to its static variables.
3.Cloud.java-
It is a Generic interface, implementing a cloud service should implement this interface.
4.<cloudservicename>.java and <cloudservicename>view.java-
Any cloud service we create must implement cloud and should have 2 classes, <cloudservicename>.java for it's data and contains
the run method when the trigger id fired.<cloudservicename>view.java is configuration GUI which is a JFrame to get its configuration.
5.Trigger.java 
represents a trigger. contains object of command interface and cloud interface. the trigger when enabled,
calls the run method of its command object. the run method calls the fire method in trigger if the condition is 
satisfied. Deletion/Modification of a trigger disables it.
6.Command.java-
It is a Generic interface, any command should be implementing this interface.
7.<commandname>Command.java and <commandname>ConfigView.java
any command should implement the command interface. a command contains 2 parts. <commandname>Command.java,
which implements command cand contains data and run method.<commandname>ConfigView.java,
which contains a GUI form to input configuration for the command.
8. LiveChart.java-
Contains the GUI for the Wave Charts.
9. Plot.java-
Contains all static methods. Updates the GUI of LiveChart.
10.Debug.java-
Contains the GUI of Debug window called by debug button. Shows all log info.


