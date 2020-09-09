package com.tomasdozo.todolist;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

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
        datos.set(item.getId(), item);
        actualizarArchivo();
    }

    @Override
    public void add(ToDoItem item) {
        //Asignar un id aleatorio al nuevo item
        item.setId(new Random().nextInt());

        //Verificar que el nuevo id sea unico y no se encuentre en la lista
        if(!datos.isEmpty()){
            boolean idUnico=false;
            ToDoItem aux;
            while(!idUnico) {
                int i=0;
                aux= datos.get(i);
                while (i < datos.size() && aux.getId()!=item.getId()) {
                    aux = datos.get(i);
                    i++;
                }
                if(aux.getId()!=item.getId()){
                    idUnico=true;
                }
                else{
                    item.setId(new Random().nextInt());
                }
            }
        }

        //Verificado que es unico se añade el nuevo item y se actualiza la base
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
    public boolean remove(int id) {
        int i=0;
        boolean sucess=false;
        ToDoItem aux;
        if(!datos.isEmpty()){
            aux=datos.get(i);
            i++;
            while(i<datos.size()&&aux.getId()!=id){
                aux=datos.get(i);
                i++;
            }
            if(aux.getId()==id){
                datos.remove(i-1);
               sucess=true;
            }
        }

        actualizarArchivo();
        return sucess;
    }

    @Override
    public int size() {
        return datos.size();
    }
}
