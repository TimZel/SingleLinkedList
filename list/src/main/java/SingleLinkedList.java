public class SingleLinkedList implements MyList {

    Node head; // указатель на первый элемент
    public boolean isEmpty() { //если указатель 1го элемента - нулл, список пуст
        return head == null;
    }
    public int size() { //если лист пустой, вернёт - 0
        int size = 0; //счетчик
        for(Node current = head; current != null; current = current.next) {
            size++; //считаю количество элементов
        }
        return size;
    }
    public void insertAfter(int position, int value) {  //вставить - значение после указанной позиции
        int index = 0; //счетчик позиции
        if(position >= 0 && position <= this.size()) { //если позиция элемента не 0 и лист не пустой
            Node current = head; //получаю ссылку на 1й элемент
            for( ; index != position; current = current.next) { //пока счетчик не равен позиции - ищу след-й эл
                index++; //увеличиваю счетчик
            }
            Node newNode = new Node(value);//создаю новый элемент с указанным значением
            newNode.next = current.next; //на указанном месте после current
            current.next = newNode; //current ссылаю на newNode
        }
    }

    int getIndex(int input) { //получить индекс по введенному значению
        int counter = 0; //счетчик - нуль
        for(Node current = head; current != null; current = current.next) {
            if(current.data == input) { //если есть в списке
                return counter; //возвращаю его индекс
            }
            counter++;//увеличиваю счетчик
        }
        return -1; //если нет, вернет -1
    }

    public int getElement(int index) {
        int counter = 0; //счетчик - нуль
        for(Node current = head; current != null; current = current.next) {
            if(counter == index) { //если счетчик и индекс совпадают
                return current.data; //возвращаю его значение элемента
            }
            counter++;//увеличиваю счетчик
        }
        return -1; //если нет, вернет -1
    }
    public boolean contains(int key) { //содержит ли введенный элемент
        for(Node current = head; current != null; current = current.next) {
            if (current.data == key) {
                return true; //есть ли такое значение есть, возвращаю true
            }
        }
        return false; //иначе false
    }

    public void addFront(int value){//добавить спереди
        Node newNode = new Node(value); //создаю новый элемент
        newNode.next = head; //делаю его следующим для нового
        head = newNode; //иначе текущий - новый
    }
    public void addBack(int value){ //добавить сзади
        Node newnode = new Node(value); //создаю новый элемент
        Node current = head; //получаю ссылку на первый элемент
        for( ; current.next != null; current = current.next) {}
        current.next = newnode; //добавляю в конец новую запись
    }
    void printList() { //печать списка
        for(Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " "); //печатаю его данные
        }
    }

    public void delete(int data) { //удаление элемента по заданном значению
        if(head == null) { //если список пуст -
            return;   //ничего не делаю
        }
        if (head.data == data) { //если первый элемент - тот, что нужен
            head = head.next;    //переключаюуказатель начала на второй элемент
            return;              //и выхожу
        }
        for(Node current = head; current.next != null; ) {
            if (current.next.data == data) {  //проверяю следующий элемент
                current.next = current.next.next;   //найденный элемент выкидываю
                return;                 //и выхожу
            } else {
                current = current.next; //иначе ищу дальше
            }
        }
    }
}

