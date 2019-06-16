package lesson1.Maraphon;

public class Distance extends Obversible{
    int lengh;

    public Distance(int lengh) {
        this.lengh = lengh;
    }

    @Override
    public void doIt(Competion competion) {
        competion.run(lengh);
    }

}
