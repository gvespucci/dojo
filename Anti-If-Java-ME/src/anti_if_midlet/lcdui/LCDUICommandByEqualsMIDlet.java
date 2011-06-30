package anti_if_midlet.lcdui;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class LCDUICommandByEqualsMIDlet extends MIDlet implements CommandListener {

	private Command exitCommand = new Command("Exit",Command.EXIT, 1);
	private Command sayYesCommand = new Command("Say Yes", Command.SCREEN, 2);
	private Command sayNoCommand = new Command("Say No", Command.SCREEN, 3);
	private Command sayMaybeCommand = new Command("Say Maybe", Command.SCREEN, 4);

	public LCDUICommandByEqualsMIDlet() {
	}
	
	protected void startApp() throws MIDletStateChangeException {
		Form form = new Form("Command-By-Equals-MIDlet - LCDUI Version");
		
		form.addCommand(exitCommand);
		form.addCommand(sayMaybeCommand);
		form.addCommand(sayNoCommand);
		form.addCommand(sayYesCommand);
		
		form.setCommandListener(this);
		
		Display.getDisplay(this).setCurrent(form);
	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {
	}

	private void sayMaybe() {
		Alert alert = new Alert("Maybe command", "Maybe... :|", null, AlertType.CONFIRMATION);
		Display.getDisplay(this).setCurrent(alert);
	}

	private void sayNo() {
		Alert alert = new Alert("No command", "No! :(", null, AlertType.CONFIRMATION);
		Display.getDisplay(this).setCurrent(alert);
	}

	private void sayYes() {
		Alert alert = new Alert("Yes command", "Yes! :)", null, AlertType.CONFIRMATION);
		Display.getDisplay(this).setCurrent(alert);
	}

	public void commandAction(Command command, Displayable displayable) {
		if(command == exitCommand) {
			notifyDestroyed();
		} else
		if(command == sayYesCommand) {
			sayYes();
		} else
		if(command == sayNoCommand) {
			sayNo();
		}
		else
		if(command == sayMaybeCommand) {
			sayMaybe();
		}
	}
}

