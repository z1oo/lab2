package ru.nsu.ccfit.soldatov.logoworld;

import java.util.List;

/**
 * Created by Zloo on 22.04.2017.
 */
public class Field {
    private int[][] field;

    class AI{
        private int[] coord;
        AI(int[] arg){
            coord = arg.clone();
            field[arg[2]][arg[3]] = 1;
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
        //System.out.println(field.length);
        for (int[] aField : field) {
            for (int anAField : aField) {
                System.out.print(anAField + " ");
            }
            System.out.println();
        }
    }

}
