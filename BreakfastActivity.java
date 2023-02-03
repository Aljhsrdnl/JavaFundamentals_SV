import java.util.Arrays;
import java.util.Comparator;

class StringObject implements Comparable <StringObject> {
    public String title;
    public String description;
    
    //constructor
    StringObject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //methods
    void display() {
        System.out.println(String.format("Title: %s \nDescription: %s \n--------------------------------", this.title, this.description));
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public int compareTo(StringObject obj) {
        return getTitle().compareToIgnoreCase(obj.title);
    }

    public static Comparator <StringObject> DescendingComparator = new Comparator<StringObject>() {
        @Override
        public int compare(StringObject o1, StringObject o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    };
} 

public class BreakfastActivity {
    //methods
    static void display(StringObject[] arrList) {
        if(arrList.length == 0) {
            System.out.println("NO RECORDS AVAILABLE.");
        }
        else {
            for (int i = 0; i < arrList.length; i++) {
                arrList[i].display();
             }
        }
    }

    static void count(StringObject[] arrList) {
        System.out.println(String.format("There are %d data available right now.", arrList.length));
    }

    static void searchKeyword(StringObject[] arrList, String searchKey) {
        boolean keywordFound = false;
        int arrLength = arrList.length;
        int index = 0;

        while (!keywordFound || index < arrLength) {
            if (arrList[index].title.equals(searchKey)) {
                keywordFound = true;
                break;
            }
            else if(!keywordFound && index == (arrLength-1)){
                break;
            }
            else {
                index += 1;
            }
        }
        System.out.println("======KEYWORD SEARCH RESULTS:======");
        if(keywordFound == true) {
            System.out.println(String.format("Keyword '%s' has been found!", searchKey));
        }
        else {
            System.out.println(String.format("Keyword '%s' WAS NOT FOUND. :'( Its not you, its us.", searchKey));
        }
    }

    static void searchDescription(StringObject[] arrList, String descriptionKey) {
        int matchCount = 0;
        StringObject [] matchFound = new StringObject[arrList.length];
        int matchFoundIndex = 0;
        int arrLength = arrList.length;
        int index = 0;
        
        while(index < arrLength) {
            if(arrList[index].description.contains(descriptionKey)) {
                matchCount++;
                matchFound[matchFoundIndex] = arrList[index];
                matchFoundIndex++;
            }
            index++;
        }

        System.out.println("======DESCRIPTION SEARCH RESULTS:======");
        if(matchCount > 0) {
            System.out.println(String.format("There are %d description/s matching your search keyword.\nHere are the results: \n", matchCount));
            for(int i = 0; i < matchFoundIndex; i++) {
                System.out.println(String.format("Title: %s \nDescription: %s \n--------------------------------", matchFound[i].title, matchFound[i].description));
            }
        }
    }
    
    static void sortAscendingly(StringObject[] arrList) {
        Arrays.sort(arrList);
        System.out.println("Here are the results after they have been sorted ascendingly: ");
        for(int i = 0; i < arrList.length; i++) {
            System.out.println(String.format("Title: %s \nDescription: %s \n--------------------------------", arrList[i].title, arrList[i].description));
        }
    }

    static void sortDescendingly(StringObject[] arrList) {
        Arrays.sort(arrList, StringObject.DescendingComparator);
        System.out.println("Here are the results after they have been sorted descendingly: ");
        for(int i = 0; i < arrList.length; i++) {
            System.out.println(String.format("Title: %s \nDescription: %s \n--------------------------------", arrList[i].title, arrList[i].description));
        }
    }
    
    public static void main (String args[]) {
        //create an array of StringObject with length of 3
         StringObject [] arrList;
         arrList = new StringObject[3];
         arrList[0] = new StringObject("French Toast", "Food_0_Description");
         arrList[1] = new StringObject("Empanada", "Food_1_Description");
         arrList[2] = new StringObject("Coffee", "Food_2_Description");
         Arrays.toString(arrList);
         switch(args[0]) {
            case "display":
                display(arrList);
                break;
            case "searchKey":
                searchKeyword(arrList, args[1]);
                break;
            case "sortAsc":
                sortAscendingly(arrList);
                break;
            case "sortDesc":
                sortDescendingly(arrList);
                break;
            case "searchDesc":
                searchDescription(arrList, args[1]);
                break;
            default:
                System.out.println("Sorry, this feature is not available. :'(");
         }
    }
}

//used args in Main to control the flow of the program
//utilized Comparator interface to create methods for sorting ascendingly and descendingly

