package com.somesh.sbmaven.collections;

import java.util.ArrayList;

public class CustomArrayList extends ArrayList {

    @Override
    public boolean add(Object e) {
        if(this.contains (e)){
            return true;
        } else {
            return super.add (e);
        }
    }

    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList ();
        customArrayList.add (1);
        customArrayList.add (1);
        customArrayList.add (2);
        customArrayList.add (1);
        customArrayList.add (4);
        customArrayList.add (1);

        System.out.println (customArrayList);
    }
}
