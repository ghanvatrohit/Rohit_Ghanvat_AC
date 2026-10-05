import java.util.Scanner;

/**
 * AttendenceManagement
 */
class AttendanceManagement {
    public float presentAttend(int arr[]) {
        // check dont forgot
        if (arr.length == 0) {
            System.out.println("No attendance data available.");
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        float percentage = ((float) count / arr.length) * 100;
        System.out.println("Days Present = " + count);
        System.out.println(
                "Attendance : " + String.format("%.2f", percentage) + " %");
        return percentage;
    }

    // Check Eligibility
    void checkEligible(float percentage) {
        if (percentage > 75) {
            System.out.println("Student is eligible for the exam");
        } else {
            System.out.println("Student is Not eligible for the exam !");
        }
    }

    // void badge(int arr[]) {
    // int countbdg = 0;
    // int maxBedge = 0;
    // int countabg = 0;
    // int maxAbBedge = 0;
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] == 1) {
    // countbdg++;
    // } else {
    // if (countbdg > maxBedge) {
    // maxBedge = countbdg;
    // }
    // countbdg = 0;
    // }

    // if (arr[i] == 0) {
    // countabg++;
    // } else {
    // if (countabg > maxAbBedge) {
    // maxAbBedge = countabg;
    // }
    // countabg = 0;
    // }

    // if (countbdg > maxBedge) {
    // maxBedge = countbdg;
    // }

    // if (countabg > maxAbBedge) {
    // maxAbBedge = countabg;
    // }
    // }
    // System.out.println("Max bedge of present is : " + maxBedge);
    // System.out.println("Max bedge of absent is : " + maxAbBedge);
    // }

    // OR

    // Find Longest Present and Absent Streak
    void badge(int arr[]) {

        int present = 0;
        int absent = 0;

        int maxPresent = 0;
        int maxAbsent = 0;

        int presentEnd = -1;
        int absentEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {

                present++;
                absent = 0;

                if (present > maxPresent) {
                    maxPresent = present;
                    presentEnd = i;
                }

            } else {

                absent++;
                present = 0;

                if (absent > maxAbsent) {
                    maxAbsent = absent;
                    absentEnd = i;
                }
            }
        }

        if (maxPresent > 0) {
            int presentStart = presentEnd - maxPresent + 1;

            System.out.println(
                    "Longest Presence = " + maxPresent +
                            " days (Day " + (presentStart + 1) +
                            " to Day " + (presentEnd + 1) + ")");
        }

        if (maxAbsent > 0) {
            int absentStart = absentEnd - maxAbsent + 1;

            System.out.println(
                    "Longest Absence = " + maxAbsent +
                            " days (Day " + (absentStart + 1) +
                            " to Day " + (absentEnd + 1) + ")");
        }
    }

    // Calculate More Days Required
    void moreDays(int arr[], float percentage) {

        if (percentage >= 75) {
            System.out.println("Student is already eligible.");
            return;
        }

        int present = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                present++;
            }
        }

        int totalDays = arr.length;
        int days = 0;

        // Keep adding present days until attendance reaches 75%
        while (((double) present / totalDays) * 100 < 75) {

            present++;
            totalDays++;
            days++;
        }

        System.out.println("More days required = " + days);
        System.out.println(
                "New Attendance = " +
                        String.format("%.2f", ((double) present / totalDays) * 100) +
                        " %");
    }
}

public class AttendanceReport {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
            "How many days you want to create attendance sheet = "
        );

        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Invalid size.");
            sc.close();
            return;
        }

        int[] arr = new int[size];

        System.out.println(
            "Enter attendance data (0 = Absent, 1 = Present):"
        );

        for (int i = 0; i < size; i++) {

            while (true) {

                int value = sc.nextInt();

                if (value == 0 || value == 1) {
                    arr[i] = value;
                    break;
                }

                System.out.println(
                    "Invalid Input! Enter only 0 or 1:"
                );
            }
        }

        AttendanceManagement AM = new AttendanceManagement();

        float percentage = AM.presentAttend(arr);

        AM.checkEligible(percentage);

        AM.badge(arr);

        AM.moreDays(arr, percentage);

        sc.close();
    }
}