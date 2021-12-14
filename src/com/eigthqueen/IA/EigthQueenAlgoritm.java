package com.eigthqueen.IA;

import java.util.ArrayList;

import com.eigthqueen.stuff.Operation;
public class EigthQueenAlgoritm {

	static ArrayList<String> tables = new ArrayList<>();
    public static Operation operation = new Operation();
    static ArrayList<Integer> aptitud_functionals = new ArrayList<>();
    static ArrayList<String> fathers_selected = new ArrayList<>();
    static ArrayList<String> fathers_mutados = new ArrayList<>();
    static ArrayList<String> children_generated = new ArrayList<>();
    private static ArrayList<String> uniform_mutation = new ArrayList<>();
    private static ArrayList<String> new_poblation = new ArrayList<>();
    static int one;
    static int two;

    public static String run(){
    	for (int i = 0; i < 100; i++) {
            String binary = stringBinary();
            tables.add(binary);
        }
        //tables.forEach(System.out::println);
        for (int z = 0; z < 1000000; z++) {
            System.out.println("GEneracion :"+z);
            for (String table : tables) {
                aptitud_functionals.add(operation.Aptitud_function(table));
            }
            if (operation.verifyAptitudesFromList()) {
                
                System.out.println("Encuetra 0: "+operation.tablero_aptitud.get(0).getTrablero()+" generacion "+z);
                break;
            }
            for (int i = 0; i < 60; i++) {
                one = (int) (Math.random() * ((9 - 0) + 1) + 0);
                two = (int) (Math.random() * ((9 - 0) + 1) + 0);
                int aptitude1 = aptitud_functionals.get(one);
                int aptitude2 = aptitud_functionals.get(two);
                if (aptitude1 < aptitude2) {
                    fathers_selected.add(tables.get(one));
                } else {
                    fathers_selected.add(tables.get(two));
                }
            }
            for (int i = 0; i < 40; i++) {
                one = (int) (Math.random() * ((9 - 0) + 1) + 0);
                two = (int) (Math.random() * ((9 - 0) + 1) + 0);

                int aptitude1 = aptitud_functionals.get(one);
                int aptitude2 = aptitud_functionals.get(two);
                if (aptitude1 < aptitude2) {
                    fathers_mutados.add(tables.get(one));
                } else {
                    fathers_mutados.add(tables.get(two));
                }
            }
            for (int i = 0; i < 30; i++) { //30 is because in each loop is generated 2 new children
                int neurona_random1 = (int) (Math.random() * ((6 - 0)) + 0);
                int neurona_random2 = (int) (Math.random() * ((6 - 0)) + 0);
                String neurona1 = fathers_selected.get(neurona_random1);
                String neurona2 = fathers_selected.get(neurona_random2);
                //System.out.println("++++ " + neurona_random2);

                int point_one = (int) (Math.random() * ((12 - 0) + 1) + 0);//
                int point_two = (int) (Math.random() * (23 - (point_one + 1)) + 1) + point_one;
                String new_children1 = neurona1.substring(0, point_one + 1) + "" + neurona2.substring(point_one + 1, point_two) + neurona1.substring(point_two, neurona1.length());
                String new_children2 = neurona2.substring(0, point_one + 1) + "" + neurona1.substring(point_one + 1, point_two) + neurona2.substring(point_two, neurona2.length());
                children_generated.add(new_children1);
                children_generated.add(new_children2);
            }
            for (int i = 0; i < 40; i++) {
                int index = (int) (Math.random() * (((tables.size() - 1) - 0) + 1) + 0);
                String neurona = tables.get(index);
                StringBuilder new_neurona = new StringBuilder();
                //System.out.println("Actual: " + neurona);
                for (int j = 0; j <= neurona.length() - 1; j++) {
                    double random = Math.random();
                    if (random > 0.5) {
                        //System.out.println(neurona.charAt(j));
                        new_neurona.append((neurona.charAt(j) == '1') ? "0" : "1");
                    } else {
                        new_neurona.append(neurona.charAt(j));
                    }
                }
                uniform_mutation.add(new_neurona.toString());
                //System.out.println("Before: " + new_neurona.toString());
            }
            ArrayList<String> children_generated_and_uniform_mutation = new ArrayList<>();
            children_generated_and_uniform_mutation.addAll(children_generated);
            children_generated_and_uniform_mutation.addAll(uniform_mutation);
            for (int i = 0; i < 20; i++) {
                            int index = (int) (Math.random() * ((99 - 0) + 1) + 0);
                            new_poblation.add(tables.get(index));
            }
            for (int i = 0; i < 80; i++) {
                int index = (int) (Math.random() * ((99 - 0) + 1) + 0);
                new_poblation.add(children_generated_and_uniform_mutation.get(index));
            }
            tables.clear();
            operation.tablero_aptitud.clear();
            aptitud_functionals.clear();
            //tables.addAll(uniform_mutation);
            tables.addAll(new_poblation);
            new_poblation.clear();
            //tables.addAll(children_generated);
            uniform_mutation.clear();
            children_generated.clear();
            fathers_mutados.clear();
            fathers_selected.clear();
            //tables.clear();
            //tables.addAll(new_poblation);
        }

        //System.out.println("HI");
        //tables.forEach(System.out::println);
        return operation.tablero_aptitud.get(0).getTrablero();
    }

    public static String stringBinary() {
        int upperBound = 1;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        String binary = "";
        for (int i = 0; i < 24; i++) {
            int random = (int) (Math.random() * range) + lowerBound;
            binary = String.format("%s" + binary, random);
        }
        return binary;
    }

}
