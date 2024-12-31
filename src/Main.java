import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Головний клас для демонстрації роботи користувацької реалізації Set.
 */
public class Main {
    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створюємо набір
        CustomLinkedSet<String> customSet = new CustomLinkedSet<>();

        // Додаємо елементи
        System.out.println("Додаємо елементи до Set:");
        System.out.println("Додано 'Apple': " + customSet.add("Apple"));
        System.out.println("Додано 'Banana': " + customSet.add("Banana"));
        System.out.println("Додано 'Orange': " + customSet.add("Orange"));
        System.out.println("Спроба додати 'Apple' повторно: " + customSet.add("Apple")); // Повторне додавання

        // Перевіряємо розмір
        System.out.println("\nРозмір Set після додавання: " + customSet.size());

        // Перевіряємо наявність елементів
        System.out.println("\nПеревіряємо, чи містяться елементи:");
        System.out.println("'Apple': " + customSet.contains("Apple"));
        System.out.println("'Grapes': " + customSet.contains("Grapes"));

        // Видаляємо елементи
        System.out.println("\nВидаляємо елементи:");
        System.out.println("Видалено 'Banana': " + customSet.remove("Banana"));
        System.out.println("Спроба видалити 'Grapes': " + customSet.remove("Grapes"));

        // Перевіряємо розмір після видалення
        System.out.println("\nРозмір Set після видалення: " + customSet.size());

        // Використовуємо ітератор для проходження по Set
        System.out.println("\nПроходимо по Set за допомогою ітератора:");
        for (String item : customSet) {
            System.out.println(item);
        }

        // Очищаємо Set
        System.out.println("\nОчищаємо Set...");
        customSet.clear();

        // Перевіряємо, чи Set порожній
        System.out.println("Set порожній: " + customSet.isEmpty());
    }
}
