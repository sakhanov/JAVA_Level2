package Lesson3;

import java.util.*;

public class Main {
    public static  void main(String[] arts){
        String[] test = {"яблоко", "груша", "дыня", "яблоко","папая", "арбуз", "лемон","арбуз", "яблоко",
                "дыня","дыня","дыня","дыня","дыня","дыня","дыня","дыня","дыня","ананас","ананас"};
        Map<String, Integer> fruits = new HashMap<>();
        for (String str: test) {
            Integer num = fruits.get(str);
            fruits.put(str,num == null? 1: num + 1);
        }
        System.out.println(fruits);
        Map<String, phones> book = new TreeMap<>();

        String[][] rawData = {
                {"Ivanov","234566"},
                {"Petrov","234444"},
                {"Sidorov","11224444"},
                {"Petrov","1334444"},
                {"Petrov","234444"},
                {"Petrov","234444"},
                {"Petrov","234444"},
                {"Petrov","234444"} };
        //System.out.print;n



    for(String[] line: rawData){
        phones item = book.get(line[0]);
        book.put(line[0], item == null? new phones(line[1]): item.add(line[1]));
    }

    for(Map.Entry<String,phones> e: book.entrySet()){
        System.out.println(e.getKey());
        System.out.println(e.getValue().getNumber());
    }
    }

}
class  phones{
    Set<String> number;

    public phones(String phone) {
        this.number = new TreeSet<>();
        add(phone);
    }
    public phones add(String phone){
        number.add(phone);
        return  this;
    }

    public Set<String> getNumber() {
        return number;
    }
}
