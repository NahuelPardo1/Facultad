package tp2.ejercicio1;


import tp1.ejercicio8.Queue;

import java.util.*;

public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }

    public  int contarHojas() {
        int leftC =0;
        int rightC=0;
        if(this.isEmpty())return 0;
        else if(this.isLeaf())return 1;
        else{
            if(this.hasLeftChild())
                leftC = this.getLeftChild().contarHojas();
            if(this.hasRightChild())
                rightC= this.getRightChild().contarHojas();
            return leftC+rightC;
        }
    }

    public BinaryTree<T> espejo(){
        BinaryTree<T> arbEspejo= new BinaryTree<T>(this.getData());
        if(this.hasLeftChild()){
            arbEspejo.addRightChild(this.getLeftChild().espejo());
        }
        if(this.hasRightChild()){
            arbEspejo.addLeftChild(this.getRightChild().espejo());
        }
        return arbEspejo;

    }

    // 0<=n<=m
    public void entreNiveles(int n, int m){
        if(this.isEmpty()|| n<0|| m<n) return;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        int nivelActual= 0;
        while(!cola.isEmpty()){
            int nodoNivel = cola.size();
            if(nivelActual>=n && nivelActual<=m){
                for(int i=0; i<nodoNivel; i++){
                    BinaryTree<T> nodo = cola.dequeue();
                    System.out.println(nodo.getData()+" | ");
                    if(nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
                }
            }else{
                for(int i=0;i<nodoNivel;i++){
                    cola.dequeue();
                }
            }
            nivelActual++;
            System.out.println("");
        }
    }
    @Override
    public String toString() {
        return toString("", SON_STATUS.NONE);
    }

    private enum SON_STATUS {
        NONE, UP, DOWN;
    }
    public String toString(String spacing, SON_STATUS sonstat) {
        if (this.isLeaf())
            return spacing + data;

        int dataLength = getData().toString().length();
        String dataLengthSpacing = " ".repeat(dataLength-1);

        String upperSpacing = spacing + (sonstat == SON_STATUS.DOWN ? "║   " : "    ") + dataLengthSpacing;
        String downSpacing = spacing + (sonstat == SON_STATUS.UP ? "║   " : "    ") + dataLengthSpacing;

        if (this.hasLeftChild() && this.hasRightChild())
            return this.getLeftChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╣\n" +
                    this.getRightChild().toString(downSpacing, SON_STATUS.DOWN);
        if (this.hasLeftChild() && !this.hasRightChild())
            return this.getLeftChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╝";
        if (!this.hasLeftChild() && this.hasRightChild())
            return spacing + data + " ══╗\n" +
                    this.getRightChild().toString(downSpacing, SON_STATUS.DOWN);

        return ""+data;
    }

    public static void main(String[] args) {
        System.out.println("Test metodos Arboles");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        //ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        System.out.println(ab.contarHojas());
        System.out.println("Arbol original: ");
        System.out.println(ab.toString());
        System.out.println("Arbol espejo: ");
        BinaryTree<Integer> abEspejo = ab.espejo();
        System.out.println(abEspejo.toString());
        System.out.println("Impresion Arbol por niveles 0 y 1");
        ab.entreNiveles(0, 2);
    }

}

