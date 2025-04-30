package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<SumDif> arbSad = new BinaryTree<SumDif>();
        if(!arbol.isEmpty()){
            this.sumAndDif(arbol, arbSad,0,0);
        }
        return arbSad;
    }

    private void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<SumDif> arbSad,int sum,int padre){
        int datoActual = arbol.getData();
        SumDif sad = new SumDif(datoActual+sum, datoActual- padre);
        arbSad.setData(sad);
        if(arbol.hasLeftChild()){
            arbSad.addLeftChild(new BinaryTree<SumDif>());
            sumAndDif(arbol.getLeftChild(),arbSad.getLeftChild(), sum+datoActual, datoActual);
        }
        if(arbol.hasRightChild()){
            arbSad.addRightChild(new BinaryTree<SumDif>());
            sumAndDif(arbol.getRightChild(),arbSad.getRightChild(), sum+datoActual,datoActual);
        }
    }
}
