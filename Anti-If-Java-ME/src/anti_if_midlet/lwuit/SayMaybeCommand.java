package anti_if_midlet.lwuit;

import com.sun.lwuit.Dialog;

public class SayMaybeCommand extends AntiIfCommand {

	public SayMaybeCommand() {
		super("Say Maybe");
	}

	public void execute() {
		sayMaybe();
	}
	
	private void sayMaybe() {
		Dialog.show("Maybe Command", "Maybe... :|", OK, null);
	}


}
