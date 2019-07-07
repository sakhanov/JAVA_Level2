package Lesson5;

public class myTread extends Thread {
    float[] arr;

    public myTread(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        //super.run();
        int i = 0;
        int size = arr.length;
        for (i=0; i<size;i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                * Math.cos(0.4f + i / 2));

    }

    public float[] getArr() {
        return arr;
    }
}
