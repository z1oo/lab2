package ru.nsu.ccfit.soldatov.logoworld;

import java.util.List;
import ru.nsu.ccfit.soldatov.logoworld.exeptions.*;
/**
 * Created by Zloo on 22.04.2017.
 */
public class Field {
    private char[][] field;

    class AI{
        private int[] coord;
        private char oldState;
        private boolean fdraw = false;
        AI(int[] arg){
            coord = arg.clone();
            oldState = field[coord[2]][coord[3]];
            field[coord[2]][coord[3]] = 'A';
        }
        void draw(){
            fdraw = true;
        }
        void ward(){
            fdraw = false;
        }
        void setCoord(int x, int y){
            field[coord[2]][coord[3]] = oldState;
            coord[2] = x;
            coord[3] = y;
            oldState = field[coord[2]][coord[3]];
            field[coord[2]][coord[3]] = 'A';
        }
        private void moveCoordX(char course){
            field[coord[2]][coord[3]] = fdraw ? '0' : oldState;
            switch (course){
                case 'f': coord[2] = (coord[2]+1)%field.length; break;
                case 'b': coord[2] = (coord[2]-1+ field.length)%field.length; break;
            }
            oldState = field[coord[2]][coord[3]];
            field[coord[2]][coord[3]] = 'A';
        }
        private void moveCoordY(char course){
            field[coord[2]][coord[3]] = fdraw ? '0' : oldState;
            switch (course){
                case 'f': coord[3] = (coord[3]+1)%field[0].length; break;
                case 'b': coord[3] = ( coord[3]-1+ field[0].length)%field[0].length; break;
            }
            oldState = field[coord[2]][coord[3]];
            field[coord[2]][coord[3]] = 'A';
        }
        void move(char axis,char course,int step){
            switch (axis){
                case 'x':
                    for (int i=0; i < step;++i ){
                        moveCoordX(course);
                    }
                    break;
                case 'y':
                    for (int i=0; i < step;++i ){
                        moveCoordY(course);
                    }
                    break;
            }
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
        field = new char[arg[0]][arg[1]];
        for (int i=0;i < field.length;++i){
            for (int j=0;j < field[i].length;++j){
                field[i][j] = '+';
            }
        }
        ai = new AI(arg);
       printField();


    }
    public void printField(){
        for (char[] aField : field) {
            for (char anAField : aField) {
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
        printField();
    }

    public void aiMove(String arg, int step)throws CommandExecuteException{
        switch (arg){
            case "L": ai.move('y','b',step);break;
            case "R": ai.move('y','f',step);break;
            case "D": ai.move('x','f',step);break;
            case "U": ai.move('x','b',step);break;
            default:
                throw new CommandExecuteException("Error value of arguments. Use [L|R|U|D] <steps>");
        }
        printField();
    }
}
