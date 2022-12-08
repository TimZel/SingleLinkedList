

public class runner {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addBack(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(6);
        list.insertAfter(0, 9);

        System.out.println("elements of list: ");
        list.printList();
        System.out.println();

        list.delete(9);
        list.delete(6);

        System.out.println();
        System.out.println("elements of list after deliting: ");
        list.printList();
        System.out.println();

        System.out.println();
        System.out.println("is list empty: ");
        System.out.println(list.isEmpty());

        System.out.println();
        System.out.println("size: ");
        System.out.println(list.size());

        System.out.println();
        System.out.println("position of data : ");
        System.out.println(list.getIndex(3));

        System.out.println();
        System.out.println("show requested elemented by index: ");
        System.out.println(list.getElement(2));

        System.out.println();
        System.out.println("is list contains requested data: ");
        System.out.println(list.contains(8));
    }
}
