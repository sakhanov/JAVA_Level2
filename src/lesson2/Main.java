package lesson2;

public class Main {
    public static  void main(String[] args){
//        String[][] str ={
//                {"1111","1112","2333","2333"},
//                {"2222","111", "222", "3333"},
//                {"2222","111", "222", "3333"},
//                {"2222","111", "222", "3333"}
//        };
        String[][] str ={
                {"1111","1112","2333","2333"},
                {"2222"}
        };
        try {
            str =testArray(str);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Не правильное число столюуов и строе" + e.getRow() + " " + e.getRow());
        }
        System.out.println("Окончание");
    }
    public  static  String[][] testArray(String[][] testStr) throws MyArrayDataException {
        if (testStr.length != 4){
            throw  new MyArrayDataException("Недостачно сток", testStr.length, 0);
        }
        for (int i = 0; i< testStr.length; i++){
            if (testStr[i].length != 4){
                throw  new MyArrayDataException("Недостачно столбцов ", testStr.length, testStr[i].length);
            }
        }
        return  testStr;
    }
}
