package anti_if_midlet.lwuit;

import com.sun.lwuit.Dialog;


public class SayYesCommand extends AntiIfCommand {

	public SayYesCommand() {
		super("Say Yes");
	}

	public void execute() {
		sayYes();
	}

	private void sayYes() {
		Dialog.show("Yes Command", "Yes! :)", OK, null);
	}

}
