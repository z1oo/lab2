package ru.nsu.ccfit.soldatov.logoworld.exeptions;

/**
 * Created by Zloo on 22.04.2017.
 */
public class CommandExecuteException extends Exception {
    public CommandExecuteException()
    {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public CommandExecuteException(String message)
    {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public CommandExecuteException(String message, Throwable cause)
    {
        super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public CommandExecuteException(Throwable cause)
    {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

}
