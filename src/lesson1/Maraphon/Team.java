package lesson1.Maraphon;

public class Team {
    String NameTeam;
    Competion[] myTeam;

    public Team(String nameTeam, Competion ... members) {
        NameTeam = nameTeam;
        myTeam = new Competion[members.length];
        for (int i =0; i< members.length; i++){
            myTeam[i] = members[i];
        }
    }
    public  int getCount(){
        return myTeam.length;
    }
    public void info(int k){
        if (k < 0 || k >= getCount()){
            System.out.println("out of range");
            return;
        }
        getMember(k).info();
    }

    public String getNameTeam() {
        return NameTeam;
    }
    public Competion[] getMyTeam() {
        return myTeam;
    }
    public Competion getMember(int k){
        if (k < 0 || k >= getCount()){
            System.out.println("out of range");
            return null;
        }
        return myTeam[k];
    }
    public void showResults(){
        System.out.println("Team name " + getNameTeam());
        for (Competion c: getMyTeam()) {
            c.info();
        }
    }
}
