import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию
// числа телефонов.

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(phoneNum);
            phoneBook.put(name, values);
        }
    }
    public static void printBook(){
            ArrayList<Map.Entry<String, ArrayList<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());
            entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
            for (Map.Entry<String, ArrayList<Integer>> entry : entries) {
                String name = entry.getKey();
                ArrayList<Integer> phones = entry.getValue();
                System.out.println(name + ": " + phones.size() + " номер(а)");
                System.out.println(phones);
                System.out.println();
                }
        }
}

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
        int phone1;
        int phone2;
        int phone3;
        int phone4;
        int phone5;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Elena";
            name4 = "Elena";
            name5 = "Ivan";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 123458;
            phone4 = 648512;
            phone5 = 195462;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
            phone1 = Integer.parseInt(args[5]);
            phone2 = Integer.parseInt(args[6]);
            phone3 = Integer.parseInt(args[7]);
            phone4 = Integer.parseInt(args[8]);
            phone5 = Integer.parseInt(args[9]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name4, phone4);
        myPhoneBook.add(name5, phone5);

        PhoneBook.printBook();
    }
}
