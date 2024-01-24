package src.A07_Sorting;

public class Person {

    private final String nachname;

    private final String vorname;

    public Person(String vorname, String nachname) {
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    /**
     * Vergleicht zwei Personen miteinander
     *
     * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
     */
    public int compareTo(Person p) {

		int result = this.getNachname().compareTo(p.getNachname());
        int result2 = this.getVorname().compareTo(p.getVorname());

        if(result == 0 && result2 ==0){
            return 0;
        }
		if(result ==0){
            return result2;
		}

		return result;
    }
}
