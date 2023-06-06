package wk5;

import java.util.*;

public class Week5 {

    static Random random = new Random();
    static void example1(){

        /*
            Each Interface object class is instantiated in same manner

            ObjectClass<Reference Data Type> nameOfVar = new ObjectClass<>();
         */

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        /*
            I want to add 5 random values to my arraylist and linkedlist
         */

        addRandomValues(5, arrayList);
        addRandomValues(5, linkedList);


        //how to add to the begining of arrayList?
        arrayList.add(0, 12345);
        linkedList.addFirst(12345);
        arrayList.add(9876);
        linkedList.add(9876);
        linkedList.addLast(879659);

        System.out.println(arrayList.size());


        for(int i = 0; i < arrayList.size(); i++){
            arrayList.get(i);
        }

        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*
        An iterator object: an object dedicated to cycling through all values of a Collection


        values          100         200         300         400         500
        indexes         0           1           2           3           4
        pointer    ^
                    after next() call
                              ^
                                                                                ^
  0       */

    }

    static void example2(){

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        addRandomValues(5, linkedList1);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        addRandomValues(5, linkedList2);

        ArrayList<Integer> arrayList1 = new ArrayList();
        addRandomValues(5, arrayList1);

        linkedList1.addAll(linkedList2);
        arrayList1.addAll(2, linkedList2);

        displayCollectionValues(linkedList1);


        Iterator<Integer> iterator = linkedList1.listIterator();

        /*

            iterator.hasNext()
            iterator.next()
            iterator.next()
            iterator.next()
            iteration.previous() // what will be the output?

         */

        linkedList1.toArray();
        arrayList1.toArray();

        Collections.disjoint(arrayList1, linkedList2);


    }
    static void displayCollectionValues(Collection data){

//        for(int i = 0; i < data.size(); i++){
//            System.out.println(data.get(i));
//        }
        Iterator<Object> iterator = data.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*



         */

    }

    static void example3(){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        addRandomValues(5, priorityQueue);




        while (priorityQueue.size() > 0){
            System.out.println(priorityQueue.poll());
        }

    }
    static void addRandomValues(int numRandomValues, Collection dataStructure){

        for(int i = 0 ; i < numRandomValues; i++){

            dataStructure.add(random.nextInt(-100, 100));
        }

    }

    static void example4(){

        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        addRandomValues(10, treeSet);
        addRandomValues(10, hashSet);
        System.out.println("Tree Set");
        displayCollectionValues(treeSet);
        System.out.println("*".repeat(20));
        System.out.println("Hash Set");
        displayCollectionValues(hashSet);


        SortedSet<Integer> set = treeSet.headSet(50);
        System.out.println("*".repeat(20));

        displayCollectionValues(set);

    }
    static void example5(){

        HashMap<Integer, Double> hashMap = new HashMap<>();
        hashMap.put(1, 100d);
        hashMap.put(2, -200D);

        hashMap.containsKey(3);  //false
        hashMap.containsValue(150d); //false

        Set<Integer> keys = hashMap.keySet();

        for(int key : keys){
            System.out.println(hashMap.get(key));
        }

    }
    static void example6(){

        /*
                Take the following series of values

                1       -10     5       3       -20     40      -1


            Create a collection of unique values in descending order
            output this the screen
         */

        int[] nums = {1,-10,5,3,-20,40,-1};
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(-10);

        Iterator<Integer> iterator = treeSet.descendingIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

    public static void main(String[] args) {
        example6();
    }
}
