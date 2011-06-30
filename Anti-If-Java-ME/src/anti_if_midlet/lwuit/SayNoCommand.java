package anti_if_midlet.lwuit;

import com.sun.lwuit.Dialog;


public class SayNoCommand extends AntiIfCommand {

	public SayNoCommand() {
		super("Say No");
	}

	public void execute() {
		sayNo();
	}
	
	private void sayNo() {
		Dialog.show("No Command", "No! :(", OK, null);
	}

}
