package src.campus02.bubblesort;

public class Auto {

    private final String hersteller;

    private final int zulassungsMonat;

    private final int zulassungsJahr;

    public Auto(String hersteller, int zulassungsJahr, int zulassungsMonat) {
        this.hersteller = hersteller;
        this.zulassungsJahr = zulassungsJahr;
        this.zulassungsMonat = zulassungsMonat;
    }

    public String getHersteller() {
        return hersteller;
    }

    public int getZulassungsMonat() {
        return zulassungsMonat;
    }

    public int getZulassungsJahr() {
        return zulassungsJahr;
    }


    @Override
    public String toString() {
        return "Auto [hersteller=" + hersteller + ", zulassungsMonat=" + zulassungsMonat + ", zulassungsJahr="
                + zulassungsJahr + "]";
    }

    /**
     * Vergleicht zwei Autos miteinander nach ZulassungsJahr, ZulassungsMonat, und Hersteller
     *
     * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
     */
    public int compareTo(Auto a) {
        //Zulassungsjahr
		// wenn this < a. zulassungsjahr --> -1
		// wenn this = a.zj = 0 -> dann nach zulassungsmonat --> dann nach hersteller aufsteigend
		// wenn this > a.zj --> 1

		int result = Integer.compare(this.zulassungsJahr, a.zulassungsJahr);

		if(result == 0){
			int result2 = Integer.compare(this.zulassungsMonat, a.zulassungsMonat);

			if(result2 == 0){
				return this.hersteller.compareTo(a.hersteller);
			}
			return result2;
		}

		return result;
    }
}
