package ru.nsu.ccfit.soldatov.logoworld.commands;
import ru.nsu.ccfit.soldatov.logoworld.Command;
import ru.nsu.ccfit.soldatov.logoworld.Field;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
import java.util.List;

/**
 * Created by Zloo on 22.04.2017.
 */
public class Teleport implements Command {
    @Override
    public void execute(Field field,List<String> cmdArguments) throws CommandExecuteException {
        if( cmdArguments.size() != 2 ) throw new CommandExecuteException("Error count of arguments.");

        try {
            field.aiTeleport(cmdArguments);
        }catch (Throwable e) {
            System.err.println("Error execute command: " + e.getLocalizedMessage());
        }
    }
}
