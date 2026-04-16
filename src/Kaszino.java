import java.util.Random;

public class Kaszino {
    private Jatekgep[] gepek;
    private int darabszam;
    private int maxGepek = 2;
    private Random rnd = new Random();

    public Kaszino(Jatekgep[] gepek, int darabszam) {
        this.gepek = new Jatekgep[maxGepek];
        this.darabszam = 0;

    }

    public void gepFelvett(Jatekgep g){
        if (darabszam < gepek.length){
            darabszam++;
        }
        else {
            System.out.println("A kaszinó megtelt, nem vehető fel több gép");
        }
    }

    public void szimulacio(int korok){
        for (int i = 0; i < gepek.length; i++) {
            for (int j = 0; i < korok; i++) {
                gepek[i].jatszik(rnd.nextInt((int) gepek[i].getMaximumTet())+gepek[i].getMinimumTet());
                System.out.println("Szimuláció: " + gepek[i].getNev());
            }
        }
    }

    public void jelentes(){
        for (int i = 0; i < gepek.length; i++) {
            System.out.println("A gép adatai: " + gepek[i].getAdatlap());

        }
    }

    public void legjobbanJovedelmez(Jatekgep jg){
        int legnagyobbProfit = (int) gepek[0].getProfit();
        for (int i = 0; i < gepek.length; i++) {
            if (legnagyobbProfit<gepek[i].getProfit()){
                System.out.println("A legnagyobb profittal rendelkezo gép: " + gepek[i].getProfit());
            }
        }
    }


}