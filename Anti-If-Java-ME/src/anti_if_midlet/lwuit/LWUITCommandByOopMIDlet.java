package anti_if_midlet.lwuit;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.sun.lwuit.Display;
import com.sun.lwuit.Form;

public class LWUITCommandByOopMIDlet extends MIDlet {

	public LWUITCommandByOopMIDlet() {
		Display.init(this);
	}

	protected void startApp() throws MIDletStateChangeException {
		Form form = new Form("Command-By-OOP-MIDlet");
		
		form.addCommand(new ExitCommand(this));
		form.addCommand(new SayMaybeCommand());
		form.addCommand(new SayNoCommand());
		form.addCommand(new SayYesCommand());
		
		form.show();
	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {
	}
}
