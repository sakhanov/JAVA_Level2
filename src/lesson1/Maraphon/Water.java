package lesson1.Maraphon;

public class Water extends Obversible {
    int lengh;

    public Water(int lengh) {
        this.lengh = lengh;
    }

    @Override
    public void doIt(Competion competion) {
        competion.swim(lengh);
    }
}
