package lesson1.Maraphon;

public class Main {
    public  static  void main(String[] args){
        Team myTean = new Team("DreamTeam",
                new Human("Ann"),
                new Dog("muhtar"),
                new Cat("Barsik"),
                new Human("Boris")
                );

        Course myCourse = new Course(
                new Wall(3),
                new Water(40),
                new Distance(100)
        );
        myCourse.doIt(myTean);

        myTean.showResults();
    }
}
