// Базовый класс - Растение
class Plant {
    private double height;      // высота растения
    private double growthRate;  // скорость роста (см/год)
    private String name;        // название растения

    Plant() {
        height = 0.0;
        growthRate = 0.0;
        name = "Без названия";
    }

    Plant(double h, double gr, String n) {
        height = h;
        growthRate = gr;
        name = n;
    }

    double getHeight() { return height; }
    double getGrowthRate() { return growthRate; }
    String getName() { return name; }

    void showInfo() {
        System.out.println("Растение: " + name +
                ", высота: " + height + " см" +
                ", скорость роста: " + growthRate + " см/год");
    }

    // Метод роста
    void grow() {
        System.out.println(name + " растёт каким-либо способом.");
    }
}

// Подкласс - Дерево
class Tree extends Plant {
    private int age; // возраст дерева
    private String type; // вид дерева

    Tree() {
        super();
        age = 0;
        type = "Неизвестно";
    }

    Tree(double h, double gr, String n, int age, String t) {
        super(h, gr, n);
        this.age = age;
        this.type = t;
    }

    // Переопределение метода grow()
    @Override
    void grow() {
        System.out.println(getName() + " - дерево (тип: " + type + "), растёт вверх медленно.");
    }

    void showTree() {
        showInfo();
        System.out.println("Возраст: " + age + " лет, тип дерева: " + type);
    }
}

// Подкласс - Плодовое дерево
class FruitTree extends Tree {
    private String fruitType; // тип плодов

    FruitTree() {
        super();
        fruitType = "Неизвестно";
    }

    FruitTree(double h, double gr, String n, int age, String t, String fruit) {
        super(h, gr, n, age, t);
        fruitType = fruit;
    }

    @Override
    void grow() {
        System.out.println(getName() + " плодоносит и растёт.");
    }

    void showFruitTree() {
        showTree();
        System.out.println("Плоды: " + fruitType);
    }
}

// Самый низкий уровень — Яблоня
class AppleTree extends FruitTree {
    private int applesPerYear; // количество яблок в год

    AppleTree() {
        super();
        applesPerYear = 0;
    }

    AppleTree(double h, double gr, String n, int age, String t, String fruit, int count) {
        super(h, gr, n, age, t, fruit);
        applesPerYear = count;
    }

    void harvest() {
        System.out.println(getName() + " дала урожай: " + applesPerYear + " яблок за год!");
    }

    @Override
    void grow() {
        System.out.println(getName() + " (яблоня) растёт и приносит яблоки.");
    }

    void showAppleTree() {
        showFruitTree();
        System.out.println("Урожай яблок в год: " + applesPerYear);
    }
}

// Демонстрация
class PlantsDemo {
    public static void main(String[] args) {
        Plant p = new Plant(35, 15, "Лопух");
        Tree t = new Tree(450, 30, "Дуб", 80, "Лиственное");
        FruitTree f = new FruitTree(320, 25, "Груша", 15, "Лиственное", "Груши");
        AppleTree a = new AppleTree(300, 22, "Яблоня Мельба", 10, "Лиственное", "Яблоки", 120);

        // Ссылки на базовый класс:
        Plant ref;

        ref = p; ref.grow();
        ref = t; ref.grow();
        ref = f; ref.grow();
        ref = a; ref.grow();
    }
}
