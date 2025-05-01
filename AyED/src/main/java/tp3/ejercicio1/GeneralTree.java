package tp3.ejercicio1;

import tp1.ejercicio8.Queue;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {

		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	@Override
	public String toString() {
		// base: no children
		if (isLeaf())
			return isEmpty() ? "Null" : data.toString();
		return toString("");
	}

	public String toString(String prefix) {
		if (isLeaf())
			return toString();

		String data = getData() == null ? "Null" : getData().toString();
		prefix+= " ".repeat(data.length() + 2);

		// base case: only 1 children
		if (getChildren().size() == 1)
			return data + " ══ " + getChildren().getFirst().toString(prefix);

		// exception case: multiple children (funny part)
		StringBuilder toReturn = new StringBuilder();
		toReturn.append(data).append(" ═");

		for (int i = 0; i < getChildren().size(); i++) {
			// is it the first?
			if (i == 0)
				toReturn.append("╦ ")
						.append(getChildren().get(i).toString(prefix + "║ "))
						.append("\n");
			else
			if (i == getChildren().size() - 1) // which is not 0
				toReturn.append(prefix)
						.append("╚ ")
						.append(getChildren().get(i).toString(prefix + "║ "));
			else
				toReturn.append(prefix)
						.append("╠ ")
						.append(getChildren().get(i).toString(prefix + "║ "))
						.append("\n");
		}

		return toReturn.toString();
	}
	
	public int altura() {	 
		int nivAct=0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()){
			aux= cola.dequeue();
			if(aux != null ){
				if(aux.hasChildren()){
					List<GeneralTree<T>> children;
					children = aux.getChildren();
					for(GeneralTree<T> child : children){
						cola.enqueue(child);
					}
				}
			}else{
				if(!cola.isEmpty()){
					cola.enqueue(null);
					nivAct++;
				}
			}
		}
		return nivAct;
	}
	
	public int nivel(T dato){
		int nivAct=0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()){
			aux= cola.dequeue();
			if(aux.getData().equals(dato)) return nivAct;
			if(aux != null ){
				if(aux.hasChildren()){
					List<GeneralTree<T>> children;
					children = aux.getChildren();
					for(GeneralTree<T> child : children){
						cola.enqueue(child);
					}
				}
			}else{
				if(!cola.isEmpty()){
					cola.enqueue(null);
					nivAct++;
				}
			}
		}
		return -1;
	  }

	public int ancho(){
		int maxCant=0;
		int nivAct=0;
		int cantNodos=0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()){
			aux= cola.dequeue();
			if(aux != null ){
				cantNodos++;
				if(aux.hasChildren()){
					List<GeneralTree<T>> children;
					children = aux.getChildren();
					for(GeneralTree<T> child : children){
						cola.enqueue(child);
					}
				}
			}else{
				if(!cola.isEmpty()){
					cola.enqueue(null);
					if(cantNodos>maxCant) maxCant=cantNodos;
					nivAct++;
					cantNodos=0;
				}
			}
		}
		return maxCant;
	}
}