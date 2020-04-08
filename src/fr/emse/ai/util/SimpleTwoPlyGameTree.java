package fr.emse.ai.util;

import java.util.ArrayList;
import java.util.List;

public class SimpleTwoPlyGameTree<V> {

    private V value;
    private boolean max;
    private ArrayList<SimpleTwoPlyGameTree<V>> children;

    public SimpleTwoPlyGameTree(V value, boolean max) {
        this.value = value;
        this.max = max;
        children = new ArrayList<SimpleTwoPlyGameTree<V>>();
    }

    public SimpleTwoPlyGameTree(V value, boolean max, List<SimpleTwoPlyGameTree<V>> children) {
        this(value, max);
        for (SimpleTwoPlyGameTree<V> child : children)
            this.children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isMax() {
        return max;
    }

    public void addChild(SimpleTwoPlyGameTree<V> child) {
        this.children.add(child);
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public ArrayList<SimpleTwoPlyGameTree<V>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SimpleTwoPlyGameTree<V>> children) {
        this.children = children;
    }

    public String toString() {
        String s = "";
        s += "value = " + value + " | ";
        s += "child = " + children;
        return s;
    }
}
