package projectBFS;

import java.util.*;
class AhoCorasick2 {
    static final int ALPHABET_SIZE = 32;
    Node[] nodes;
    int nodeCount;
    public static class Node {
        int parent;
        char charFromParent;
        int suffLink = -1;
        int[] children = new int[ALPHABET_SIZE];
        int[] transitions = new int[ALPHABET_SIZE];
        boolean leaf;
        {
            Arrays.fill(children, -1);
            Arrays.fill(transitions, -1);
        }
    }
    public AhoCorasick2(int maxNodes) {
        nodes = new Node[maxNodes];
        // create root
        nodes[0] = new Node();
        nodes[0].suffLink = 0;
        nodes[0].parent = -1;
        nodeCount = 1;
    }
    public void addString(String s) {
        int cur = 0;
        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            if (nodes[cur].children[c] == -1) {
                nodes[nodeCount] = new Node();
                nodes[nodeCount].parent = cur;
                nodes[nodeCount].charFromParent = ch;
                nodes[cur].children[c] = nodeCount++;
            }
            cur = nodes[cur].children[c];
        }
        nodes[cur].leaf = true;
    }
    public int suffLink(int nodeIndex) {
        Node node = nodes[nodeIndex];
        if (node.suffLink == -1)
            node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
        return node.suffLink;
    }
    public int transition(int nodeIndex, char ch) {
        int c = ch - 'a';
        Node node = nodes[nodeIndex];
        if (node.transitions[c] == -1)
            node.transitions[c] = node.children[c] != -1 ? node.children[c] : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
        return node.transitions[c];
    }
    public int Menu()
    {
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        int take;
        boolean go=true;
        String str = "";
        String s = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Menu:\n");
            System.out.print  ("enter action\n");
            System.out.println("1.enter text\n");
            System.out.println("2.Enter string\n");
            System.out.println("3.Processing Text\n");
            System.out.println("4.Exit\n");
            take = in.nextInt();
            switch(take) {
                case 1:
                    System.out.println("Enter text\n");
                    s = in.next();
                    break;
                case 2:
                    System.out.println("Enter string\n");
                    str = in.next();
                    addString(str);
                    break;
                case 3:
                    for (int i = 0; i < s.length(); i++) {
                        node = transition(node, s.charAt(i));
                        if (nodes[node].leaf)
                            positions.add(i);
                    }
                    System.out.println(positions);
                    break;
                case 4:
                    go=false;
                    break;
                default:
                    ;
                    break;
            }
           } while (go);

        return 0;
    }
    // Usage example
}
