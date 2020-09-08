package com.tomasdozo.todolist;

import java.io.*;
import java.util.ArrayList;

public class ToDoListRepositoryLocal extends ToDoListRepository {

    private ArrayList<ToDoItem> datos;
    private static final ToDoListRepositoryLocal instance = new ToDoListRepositoryLocal();

    private ToDoListRepositoryLocal(){
        datos=new ArrayList<>();
        cargarArchivo();


    }

    public static ToDoListRepository getInstance (){
        return instance;
    }

    @Override
    public ToDoItem get(int index) {

        return datos.get(index);
    }

    @Override
    public void set(ToDoItem item) {
        datos.set(item.getIndex(), item);
        actualizarArchivo();
    }

    @Override
    public void add(ToDoItem item) {
        item.setIndex(datos.size());
        datos.add(item);

        actualizarArchivo();
    }

    private void actualizarArchivo(){
        //Guardar la lista
        try {
            FileOutputStream fos = new FileOutputStream(new File(".").getAbsolutePath() + File.separator + "datos");
            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(datos);
                oos.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarArchivo(){
        //Cargar la lista
        try {
            FileInputStream in= new FileInputStream (new File(".").getAbsolutePath() + File.separator + "datos");
            ObjectInputStream ois = new ObjectInputStream(in);
            try {
                datos = (ArrayList<ToDoItem>) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void remove(ToDoItem item) {
        datos.remove(item.getIndex());

    }

    @Override
    public int size() {
        return datos.size();
    }
}
