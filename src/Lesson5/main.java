package Lesson5;

public class main {
    static  final int size = 100000000;
    static  final int h = size/2;

    static  public void main(String[] args) throws InterruptedException {
        int i = 0;
        float[] arr = new float[size];
        for(i=0; i < size; i++) arr[i] =1.f;
        long a = System.currentTimeMillis();

        for (i=0; i<size;i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                * Math.cos(0.4f + i / 2));

        System.out.println(System.currentTimeMillis() - a);


        // нногопоточность
        for(i=0; i < size; i++) arr[i] =1.f;

        a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        myTread t1 = new myTread(a1);
        myTread t2 = new myTread(a2);

        t1.start();
        t2.start();

        t1.join();

        t2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }
}
