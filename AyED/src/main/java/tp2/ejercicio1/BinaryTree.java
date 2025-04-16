package tp2.ejercicio1;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
    public BinaryTree(T data) {
        this.data = data;
        this.leftChild= null;
        this.rightChild=null;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    public BinaryTree<T> getRightChild() {
        return rightChild;
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

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
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
        String dataLengthSpacing = " ".repeat(dataLength - 1);

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

        return "" + data;
    }
    public int contarHojas() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;

        int hojasIzq = (leftChild != null) ? leftChild.contarHojas() : 0;
        int hojasDer = (rightChild != null) ? rightChild.contarHojas() : 0;

        return hojasIzq + hojasDer;
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> espejo = new BinaryTree<>(this.data);
        if (this.leftChild != null)
            espejo.addRightChild(this.leftChild.espejo());
        if (this.rightChild != null)
            espejo.addLeftChild(this.rightChild.espejo());
        return espejo;
    }

    public void entreNiveles(int n, int m) {
        if (this.isEmpty()) return;

        java.util.Queue<BinaryTree<T>> cola = new java.util.LinkedList<>();
        java.util.Queue<Integer> niveles = new java.util.LinkedList<>();

        cola.add(this);
        niveles.add(0);

        while (!cola.isEmpty()) {
            BinaryTree<T> actual = cola.poll();
            int nivel = niveles.poll();

            if (nivel >= n && nivel <= m) {
                System.out.println(actual.getData());
            }

            if (actual.hasLeftChild()) {
                cola.add(actual.getLeftChild());
                niveles.add(nivel + 1);
            }

            if (actual.hasRightChild()) {
                cola.add(actual.getRightChild());
                niveles.add(nivel + 1);
            }
        }
    }

}

