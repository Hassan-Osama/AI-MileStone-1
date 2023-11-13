package code.strategy;

import code.Node;
import code.SearchStrategy;
import java.util.*;


public class DFStrategy<S> extends SearchStrategy<S>{
    Stack<Node<S>> stack =new Stack<>();

    Set<S> s = new HashSet<>();


    @Override
    public Node<S> removeFront() {
        return stack.pop();
    }

    @Override
    public void addNewNodes(List<Node<S>> nodes) {
        List<Node<S>> filtered = nodes.stream().filter(n -> !s.contains(n.state)).toList();
        stack.addAll(filtered);
        s.addAll(filtered.stream().map(n -> n.state).toList());
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
