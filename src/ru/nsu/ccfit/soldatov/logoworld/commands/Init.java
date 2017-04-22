package ru.nsu.ccfit.soldatov.logoworld.commands;

import ru.nsu.ccfit.soldatov.logoworld.Command;
import ru.nsu.ccfit.soldatov.logoworld.Field;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
import java.util.List;

/**
 * Created by Zloo on 22.04.2017.
 */
public class Init implements Command {
    @Override
    public void execute(Field field,List<String> cmdArguments) throws CommandExecuteException {
        if( cmdArguments.size() != 4 ) throw new CommandExecuteException("Error count of arguments.");
        for(String state : cmdArguments){
            int i = Integer.parseInt(state);
            if( i < 0 ) throw new CommandExecuteException("Error of arguments.");
        }

        field.initfield(cmdArguments);


    }
}
