import java.util.Random;
import java.util.Scanner;

public class Rulett extends Jatekgep{
    private int utolsoSzam;
    private String utolsoSzin, fogadottSzam, fogadottSzin;
    private static Scanner scn = new Scanner(System.in);
    private static Random rnd = new Random();

    public Rulett(int azonosito, String nev, double minimumTet, double maximumTet) {
        super(azonosito, nev, minimumTet, maximumTet);
    }

    public int getUtolsoSzam() {
        return utolsoSzam;
    }

    public void setUtolsoSzam(int utolsoSzam) {
        this.utolsoSzam = utolsoSzam;
    }

    public String getUtolsoSzin() {
        return utolsoSzin;
    }

    public void setUtolsoSzin(String utolsoSzin) {
        this.utolsoSzin = utolsoSzin;
    }

    public String getFogadottSzam() {
        return fogadottSzam;
    }

    public void setFogadottSzam(String fogadottSzam) {
        this.fogadottSzam = fogadottSzam;
    }

    public String getFogadottSzin() {
        return fogadottSzin;
    }

    public void setFogadottSzin(String fogadottSzin) {
        this.fogadottSzin = fogadottSzin;
    }

    public void forgat(){
        utolsoSzam = (int) Math.floor(Math.random() * (36 + 1));
        if ((utolsoSzam % 2) != 0)
        {
            utolsoSzin = "fekete";
        } else if ((utolsoSzam % 2) > 0) {
            utolsoSzin = "piros";
        }else {
            utolsoSzin = "zöld";
        }
    }

    @Override
    public double jatszik(double tet) {
        double nyeremeny = 0;
        String valasztottSzin;
        osszesBevet += tet;
        if (!tetellenorzes(tet)){
            return 0.0;
        }
        int valsztottSzinSzam = (int) Math.floor(Math.random()*2);

        if (valsztottSzinSzam == 0){
            valasztottSzin = "piros";
        } else {
            valasztottSzin = "fekete";
        }
        forgat();
        if (utolsoSzin.equals(valasztottSzin)){
            nyeremeny = tet*2;
            osszesKifizetes+=nyeremeny;
        }
        System.out.println("fogadott szín: " + valasztottSzin + " kijött szín: "+utolsoSzin+ " kijött szám: "+ (int) Math.floor(Math.random()*37));
        return nyeremeny;
    }

    public double szamraFogadas(int fogadottSzam, double tet){
        double nyeremeny = 0.0;
        int kijottszam = (int) Math.floor(Math.random()*37);
        if (fogadottSzam == utolsoSzam){
            nyeremeny = tet*36;
        }
        System.out.println("fogadott szám: " + fogadottSzam + " kijött szám: "+kijottszam+ "nyeremény: " + nyeremeny);
        return nyeremeny;
    }

    @Override
    public String getAdatlap() {
        return super.getAdatlap() + "\nAz utólsó forgatás eredményei: " + getUtolsoSzin()+", " + getUtolsoSzam();
    }
}
