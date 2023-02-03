import java.util.LinkedList;
public class LinkedListActivity {
    public static void main(String[] args) {
        LinkedList <String> seventeen = new LinkedList<String>();
        seventeen.add("Mingyu");
        seventeen.add("The8");
        seventeen.add("Scoups");
        seventeen.add("Wonwoo");

        for (int i = 0; i < seventeen.size(); i++) {
            System.out.println(seventeen.get(i));
        }
    }
}
