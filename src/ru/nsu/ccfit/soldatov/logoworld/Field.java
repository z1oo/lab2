package ru.nsu.ccfit.soldatov.logoworld;

import java.util.List;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
/**
 * Created by Zloo on 22.04.2017.
 */
public class Field {
    private int[][] field;

    class AI{
        private int[] coord;
        private boolean fdraw = false;
        AI(int[] arg){
            coord = arg.clone();
            field[coord[2]][coord[3]] = 1;
        }
        void draw(){
            fdraw = true;
        }
        void ward(){
            fdraw = false;
        }
        void setCoord(int x, int y){
            field[coord[2]][coord[3]] = 0;
            coord[2] = x;
            coord[3] = y;
            field[coord[2]][coord[3]] = 1;
        }
    }

    private AI ai;

    public void initfield(List<String> cmdArguments){
        int[] arg;
        arg = new int[cmdArguments.size()];
        int k = 0;
        for(String state : cmdArguments){
            arg[k] = Integer.parseInt(state);
            k++;
        }
        field = new int[arg[0]][arg[1]];
        ai = new AI(arg);
        for (int[] aField : field) {
            for (int anAField : aField) {
                System.out.print(anAField + " ");
            }
            System.out.println();
        }


    }

    public void aiDraw(){
        ai.draw();
    }

    public void aiWard(){
        ai.ward();
    }

    public void aiTeleport(List<String> cmdArguments) throws CommandExecuteException {
        int[] arg;
        arg = new int[cmdArguments.size()];
        int k = 0;
        for(String state : cmdArguments) {
            arg[k] = Integer.parseInt(state);
            k++;
        }
        if(arg[0] >= field.length || arg[1] >= field[0].length) throw new CommandExecuteException("Error value of arguments.");
        ai.setCoord(arg[0],arg[1]);
        for (int[] aField : field) {
            for (int anAField : aField) {
                System.out.print(anAField + " ");
            }
            System.out.println();
        }
    }
}
