package com.chuque.groupr;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Groupr<T> {

    private ArrayList<T> initialList;
    private HashMap<String, ArrayList<T>> groupedMap;
    private String fieldName;

    public Groupr(ArrayList<T> list, String orderBy) {
        this.initialList = list;
        this.fieldName = orderBy;

        /*Class<?> className = initialList.get(0).getClass();
        System.out.println(className);

        //nome dos atributos
        for(Field field : className.getDeclaredFields()){
            System.out.println(field.getName());
        }*/

        //exibe lista desordenada
        System.out.println("Desordenada:");
        for(Object item : initialList){
            System.out.println(item.toString());
        }

        group();

        //exibe lista ordenada
        System.out.println("Ordenada:");
        for (Map.Entry<String, ArrayList<T>> entry : groupedMap.entrySet()){
            System.out.println("Chave: " + entry.getKey());
            for (Object item : entry.getValue()){
                System.out.println(item.getClass());
            }
        }
    }

    public HashMap<String, ArrayList<T>> getGroupedMap() {
        return groupedMap;
    }

    private void group(){
        groupedMap = new HashMap<>();

        for(T item : initialList){
            String keyName = new String();
            try {
                Field field = item.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                keyName = (String)field.get(item);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if(groupedMap.containsKey(keyName)){
                groupedMap.get(keyName).add(item);
            } else {
                ArrayList<T> list = new ArrayList<>();
                list.add(item);
                groupedMap.put(keyName, list);
            }
        }
    }
}
