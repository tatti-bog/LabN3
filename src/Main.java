import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Создаем склад
        Sklad sklad = new Sklad("Основной склад");



        // 1. Тестируем создание товаров
        System.out.println("1. Создаем товары:");
        Tovar apples = new Tovar("Яблоки", 100);
        Tovar bananas = new Tovar("Бананы", 50);
        Tovar oranges = new Tovar("Апельсины", 75);
        Tovar mandarins = new Tovar("Мандарины", -75);

        System.out.println("Создан товар: " + apples);
        System.out.println("Создан товар: " + bananas);
        System.out.println("Создан товар: " + oranges);
        System.out.println("Создан товар: " + mandarins);

        // 2. Тестируем добавление товаров
        System.out.println("\n2. Добавляем товары на склад:");
        sklad.addTovar(apples);
        sklad.addTovar(bananas);
        sklad.addTovar(oranges);
        sklad.addTovar(mandarins);
        sklad.addTovar(new Tovar("Яблоки", 50)); // Добавляем еще яблок

        sklad.printAll();

        // 3. Тестируем получение количества
        System.out.println("\n3. Проверяем количество товаров:");
        System.out.println("Яблок на складе: " + sklad.skolko("Яблоки"));
        System.out.println("Бананов на складе: " + sklad.skolko("Бананы"));

        // 4. Тестируем взятие товара
        System.out.println("\n4. Берем 30 бананов со склада:");
        sklad.takeTovar(new Tovar("Бананы", 0), 30);
        sklad.printAll();

        // 5. Тестируем товары в диапазоне
        System.out.println("\n5. Товары в диапазоне 50-150:");
        List<Tovar> inRange = sklad.inRange(50, 150);
        for (Tovar t : inRange) {
            System.out.println("  - " + t);
        }

        // 6. Тестируем ассортимент и общее количество
        System.out.println("\n6. Статистика склада:");
        System.out.println("Уникальных товаров: " + sklad.asortiment());
        System.out.println("Всего единиц товара: " + sklad.vsego());

        // 7. Тестируем процентное соотношение
        System.out.println("\n7. Процентное соотношение:");
        System.out.println("Яблоки составляют: " +
                String.format("%.2f", sklad.procent(new Tovar("Яблоки", 0))) + "%");

        // 8. Тестируем самые частые товары
        System.out.println("\n8. Топ-2 самых частых товара:");
        List<Tovar> top2 = sklad.kogoMnogo(2);
        for (Tovar t : top2) {
            System.out.println("  - " + t);
        }

        // 9. Тестируем удаление товара
        System.out.println("\n9. Удаляем апельсины:");
        sklad.delTovar("Апельсины");
        sklad.printAll();

        // 10. Тестируем обработку ошибок
        System.out.println("\n10. Тестируем обработку ошибок:");
        System.out.println("Пытаемся взять несуществующий товар:");
        sklad.takeTovar(new Tovar("Манго", 0), 10);

        System.out.println("Пытаемся удалить несуществующий товар:");
        sklad.delTovar("Манго");

        // 11. Тестируем товар с отрицательным количеством
        System.out.println("\n11. Тестируем создание товара с отрицательным количеством:");
        Tovar badTovar = new Tovar("Испорченный", -10);
        System.out.println("Создан товар: " + badTovar);
    }
}