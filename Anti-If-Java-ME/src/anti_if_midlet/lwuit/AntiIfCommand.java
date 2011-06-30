package anti_if_midlet.lwuit;

import com.sun.lwuit.Command;
import com.sun.lwuit.events.ActionEvent;

public abstract class AntiIfCommand extends Command {

	protected static final String OK = "OK";

	public AntiIfCommand(String command) {
		super(command);
	}
	
	public void actionPerformed(ActionEvent evt) {
		execute();
	}
	
	public abstract void execute();
}
