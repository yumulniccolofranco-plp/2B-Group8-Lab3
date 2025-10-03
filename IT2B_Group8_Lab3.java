/** * A java program to sort a user's given arra
 * Group 8
 * Authors: Yumul, Niccolo (Leader)
 *          Garcia, Jhemilyn (Members)
 *          Sialsa, Junerey
 * Laboratory Exercise #3
 * Date: 9/25/2025
 */
import java.util.*;
public class IT2B_Group8_Lab3 {
    // Initialized Elements
    public static int[] arr = null;
    public static int arrSize = 0;
    public static int count = 0;
    public static Scanner input = new Scanner(System.in);
    
    // Main Method
    public static void main() {
        while (true) {
            InputArray();
            menu();
        }
    }
    
    public static void InputArray(){
        int num = 0;
        boolean run = true;
            do {
                try {
                // Create Array
                System.out.println("┌──────────────────────────────┐");
                System.out.println("│               ARRAY INITIALIZATION               │");      
                System.out.println("└──────────────────────────────┘");
                System.out.print("Enter Array Size (5-15): ");
                arrSize = input.nextInt(); 
                input.nextLine();
                if (arrSize >= 5 && arrSize <=15) {
                
                boolean validArray = false; // flag to confirm initialization
                while (!validArray) {
                    arr = new int[arrSize];
                    count = 0;

                    System.out.println("Enter " + arrSize + " Array Elements (separated by spaces): ");
                    String line = input.nextLine();
                    String[] tokens = line.trim().split("\\s+");

                    // Error Handling
                    // TODO: Fix the Lesser inputs (Dont re-enter, only warn and continue)
                    for (int i = 0; i < tokens.length && count < arrSize; i++) {
                        try {
                            arr[count++] = Integer.parseInt(tokens[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input ignored: " + tokens[i]);
                        }
                    }
                    if (count < arrSize) {
                        System.out.println("You entered fewer than " + arrSize + " numbers. Please try again.");
                        // loop continues → user re-enters values
                    } else {
                        if (tokens.length > arrSize) {
                            System.out.print("Warning: Extra inputs ignored: ");
                            for (int i = arrSize; i < tokens.length; i++) {
                                System.out.print(tokens[i] + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("Array successfully initialized!");
                        prsEnter();
                        validArray = true;
                        run = false;
                    }
                }
                }  else {
                    System.out.println("Size Invalid");
                    prsEnter();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                prsEnter();
            }
        } while (run);
    }
    
    public static void menu() {
        int choice;
        boolean run = true;
        // Main Menu 
        // TODO: Jhem, pa-improve nung menu
        while (true) {
                try {
                System.out.println("[1] Bubble Sort\n[2] Selection Sort\n[3] Insertion Sort\n[4] Exit");
                System.out.print("Enter Your Choice: ");
                choice = input.nextInt();
                System.out.print("\u000C");
                switch (choice) {
                    case 1: bubbleSort(); break;
                    case 2: selectionSort(); break;
                    case 3: insertionSort(); break;
                    case 4: exitProg(); return;
                    default: System.out.println("Invalid Choice");
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");  
                input.nextLine();
            }
        }
    }
    
    public static void exitProg() {
        while (true) {
            System.out.print("Try Again (Y/N)? Choice: ");
            // char checker
            String inputStr = input.next(); // read one token (word)
            if (inputStr.length() != 1) {
                System.out.println("Invalid input. Please enter only Y/N.");
                continue; // ask again
            }
            // exit menu
            char again = inputStr.charAt(0);
            switch (again) {
                case 'Y':
                case 'y':
                    System.out.print("\u000C");
                    return;
                case 'N':
                case 'n':
                    System.out.println("Program Terminated");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please enter only Y/N.");
            }
        }
    }

    //Add a menu system to choose whether standard or optimized
    public static void bubbleSort() {
        // Coded by Yumul, Niccolo
        int[] list = arr.clone(); // to not overwrite array
        int pass; // Number of loops to sort
        int index; // Position being checked
        int temp; // Temporary container
        int elem; // Element for printing
        System.out.print("Given Array Elements: \n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%7d", arr[i]);
        }
        System.out.println();
        for (pass = 0; pass < count - 1; pass++) {
            // Move indexes if first value is greater
            for (index = 0; index < count - 1; index++){
                if (list[index] > list[index+1]) {
                    temp = list[index];
                    list[index] = list[index+1];
                    list[index+1] = temp;
                }
            }
            // Display
            System.out.print((pass + 1) + ". ");
            for (elem = 0; elem < count; elem++) {
                    System.out.printf("%7d", list[elem]);
                }
            System.out.println();
        }
        System.out.println();
        System.out.println("The Sorted Array Elements: ");
        for (elem = 0; elem < count; elem++) {
            System.out.printf("%7d", list[elem]);
        }
        System.out.println();
        prsEnter();
        return;
    }
    
    public static void selectionSort() {
        // Coded by Garcia, Jhemilyn
        int[] list = arr.clone();
        int pass, elem;
        int min; // Current minimum value in array
        int scan; // Number of scans to find value
        System.out.print("Given Array Elements: \n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%7d", arr[i]);
        }
        System.out.println();
        for (pass = 0; pass < count - 1; pass++) {
            min = pass; // Set min to location 0
            // Search the min in the array
            for (scan = pass + 1; scan < count; scan++) {
                if (list[scan] < list[min]) {
                    min = scan;
                }
            }
            // Swap with value at location min
            int temp = list[min];
            list[min] = list[pass];
            list[pass] = temp;
            // Display
            System.out.print((pass + 1) + ". ");
            for (elem = 0; elem < count; elem++) {
                System.out.printf("%7d", list[elem]);
            }
            System.out.println();
        }
        System.out.print("The Sorted Array Elements: \n");
        for (elem = 0; elem < count; elem++) {
            System.out.printf("%7d", list[elem]);
        }
        System.out.println();
        prsEnter();
        return;
    }
    
    public static void insertionSort() {
        // Coded by Sialsa, June Rey
        int[] copy = arr.clone(); 
        int index, elem;
        int move; // Used to move backwards
        int key; // Store element we want to inset
        System.out.print("Given Array Elements: \n");
        for (int i = 0; i < count; i++) {
            System.out.printf("%7d", arr[i]);
        }
        System.out.println();
        // Move elemets
        for (index = 1; index < count; index++) {
            key = copy[index];
            move = index - 1;
            // Shifts elements to the right
            while (move >= 0 && copy[move] > key) {
                copy[move + 1] = copy[move];
                move--;
            }
            // Place key at the correct sorted postion
            copy[move + 1] = key;
            // Display
            System.out.print((index) + ". ");
            for (elem = 0; elem < count; elem++) {
                System.out.printf("%7d", copy[elem]);
            }
            System.out.println();
        }
        System.out.print("The Sorted Array Elements: \n");
        for (elem = 0; elem < count; elem++) {
            System.out.printf("%7d", copy[elem]);
        }
        System.out.println();
        prsEnter();
        return;
    }
    
    // Method for clear screen and press enter
        public static void prsEnter() {
        System.out.println("\n- - - - -");
        System.out.println("Press ENTER to continue...");
        input.nextLine();
        input.nextLine();
        System.out.print("\u000C");
    }
    
    // Used to measure the execution time of a sort
        public static void measure(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) / 1_000_000.0 + " ms");
    }
}

