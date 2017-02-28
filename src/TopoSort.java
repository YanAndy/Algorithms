/**
 * Created by andy on 2/2/17.
 */
import java.util.*;

public class TopoSort{
    private static class Node{
        public Object val;
        public int pathIn = 0;
        public Node(Object val){
            this.val = val;
        }
    }

    public static class Graph{
        public Set<Node> vertexSet = new HashSet<Node>();
        public Map<Node, Set<Node>> adjaNode = new HashMap<Node, Set<Node>>();

        public boolean addNode(Node start, Node end){
            if(!vertexSet.contains(start)) vertexSet.add(start);
            if(!vertexSet.contains(end)) vertexSet.add(end);
            if(adjaNode.containsKey(start) && adjaNode.get(start).contains(end)) return false;
            if(adjaNode.containsKey(start)) adjaNode.get(start).add(end);
            else{
                Set<Node> temp = new HashSet<Node>();
                temp.add(end);
                adjaNode.put(start, temp);
            }
            end.pathIn ++;
            return true;
        }
    }
    //Kahn

    public static class KahnTopo{
        private List<Node> result;
        private Queue<Node> setOfZeroDegree;
        private Graph graph;

        public KahnTopo(Graph di){
            this.graph = di;
            this.result = new ArrayList<Node>();
            this.setOfZeroDegree = new LinkedList<Node>();
            for(Node iterator: this.graph.vertexSet){
                if(iterator.pathIn == 0) this.setOfZeroDegree.add(iterator);
            }

        }


        private void process(){
            while(!setOfZeroDegree.isEmpty()){
                Node v = setOfZeroDegree.poll();
                result.add(v);
                if(this.graph.adjaNode.isEmpty()) return;

                if(this.graph.adjaNode.get(v) != null){
                    for(Node w : this.graph.adjaNode.get(v)){
                        w.pathIn --;

                        if(w.pathIn == 0) setOfZeroDegree.add(w);
                    }
                }
                this.graph.vertexSet.remove(v);
                this.graph.adjaNode.remove(v);
            }
            if(! this.graph.vertexSet.isEmpty()){
                throw new IllegalArgumentException("Has Cycle");
            }
        }

        public Iterable<Node> getResult(){
            return result;
        }
    }

    public static void main(String[] args){
        /*
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        Graph graph= new Graph();
        graph.addNode(A, B);
        graph.addNode(B, C);
        graph.addNode(B, D);
        graph.addNode(D, C);
        graph.addNode(E, C);
        graph.addNode(C, F);
        */
        HashMap<String, Node> map = new HashMap<String, Node>();
        HashSet<String> nodeSet = new HashSet<String>();
        Graph graph = new Graph();
        Scanner input = new Scanner(System.in);
        String line = "";
        //Node n1, n2;
        while(!(line = input.nextLine()).equals("end")){
            String[] str = line.split(" ");
            if(! nodeSet.contains(str[0])) nodeSet.add(str[0]);
            //System.out.println(str[0] + " " + str[1] + " " + str[2]);
            if(!map.containsKey(str[0]))
                map.put(str[0], new Node(str[0]));

            if(!map.containsKey(str[2]))
                map.put(str[2], new Node(str[2]));

            Node n1 = map.get(str[0]);
            Node n2 = map.get(str[2]);
            //System.out.println(n1.val + " " + n2.val);
            if(str[1].equals("writes")){
                System.out.println(n1.val + "->" + n2.val);
                graph.addNode(map.get(str[0]), map.get(str[2]));
            }else{
                System.out.println(n2.val + "-->" + n1.val);
                graph.addNode(map.get(str[2]), map.get(str[0]));
            }
        }
        /*

        for(Node n : graph.vertexSet){
            System.out.println(n.val);
        }


        for(Node n : graph.adjaNode.keySet()){
            System.out.println(n.val + "->" + graph.adjaNode.get(n).size());
        }
        */

        KahnTopo topo = new KahnTopo(graph);
        topo.process();
        for(Node temp : topo.getResult()){
            if(nodeSet.contains(temp.val))System.out.print(temp.val.toString() + "->");
        }


    }

}