package com.chuque.groupr;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Groupr<T> {

    private ArrayList<T> initialList;
    private HashMap<Object, ArrayList<T>> groupedMap;
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

        group();
    }

    public HashMap<Object, ArrayList<T>> getGroupedMap() {
        return groupedMap;
    }

    private void group(){
        groupedMap = new HashMap<>();

        for(T item : initialList){
            Object keyName = new Object();
            try {
                Field field = item.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                keyName = field.get(item);
            } catch (NoSuchFieldException | IllegalAccessException e) {
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

    private void groupWithStream(){
        //TODO implementar agrupamento por Streams
        groupedMap = new HashMap<>();

        Stream<ArrayList<T>> stream = Stream.of(this.initialList);
    }


}
