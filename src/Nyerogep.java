public class Nyerogep extends Jatekgep {
    static private String[] szimbolumok = new String[]{"citrom","dinnye","cseresznye","7","BAR","JACKPOT"};
    private int jackpotHuzas;
    public Nyerogep(int azonosito, String nev, double maximumTet, double minimumTet) {
        super(azonosito, nev, maximumTet, minimumTet);
        setJackpotHuzas(0);
        this.setJatszottKorok(0);
        this.setOsszesBevet(0);
        this.setOsszesKifizetes(0);
    }

    public int getJackpotHuzas() {
        return jackpotHuzas;
    }

    public void setJackpotHuzas(int jackpotHuzas) {
        this.jackpotHuzas = jackpotHuzas;
    }
    private String huzosSzimbolum(){
        return szimbolumok[(int)(Math.random()*szimbolumok.length)];
    }
    @Override
    public double jatszik(double tet){
        String s1 = huzosSzimbolum();
        String s2 = huzosSzimbolum();
        String s3 = huzosSzimbolum();
        if (tetellenorzes(tet)){
            osszesKifizetes-=tet;
            setJatszottKorok(this.jatszottKorok+1);
            if (s1.equals(s2) && s1.equals(s3) && s1.equals("JACKPOT")){
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*50+" FT");
                osszesKifizetes+=tet*50;
                this.jackpotHuzas++;
                return tet*50;
            } else if (s1.equals(s2) && s1.equals(s3)) {
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*10+" FT");
                osszesKifizetes+=tet*10;
                return tet*10;
            } else if (s1.equals(s2)) {
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*2+" FT");
                osszesKifizetes+=tet*2;
                return tet*2;
            }else if (s1.equals(s3)) {
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*2+" FT");
                osszesKifizetes+=tet*2;
                return tet*2;
            }else if (s2.equals(s3)) {
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*2+" FT");
                osszesKifizetes+=tet*2;
                return tet*2;
            }else {
                System.out.println("[ "+s1+" | "+s2+" | "+s3+" ] → +"+tet*0+" FT");
                return 0.0;
            }
        }else{
            return 0.0;
        }
    }
}
