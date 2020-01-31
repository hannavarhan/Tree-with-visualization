
public class Animal implements Comparable<Animal>{

    private String name;
    private int mimimi;

    Animal() {
        name = "";
        mimimi = 0;
    }

    Animal(String name, int mi) throws IllegalArgumentException {
        if(mi > 100 || mi < 0) {
            throw new IllegalArgumentException("ILLEGAL VALUE");
        }
        this.name = name;
        mimimi = mi;
    }

    Animal(String name) {
        this.name = name;
        mimimi = (int)(Math.random() * 100);
    }

    @Override
    public String toString() {
        return new String(name + " " + mimimi + "%");
    }

    public int compareTo(Animal a) {
        return this.name.compareTo(a.name);
    }

    public String getName() {
        return name;
    }

    public double getMimimi() {
        return mimimi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMimimi(int mimimi) throws IllegalArgumentException{
        if(mimimi > 100 || mimimi < 0) {
            throw new IllegalArgumentException("ILLEGAL VALUE");
        }
        this.mimimi = mimimi;
    }
}