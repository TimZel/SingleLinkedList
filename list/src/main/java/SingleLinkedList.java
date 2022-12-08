public class SingleLinkedList implements MyList {

    Node head; // указатель на первый элемент
    Node tail; // указатель последний элемент
    public boolean isEmpty() { //если указатель 1го элемента - нулл, список пуст
        return head == null;
    }
    public int size() { //если лист пустой, вернёт - 0
        int size = 0; //счетчик
        if (head != null) { //если лист не пустой, начинаю отсчет с 1
            size = 1;
            Node current = head; //получаю ссылку на 1й элемент
            while (current.next != null) { //пока есть следующий элемент
                current = current.next; //переключаю на след элемент
                size++; //считаю количество элементов
            }
        }
        return size;
    }

    public void insertAfter(int position, int value) {  //вставить - значение после указанной позиции
        int index = 0; //счетчик позиции
        if(position >= 0 && position <= this.size()) { //если позиция элемента не 0 и лист не пустой
            Node current = head; //получаю ссылку на 1й элемент
            while (index != position) { //пока счетчик не равен позиции
                current = current.next; //перемещаю на след.элемент
                index++; //увеличиваю счетчик
            }
            Node newNode = new Node(value);//создаю новый элемент с указанным значением
            newNode.next = current.next; //на указанном месте после current
            current.next = newNode; //current ссылаю на newNode
        }
    }

    int getIndex(int input) { //получить индекс по введенному значению
        Node current = head; // получаю ссылку на 1й элемент
        int counter = 0; //счетчик - нуль
        while(current != null) { //пока элемент существует
            if(current.data == input) { //если есть в списке
                return counter; //возвращаю его индекс
            }
            current = current.next; //переключаюсь на след-й
            counter++;//увеличиваю счетчик
        }
        return -1; //если нет, вернет -1
    }
    public int getElement(int index) {
        SingleLinkedList list = new SingleLinkedList();
        Node current = head;
        int counter = 0; //счетчик - нуль
        while(current != null) { //пока элемент существует - ищу
            if(counter == index) { //если счетчик и индекс совпадают
                return current.data; //возвращаю его значение элемента
            }
            current = current.next; //переключаюсь на след-й и ищу
            counter++;//увеличиваю счетчик
        }
        return -1; //если нет, вернет -1
    }
    public boolean contains(int key) { //содержит ли введенный элемент
        Node current = head; //получаю ссылку на 1й элемент
        while(current != null) { //пока элемент существует - ищу
            if (current.data == key) {
                return true; //есть ли такое значение есть, возвращаю true
            }
            current = current.next; //переключаюсь на след-й и ищу
        }
        return false; //иначе false
    }

    public void addFront(int data) {//добавить спереди
        Node newNode = new Node(data);  //создаю новый элемент
        newNode.data = data; //инициализирую данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null) { //если список пуст
            head = newNode ;  //то указываю ссылки начала и конца на новый элемент
            tail = newNode ; //т.е. список теперь состоит из одного элемента
        } else {
            newNode.next = head; //иначе новый элемент теперь ссылается на "бывший" первый
            head = newNode;    //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }
    void addBack(int data) {  //добавление в конец списка
        Node newNode = new Node(data);  //создаю новый элемент
        newNode.data = data;
        if (tail == null) { //если список пуст
            head = newNode;  //то указываю ссылки начала и конца на новый элемент
            tail = newNode; //т.е. список теперь состоит из одного элемента
        } else {
            tail.next = newNode;//иначе "старый" последний элемент теперь ссылается на новый
            tail = newNode; //а в указатель на последний элемент записываю адрес нового элемента
        }
    }

    void printList() { //печать списка
        Node current = head;       //получаю ссылку на первый элемент
        while (current != null) { //пока элемент существует
            System.out.print(current.data + " "); //печатаю его данные
            current = current.next; //и переключаюсь на следующий
        }
    }

    public void delete(int data) { //удаление элемента по заданном значению
        if(head == null) { //если список пуст -
            return;   //ничего не делаю
        }
        if (head == tail) {//если список состоит из одного элемента
            head = null;  //очищаю указатели начала и конца
            tail = null;
            return;  //и выхожу
        }

        if (head.data == data) { //если первый элемент - тот, что нужен
            head = head.next;    //переключаюуказатель начала на второй элемент
            return;              //и выхожу
        }

        Node current = head;       //иначе начинаю искать
        while (current.next != null) {    //пока следующий элемент существует
            if (current.next.data == data) {  //проверяю следующий элемент
                if(tail == current.next) {     //если он последний
                    tail = current;           //то указатель последнего ставлю на текущий
                }
                current.next = current.next.next;   //найденный элемент выкидываю
                return;                 //и выхожу
            } else {
                current = current.next; //иначе ищу дальше
            }
        }
    }
}
