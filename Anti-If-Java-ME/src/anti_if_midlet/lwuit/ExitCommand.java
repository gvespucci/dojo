package anti_if_midlet.lwuit;

import javax.microedition.midlet.MIDlet;

public class ExitCommand extends AntiIfCommand {

	private final MIDlet midlet;

	public ExitCommand(MIDlet miDlet) {
		super("Exit");
		this.midlet = miDlet;
	}

	public void execute() {
		midlet.notifyDestroyed();
	}

}
