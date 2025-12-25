import java.util.ArrayList;
import java.util.List;
public class Sklad {

    private String name;

    private List<Tovar> tovari;


    public Sklad(String name) {
        tovari = new ArrayList<>();
        this.name = name;

    }

    private String status(){
        if (tovari.isEmpty())
        {
            return "Склад пустой";
        }
        else {
             return "Склад не пустой";
        }
    }

    public void addTovar(Tovar product) {
        for (Tovar t : tovari) {
            if (t.getName().equals(product.getName())) {
                t.addKolvo(product.getKolvo());
                return;// останавливаемся если нашли
            }
        }
        tovari.add(product);
    }

    public void delTovar(String name){

            for (int i = 0; i < tovari.size(); i++) {
                if (tovari.get(i).getName().equals(name)) {
                    tovari.remove(i);
                    return;
                }
            }
        System.out.println("нет такого товара");
    }

    public void takeTovar(Tovar tovar, int i){
        for (Tovar t : tovari) {
            if (t.getName().equals(tovar.getName())) {

                if (t.getKolvo() >= i) {
                    t.setKolvo(t.getKolvo() - i);
                }

                if (t.getKolvo()==0) {
                    delTovar(tovar.getName());
                }

                return;// останавливаемся если нашли
            }
        }
        System.out.println("нет такого товара");
    }

    public int skolko(String chto){
        for (Tovar t : tovari) {
            if (t.getName().equals(chto)) {
                return t.getKolvo();
            }
        }
        return 0 ;
    }

    public List<Tovar> inRange(int min, int max){
        List<Tovar> r= new ArrayList<>();
        for (Tovar t : tovari) {
            if (t.getKolvo() >= min && t.getKolvo() <= max) {
                r.add(t);
            }
        }
        return r;
    }

    public int asortiment() {
        return tovari.size();
    }

    public int vsego(){
        int s=0;
        for (Tovar t : tovari) {
            s=s+t.getKolvo();
        }
        return s ;
    }

    public double procent(Tovar tovar){
        for (Tovar t : tovari) {
            if (t.getName().equals(tovar.getName())) {
                int i = vsego();
                if (i>0) {
                    int q = t.getKolvo();
                    double p = (q / i) * 100.0;
                    return p;
                }
            }
        }
        return 0;
    }

    public List<Tovar> kogoMnogo(int n){
        List<Tovar> r = new ArrayList<>(tovari);
        r.sort((t1, t2) -> t2.getKolvo() - t1.getKolvo());
        if (n >= r.size()){
            return r;
        }
        else {
            List<Tovar> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(r.get(i));
            }
            return result;
        }

    }

    public void printAll() {
        if (tovari.isEmpty()) {
            System.out.println("Склад пуст");
            return;
        }
        System.out.println("Товары на складе:");
        for (Tovar t : tovari) {
            System.out.println(t.getName() + ": " + t.getKolvo() );
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
