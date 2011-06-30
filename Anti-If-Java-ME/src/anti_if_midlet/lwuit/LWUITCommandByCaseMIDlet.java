package anti_if_midlet.lwuit;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;


public class LWUITCommandByCaseMIDlet extends MIDlet implements ActionListener {

	private static final String OK = "OK";
	private static final int EXIT_COMMAND_ID = 1;
	private static final int SAY_YES_COMMAND_ID = 2;
	private static final int SAY_NO_COMMAND_ID = 3;
	private static final int SAY_MAYBE_COMMAND_ID = 4;

	private Command exitCommand = new Command("Exit", EXIT_COMMAND_ID);
	private Command sayYesCommand = new Command("Say Yes", SAY_YES_COMMAND_ID);
	private Command sayNoCommand = new Command("Say No", SAY_NO_COMMAND_ID);
	private Command sayMaybeCommand = new Command("Say Maybe", SAY_MAYBE_COMMAND_ID);

	public LWUITCommandByCaseMIDlet() {
		Display.init(this);
	}
	
	protected void startApp() throws MIDletStateChangeException {
		Form form = new Form("Command-By-Case-MIDlet - LWUIT Version");
		
		form.addCommand(exitCommand);
		form.addCommand(sayMaybeCommand);
		form.addCommand(sayNoCommand);
		form.addCommand(sayYesCommand);
		
		form.addCommandListener(this);
		
		form.show();
	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {
	}

	public void actionPerformed(ActionEvent event) {
		Command command = event.getCommand();
		int commandId = command.getId();
		switch(commandId) {
			case EXIT_COMMAND_ID:
				notifyDestroyed();
				break;
			case SAY_YES_COMMAND_ID:	
				sayYes();
				break;
			case SAY_NO_COMMAND_ID:
				sayNo();
				break;
			case SAY_MAYBE_COMMAND_ID:
				sayMaybe();
				break;
		}
				
	}

	private void sayMaybe() {
		Dialog.show("Maybe Command", "Maybe... :|", OK, null);
	}

	private void sayNo() {
		Dialog.show("No Command", "No! :(", OK, null);
	}

	private void sayYes() {
		Dialog.show("Yes Command", "Yes! :)", OK, null);
	}
	
}
