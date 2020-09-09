package com.tomasdozo.todolist;

import java.io.*;
import java.util.*;

public class ToDoListRepositoryLocal extends ToDoListRepository {

    private List<ToDoItem> datos;
    private static final ToDoListRepositoryLocal instance = new ToDoListRepositoryLocal();

    private ToDoListRepositoryLocal(){
        datos=new ArrayList<>();
        loadFile();


    }

    public static ToDoListRepository getInstance (){
        return instance;
    }

    public List<ToDoItem> get(){

        List<ToDoItem> lista=new ArrayList<>();
        ToDoItem aux;


        for (ToDoItem toDoItem : datos) {
            aux=new ToDoItem(toDoItem.getText(),toDoItem.getId(),toDoItem.getDone());
            lista.add(aux);
        }

        Collections.reverse(lista);

        return lista;
    }
    @Override
    public ToDoItem search(int id) {
        ToDoItem aux=null;
        if(!datos.isEmpty()){
            int i =0;
            aux=datos.get(i);
            i++;
            while(i<datos.size()&&aux.getId()!=id){
                aux=datos.get(i);
                i++;
            }
            if(aux.getId()!=id){
                aux=null;
            }
        }
        return aux;
    }

    @Override
    public boolean set(ToDoItem item) {
        int i=0;
        boolean sucess=false;
        ToDoItem aux;
        if(!datos.isEmpty()){
            aux=datos.get(i);
            i++;
            while(i<datos.size()&&aux.getId()!=item.getId()){
                aux=datos.get(i);
                i++;
            }
            if(aux.getId()==item.getId()){
                datos.set(i-1,item);
                sucess=true;
            }
        }
        updateFile();
        return sucess;
    }

    @Override
    public void add(ToDoItem item) {
        //Asignar un id aleatorio al nuevo item
        item.setId(Math.abs(new Random().nextInt()));

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
        updateFile();
    }

    private void updateFile(){
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
    private void loadFile(){
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
        }catch (FileNotFoundException e){
            System.out.println("Base de Datos no encontrada, creando nueva...");
            updateFile();
            System.out.println("Nueva base de datos creada.");
        }
        catch (IOException e) {
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

        updateFile();
        return sucess;
    }

    @Override
    public int size() {
        return datos.size();
    }
}
