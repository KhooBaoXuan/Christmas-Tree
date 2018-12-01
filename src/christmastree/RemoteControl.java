package christmastree;

public class RemoteControl {
    CommandList showCommands;
    CommandList hideCommands;

    Command undoCommand;

    public RemoteControl() {
        showCommands = new CommandList();
        hideCommands = new CommandList();

    }

    public void setCommand(Command showCommand, Command hideCommand) {
        showCommands.addCommand(showCommand);
        hideCommands.addCommand(hideCommand);
    }

    public void showButtonPushed(int slot) {
        showCommands.getCommand(slot).execute();
        undoCommand = showCommands.getCommand(slot);
    }

    public void hideButtonPushed(int slot) {
        hideCommands.getCommand(slot).execute();
        undoCommand = hideCommands.getCommand(slot);
    }

    public void undoButtonPushed() {
        undoCommand.execute();
    }
}
