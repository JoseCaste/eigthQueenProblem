package com.eigthqueen.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Operation {
	static ArrayList<int[]> indexes = new ArrayList<>();
    public static ArrayList<Tablero_FuncionAmplitud> tablero_aptitud = new ArrayList<>();
    private static int aptitude_functional = 0;
    public int Aptitud_function(String table) {
            aptitude_functional=0;
            //System.out.println(table);
            //String binary = tables.get(iz);
            String[] thisCombo2 = table.split("(?<=\\G.{" + 3 + "})");
            int index = 0;
            for (String thisCombo21 : thisCombo2) {
                int[] indexes_aux = {stringDecimal(thisCombo21), index};
                indexes.add(indexes_aux);
                index++;
            }
            /*indexes.forEach(aux -> {
                    System.out.println(String.format("(%d , %d)", aux[0], aux[1]));
                });*/
            for (int i = 0; i < thisCombo2.length; i++) {
                int row = indexes.get(i)[0];
                int col = indexes.get(i)[1];
                //System.out.println("Actual "+row+" "+col);
                //to above we need to verify if in -, |, /, \ there are another queen
                //verify col
                int count = 0;
                for (int[] aux : indexes) {
                    if (aux[1] == col) {
                        if (aux[0] != row) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }
                    }
                }
                //System.out.println("Vertical " + i + " es " + count);
                aptitude_functional += count;
                count = 0;
                //verify row
                for (int[] aux : indexes) {
                    if (aux[0] == row) {
                        if (aux[1] != col) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }
                    }
                }
                /*count = indexes.stream().
                        filter(aux -> aux[0] == row).filter(aux -> aux[1] != col).map(_item -> 1)
                        .reduce(count, Integer::sum);*/
                //System.out.println("Horizontal " + i + " es " + count);
                aptitude_functional += count;
                count = 0;

                int row_aux = row;
                int col_aux = col;
                //verify positive diagonal
                //to down
                for (int j = col_aux - 1; j >= 0; j--) {
                    row_aux++;
                    if (row_aux > 7) {
                        break;
                    }
                    //System.out.println(String.format("buscando abajo(%d , %d)", row_aux, j));
                    for (int[] aux : indexes) {
                        if (aux[0] == row_aux & aux[1] == j) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }
                    }
                }
                //aptitude_functional+=count;
                //to up
                row_aux = row;
                col_aux = col;
                for (int j = row_aux - 1; j >= 0; j--) {
                    col_aux++;
                    if (col_aux > 7) {
                        break;
                    }
                    //System.out.println(String.format("buscando arriba(%d , %d)", j, col_aux));
                    for (int[] aux : indexes) {
                        if (aux[0] == j && aux[1] == col_aux) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }

                    }
                }
                //System.out.println("Diagonal positiva " + i + " es " + count);
                aptitude_functional += count;
                count = 0;
                row_aux = row;
                col_aux = col;
                //verify negative diagonal
                //to down
                for (int j = row + 1; j <= 7; j++) {
                    col_aux++;
                    if (col_aux > 7) {
                        break;
                    }
                    //System.out.println(String.format("buscando abajo(%d , %d)", j, col_aux));
                    for (int[] aux : indexes) {
                        if (aux[0] == j && aux[1] == col_aux) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }

                    }
                }
                aptitude_functional+=count;
                count=0;
                //to up
                row_aux = row;
                col_aux = col;
                for (int j = col_aux - 1; j >= 0; j--) {
                    row_aux--;
                    if (row_aux < 0) {
                        break;
                    }
                    //System.out.println(String.format("buscando arriba(%d , %d)", row_aux, j));
                    for (int[] aux : indexes) {
                        if (aux[0] == row_aux & aux[1] == j) {
                            //System.out.println("Coincidencia (" + aux[0] + " , " + aux[1] + ")");
                            count++;
                        }
                    }
                }
                aptitude_functional += count;
        }
            indexes.clear();
            //System.out.println("++++ "+aptitude_functional);
            tablero_aptitud.add(new Tablero_FuncionAmplitud(table, aptitude_functional));
            return aptitude_functional;
    }

    private static int stringDecimal(String binary) {
        String[] bits = binary.split("");
        int position = 0;
        int aux = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i].equals("1")) {
                aux += Math.pow(2, position);
            }
            position++;
        }
        return aux;
    }

    public boolean verifyAptitudesFromList() {
        Collections.sort(tablero_aptitud, new Tablero_FuncionAmplitud());
        return tablero_aptitud.get(0).funcion_amplitud == 0;
    }
    public class Tablero_FuncionAmplitud implements Comparator<Tablero_FuncionAmplitud>, Comparable<Tablero_FuncionAmplitud> {

    private String trablero;
    private int funcion_amplitud;

    public Tablero_FuncionAmplitud() {
    }

    public Tablero_FuncionAmplitud(String trablero, int funcion_amplitud) {
        this.trablero = trablero;
        this.funcion_amplitud = funcion_amplitud;
    }

    public String getTrablero() {
        return trablero;
    }

    public void setTrablero(String trablero) {
        this.trablero = trablero;
    }

    public Integer getFuncion_amplitud() {
        return funcion_amplitud;
    }

    public void setFuncion_amplitud(Integer funcion_amplitud) {
        this.funcion_amplitud = funcion_amplitud;
    }

    @Override
    public int compareTo(Tablero_FuncionAmplitud o) {
        return (this.trablero).compareTo(o.trablero);
    }

    @Override
    public int compare(Tablero_FuncionAmplitud aux1, Tablero_FuncionAmplitud aux2) {
        return aux1.funcion_amplitud - aux2.getFuncion_amplitud();
    }

    @Override
    public String toString() {
        return "Tablero_FuncionAmplitud{" + "trablero=" + trablero + ", funcion_amplitud=" + funcion_amplitud + '}';
    }
}
}
