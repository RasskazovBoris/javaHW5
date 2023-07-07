import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class HW5 {
    static void sortedPrint(Map<String, ArrayList> map) {

        Set<String> keySet = map.keySet();

        int maxCount = 0;
        int minCount = 1_000_000;

        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();

        }

        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }
            }
            num += 1;
        }

        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Чернышев", new ArrayList<Integer>() {
                    {
                        add(876787);
                        add(888876);
                        add(922381);
                    }
                });
                put("Попов", new ArrayList<Integer>() {
                    {
                        add(123123);
                    }
                });
                put("Федоров", new ArrayList<Integer>() {
                    {
                        add(838383);
                        add(232377);

                    }
                });
                put("Печкин", new ArrayList<Integer>() {
                    {
                        add(886644);
                        add(555222);
                        add(182830);
                        add(999999);
                    }
                });
            }
        };
        System.out.println();

        System.out.println("Уже есть ");
        sortedPrint(abon);

        try (
                Scanner scan = new Scanner(System.in, "cp866")) {
            Boolean getOut = false;
            String st;
            while (!getOut) {
                System.out.println("Выбирай (1 - добавить абонента, 9 - выйти из программы):");
                st = scan.nextLine();
                String name = "";
                String phString;
                switch (st) {
                    case "1": {
                        System.out.println("давай фамилию ");
                        name = scan.nextLine();
                        if (abon.containsKey(name)) {
                            System.out.println("Уже есть ");
                            System.out.println();
                            break;
                        } else {
                            System.out.println("Пишите цифры через запятую ");
                            phString = scan.nextLine();
                            String[] arr = phString.split(", ");
                            ArrayList<Integer> arrInt = new ArrayList<>();
                            for (String item : arr) {
                                arrInt.add(Integer.parseInt(item.trim()));
                            }
                            abon.put(name, arrInt);
                            System.out.println();
                            sortedPrint(abon);
                            break;
                        }
                    }
                    case "9": {
                        getOut = true;
                        System.out.println();
                        System.out.println("Пока!");
                        System.out.println();
                        break;
                    }

                }
            }
        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
    }
}