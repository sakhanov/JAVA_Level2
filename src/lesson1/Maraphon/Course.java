package lesson1.Maraphon;

public class Course {
    private Obversible myCourse[];

    public Course(Obversible ... myCourse) {
        this.myCourse = new Obversible[myCourse.length];
        for(int i=0; i < myCourse.length; i++){
            this.myCourse[i] = myCourse[i];
        }
    }

    public Obversible[] getMyCourse() {
        return myCourse;
    }

    public void doIt(Team myTeam){
        for (Competion c: myTeam.getMyTeam()) {
            for (Obversible o: this.getMyCourse()) {
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
            }
        }
    }
}
