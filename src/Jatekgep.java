public class Jatekgep {
    protected int azonosito, jatszottKorok;
    protected String nev;
    protected double maximumTet, minimumTet, osszesBevet, osszesKifizetes;

    public Jatekgep(int azonosito, String nev, double maximumTet, double minimumTet) {
        this.setAzonosito(azonosito);
        this.setNev(nev);
        this.setMinimumTet(minimumTet);
        this.setMaximumTet(maximumTet);
        this.setJatszottKorok(0);
        this.setOsszesBevet(0);
        this.setOsszesKifizetes(0);
    }

    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }

    public void setJatszottKorok(int jatszottKorok) {
        this.jatszottKorok = jatszottKorok;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setMaximumTet(double maximumTet) {
        this.maximumTet = maximumTet;
    }

    public void setMinimumTet(double minimumTet) {
        this.minimumTet = minimumTet;
    }

    public void setOsszesBevet(double osszesBevet) {
        this.osszesBevet = osszesBevet;
    }

    public void setOsszesKifizetes(double osszesKifizetes) {
        this.osszesKifizetes = osszesKifizetes;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public int getJatszottKorok() {
        return jatszottKorok;
    }

    public String getNev() {
        return nev;
    }

    public double getMaximumTet() {
        return maximumTet;
    }

    public double getMinimumTet() {
        return minimumTet;
    }

    public double getOsszesBevet() {
        return osszesBevet;
    }

    public double getOsszesKifizetes() {
        return osszesKifizetes;
    }

    public boolean tetellenorzes(double tet){
        if (tet>=minimumTet && tet<=maximumTet) {
            return true;
        } else {
            System.err.println("A tét nem lehet kissebb, mint a minimum tét, és nem lehet nagyiobb mint a maximum!");
            return false;
        }
    }

    public double jatszik(double tet){
        return 0.0;
    }

    public double getProfit(){
        return osszesBevet-osszesKifizetes;
    }

    public String getAdatlap(){
        return getNev()+ " | Tét: "+ getMinimumTet() + "--" + getMaximumTet()+" | Körök: " + getJatszottKorok();
    }

    public String getStatisztika(){
        return "Bevétel: " + getOsszesBevet() + "Ft | Kifizetés: "+ getOsszesKifizetes()+ " | Profit: " + (osszesBevet-osszesKifizetes) + " Ft";
    }

}
