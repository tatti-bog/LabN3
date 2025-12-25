public class Tovar {

    private String name;
    private int kolvo;

    public Tovar(String name, int kolvo) {
        this.name = name;
        if (kolvo < 0) {
            System.out.println("Количество товара не может быть отрицательным. Установлено 0.");
            this.kolvo = 0;
        } else {
            this.kolvo = kolvo;  // 0 и положительные нормально
        }
    }

    public String getName() {
        return name;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        if (kolvo > 0) {
            this.kolvo = kolvo;
        }
        else {
            System.out.println("2Количество товара не может быть отрицательным");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addKolvo(int amount) {
        if (amount >= 0) {
            this.kolvo += amount;
        }
        else {
            System.out.println("3Нельзя уменьшить");

        }
    }

    @Override
    public String toString(){
        return  name + ": " + kolvo;
    }
}
