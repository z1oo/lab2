package ru.nsu.ccfit.soldatov.logoworld;
import java.util.List;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
/**
 * Created by Zloo on 22.04.2017.
 */
public interface Command {
    public void execute(Field field, List<String> cmdArguments ) throws CommandExecuteException;
}
