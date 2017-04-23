package ru.nsu.ccfit.soldatov.logoworld.commands;

import ru.nsu.ccfit.soldatov.logoworld.Command;
import ru.nsu.ccfit.soldatov.logoworld.Field;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
import java.util.List;

/**
 * Created by Zloo on 22.04.2017.
 */
public class Draw implements Command {

    public void execute(Field field,List<String> cmdArguments) throws CommandExecuteException {
        if( cmdArguments.size() != 0 ) throw new CommandExecuteException("Error count of arguments.");
        field.aiDraw();
    }

}
