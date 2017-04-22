package ru.nsu.ccfit.soldatov.logoworld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printCommands();
        Field field = new Field();
        Scanner scanner = getScanner(args);
        assert null != scanner;


        while (scanner.hasNextLine()) {
            String commandStr = scanner.nextLine();
            commandStr = clearString(commandStr);
            if (isInsignificantCommand(commandStr)) {
                continue;
            }

            executeCommand(field,commandStr);

        }
        scanner.close();

    }

    private static void executeCommand(Field field,String commandStr) {
        String cmd[] = commandStr.split(" ");
        List<String> cmdArguments = createCmdArguments(cmd);

        try {
            Command command = ClassFactory.getCommand(cmd[0]);
            command.execute(field,cmdArguments);
        } catch (Throwable e) {
            System.err.println("Error execute command: " + e.getLocalizedMessage());

        }
    }

    private static List<String> createCmdArguments(String[] cmd) {
        assert null != cmd;
        return new ArrayList<String>(Arrays.asList(cmd).subList(1, cmd.length));
    }

    private static boolean isInsignificantCommand(String command) {
        return command.equals("");
    }

    private static Scanner getScanner(String[] args) {
        assert null != args;
        Scanner scanner = null;
        if (1 == args.length) {
            String fileName = args[0];

            try {
                InputStream inputStream = new FileInputStream(fileName);
                scanner = new Scanner(inputStream);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }

        } else {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    private static String clearString(String str) {
        return str.trim().replaceAll("\\s+", " ");
    }

    private static void printCommands()
    {
        String str = "COMMANDS REFERENCE\n" +
                "1)INIT <width> <height> <x> <y> - init fields  ;\n" +
                "2)MOVE [L|R|U|D] <steps> - перемещат АИ по направлению\n" +
                "3)DRAW - АИ переходит в состояние рисования.\n" +
                "4)WARD - АИ выходит из состояния рисования.\n" +
                "5)TELEPORT <x> <y> - АИ перемещается в указанную координату\n";
        System.out.println(str);
    }


}

