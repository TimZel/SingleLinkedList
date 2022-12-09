public class SingleLinkedList implements MyList {

    Node head; // указатель на первый элемент
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

    public void addFront(int value){//добавить спереди
        Node newNode = new Node(value); //создаю новый элемент
        newNode.next = head; //делаю его следующим для нового
        head = newNode; //иначе текущий - новый
    }
    public void addBack(int value){ //добавить сзади
        Node newnode = new Node(value); //создаю новый элемент
        Node current = head; //получаю ссылку на первый элемент
        while(current.next!=null) { //перехожу в конец списка
            current = current.next;
        }
        current.next = newnode; //добавляю в конец новую запись
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
        if (head.data == data) { //если первый элемент - тот, что нужен
            head = head.next;    //переключаюуказатель начала на второй элемент
            return;              //и выхожу
        }
        Node current = head;       //иначе начинаю искать
        while (current.next != null) {    //пока следующий элемент существует
            if (current.next.data == data) {  //проверяю следующий элемент
                current.next = current.next.next;   //найденный элемент выкидываю
                return;                 //и выхожу
            } else {
                current = current.next; //иначе ищу дальше
            }
        }
    }
}
