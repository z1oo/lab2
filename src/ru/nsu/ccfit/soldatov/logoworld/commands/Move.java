package ru.nsu.ccfit.soldatov.logoworld.commands;

import ru.nsu.ccfit.soldatov.logoworld.Command;
import ru.nsu.ccfit.soldatov.logoworld.Field;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
import java.util.List;

/**
 * Created by Zloo on 22.04.2017.
 */
public class Move implements Command {
    @Override
    public void execute(Field field,List<String> cmdArguments) throws CommandExecuteException {
        if( cmdArguments.size() != 2 ) {
            throw new CommandExecuteException("Error count of arguments. Use [L|R|U|D] <steps>.");
        }
        String arg;
        arg = cmdArguments.get(0);
        int steps = Integer.parseInt(cmdArguments.get(1));
        if(arg.length() > 1 || steps < 0){
            throw new CommandExecuteException("Error value of arguments. Use [L|R|U|D] <steps>");
        }
        field.aiMove(arg,steps);
    }
}
