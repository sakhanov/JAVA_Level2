package lesson1.Maraphon;

public class Wall extends  Obversible{
    int lengh;

    public Wall(int lengh) {
        this.lengh = lengh;
    }

    @Override
    public void doIt(Competion competion) {
        competion.jump(lengh);
    }

}
