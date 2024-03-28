The software is in beta version
# ProjectMindControl
A software to control smart devices using neurosky EEG sensors.
Description-

My Youtube demo of this project can be found here:
https://youtu.be/DeAPBgW3kqc

using this software you can create triggers and control your smart devices.
for now, only webhook service is supported(IFTTT).
Thinkgear connector required, get it from neurosky official website.

This Project is Developed using NetBeans IDE.
copy mindcontrol folder to netbeans project folder.
 
Please read LICENSE.txt for this software license

This Project have the following Dependencies
make sure you download the following dependencies. and add to the classpath in netbeans.

XChart library-to draw EEG waves
https://github.com/knowm/XChart

XChart Demo library	-to draw EEG waves
https://github.com/knowm/XChart

ThinkGear.jar -library to interface with thinkgear connector(modify the method calls according to this project).
https://github.com/borg/ThinkGear-Java-socket

Working Of the software-
1.	User should click the connect button on the left panel to connect to the EEG-Machine.
2.  	ThinkGear connector software must be running. it can be downloaded from neurosky website. 
3.	The user should click the connect button on the right of the main panel to configure his/her cloud device.
4.	Webhook service is only supported for now. Webhooks can be configured in IFTTT platform. 
3.	After configuring both, user can add a new trigger by clicking the add button.
4.	A Trigger is an entity which binds A command with a smart device action.
5.	Within a trigger, user should select one of the commands from the list. Then user should configure the command by clicking the configure button. The list of commands includes Blink, Attention, Meditation, Alpha waves, Beta waves, Gamma waves.
6.	Blink Command is configured by 2 parameters. TIME and TIMES. TIMES states the number of times the user should blink and TIME state the time in seconds within which the user should blink.
7.	Rest all Commands have 3 parameters. Threshold, Operator and Time. Threshold is the value of a particular wave. Operator is the condition on the threshold value. They are (>, < , =). Time is the time in seconds for which the threshold with operator condition should be satisfied.
8.	User then Selects one of the action of their smart device.
9.	Then, user can Enable/Disable the Trigger he created.
10.	The Software also allows the user to modify and delete the created triggers.     

A QUICK WALKTHROUGH OF THE SOURCE CODE:
1. MindControl.java-
contains the main body of the application.it is the jframe class which contains the Triggers.
It is also contains EEG machine and cloud connect/configure button. It contains the Visualize and Debug button.
2. EegMachine.java-
This class contains methods which is called continuously by the ThinkGear.jar, on receiving
the wave data. on receiving EEG datafrom Think gear connector, the ThinkGear.jar calls the methods
in EegMachine.java which adds the data to its static variables.
3. Cloud.java-
It is a Generic interface, implementing a cloud service should implement this interface.
4. cloudservicename.java and cloudservicenameView.java-
Any cloud service we create must implement cloud and should have 2 classes, cloudservicename.java for it's data and contains
the run method when the trigger id fired.cloudservicenameView.java is configuration GUI which is a JFrame to get its configuration.
5. Trigger.java 
represents a trigger. contains object of command interface and cloud interface. the trigger when enabled,
calls the run method of its command object. the run method calls the fire method in trigger if the condition is 
satisfied. Deletion/Modification of a trigger disables it.
6. Command.java-
It is a Generic interface, any command should be implementing this interface.
7. commandnameCommand.java and commandnameConfigView.java-
any command should implement the command interface. a command contains 2 parts. commandnameCommand.java,
which implements command cand contains data and run method. commandnameConfigView.java,
which contains a GUI form to input configuration for the command.
8. LiveChart.java-
Contains the GUI for the Wave Charts.
9. Plot.java-
Contains all static methods. Updates the GUI of LiveChart.
10. Debug.java-
Contains the GUI of Debug window called by debug button. Shows all log info.
