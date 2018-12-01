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

    public String showButtonPushed(int slot) {
        undoCommand = showCommands.getCommand(slot);
        return showCommands.getCommand(slot).execute();
    }

    public String hideButtonPushed(int slot) {
        undoCommand = hideCommands.getCommand(slot);
        return hideCommands.getCommand(slot).execute();
    }

    public String undoButtonPushed() {
        return undoCommand.execute();
    }
}
