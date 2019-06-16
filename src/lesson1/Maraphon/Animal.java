package lesson1.Maraphon;

import java.util.Collections;

public class Animal implements Competion{
    String type;
    String name;
    int distanceRun;
    int distanceSwim;
    int heighJump;
    boolean onCompetion;

    public Animal(String type, String name, int distanceRun, int distanceSwim, int heighJump) {
        this.type = type;
        this.name = name;
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        this.heighJump = heighJump;
        onCompetion = true;
    }
    public void testCompetion(int dist, int max_dist,String s){
        String result = "ok";
        if (dist > max_dist){
            onCompetion = false;
            result = "not";
        }
        System.out.println(type + " " + name + " " + s + " " + result );

    }

    @Override
    public void run(int dist){
        testCompetion(dist,distanceRun,"run");
    }

    @Override
    public void swim(int dist){
        testCompetion(dist, distanceSwim,"swim");
    }
    @Override
    public void jump(int height){
        testCompetion(height, heighJump,"jump");
    }
    @Override
    public boolean isOnDistance(){
        return onCompetion;
    }

    @Override
    public void info() {
        String comp =" ok";
        if(!isOnDistance()){
            comp =" not";
        }
        System.out.println("type" + " " + name + comp);
    }
}
