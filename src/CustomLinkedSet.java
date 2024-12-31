import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set; /**
 * Узагальнений клас, що реалізує інтерфейс Set із внутрішньою структурою однозв'язного списку.
 *
 * @param <T> Тип елементів у колекції.
 */
public class CustomLinkedSet<T> implements Set<T> {

    /**
     * Внутрішній клас, що представляє вузол однозв'язного списку.
     */
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head; // Початковий елемент списку
    private int size; // Кількість елементів у колекції

    /**
     * Конструктор за замовчуванням для створення порожнього Set.
     */
    public CustomLinkedSet() {
        head = null;
        size = 0;
    }

    /**
     * Конструктор, що створює Set з переданим об'єктом.
     *
     * @param element Початковий елемент для додавання в колекцію.
     */
    public CustomLinkedSet(T element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що створює Set із стандартної колекції.
     *
     * @param collection Колекція, елементи якої потрібно додати.
     */
    public CustomLinkedSet(Iterable<T> collection) {
        this();
        for (T element : collection) {
            add(element);
        }
    }

    /**
     * Додає елемент до колекції.
     *
     * @param element Елемент для додавання.
     * @return true, якщо елемент успішно доданий, false, якщо елемент уже існує.
     */
    @Override
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    /**
     * Перевіряє, чи міститься елемент у колекції.
     *
     * @param element Елемент для перевірки.
     * @return true, якщо елемент існує, false - якщо ні.
     */
    @Override
    public boolean contains(Object element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Видаляє елемент із колекції.
     *
     * @param element Елемент для видалення.
     * @return true, якщо елемент був успішно видалений, false, якщо елемент не знайдений.
     */
    @Override
    public boolean remove(Object element) {
        if (head == null) {
            return false;
        }

        // Якщо елемент на початку списку
        if (head.data.equals(element)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Повертає розмір колекції.
     *
     * @return Кількість елементів у колекції.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи є колекція порожньою.
     *
     * @return true, якщо колекція порожня, false - якщо ні.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Очищає колекцію, видаляючи всі елементи.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Повертає ітератор для проходження по колекції.
     *
     * @return Ітератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Method addAll is not supported.");
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method retainAll is not supported.");
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method removeAll is not supported.");
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method containsAll is not supported.");
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Method toArray is not supported.");
    }

    /**
     * Метод, що не підтримується у даній реалізації.
     */
    @Override
    public <U> U[] toArray(U[] a) {
        throw new UnsupportedOperationException("Method toArray is not supported.");
    }
}
