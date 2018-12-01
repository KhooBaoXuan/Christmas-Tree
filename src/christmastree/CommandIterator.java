package christmastree;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandIterator implements Iterator{

    ArrayList<Command> commands;

    public Iterator<Command> getIterator() {
        return commands.iterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
