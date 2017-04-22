package ru.nsu.ccfit.soldatov.logoworld;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.TreeMap;
/**
 * Created by Zloo on 22.04.2017.
 */
class ClassFactory {
    private static Properties properties = null;
    private static TreeMap<String, Class> classes = null;

    static {
        classes = new TreeMap<String, Class>();
        InputStream conformancesAsStream = null;

        try {
            conformancesAsStream = new FileInputStream("Factory.properties");
            properties = new Properties();
            properties.load(conformancesAsStream);
        } catch (IOException e) {
            System.out.println("IOException occurred in CommandsFactory.properties " + e.getLocalizedMessage());
        } finally {
            try {
                if (null != conformancesAsStream) {
                    conformancesAsStream.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Returns CalcCommand command that names cmdName.
     *
     * @param cmdName name of command.
     * @return CalcCommand object <code>command</code> if it exists.
     */
    public static Command getCommand(String cmdName) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        Command command;
        Class<?> cmdClass;

        String commandUp = cmdName.toUpperCase();

        String key = properties.getProperty(commandUp);
        if (null == key) {
            throw new NoSuchElementException("Invalid command request: " + commandUp);
        }
        if (!classes.containsKey(key)) {
            cmdClass = Class.forName(key);
            classes.put(cmdName, cmdClass);
        } else {
            cmdClass = classes.get(cmdName);
        }
        command = (Command) cmdClass.newInstance();

        return command;
    }

}
