public class SleeperCoach {

    private boolean[] booked;
    private int n;

    // Constructor
    public SleeperCoach(int n) {
        this.n = n;
        booked = new boolean[n + 1];
    }

    // Find berth type
    static String berthType(int seatNo) {

        int rem = seatNo % 8;

        if (rem == 1 || rem == 4) {
            return "LB";
        }
        else if (rem == 2 || rem == 5) {
            return "MB";
        }
        else if (rem == 3 || rem == 6) {
            return "UB";
        }
        else if (rem == 7) {
            return "SL";
        }
        else {
            return "SU";
        }
    }

    // Book a berth
    public int book(String preferred) {

        // Pass 1: Search preferred berth type
        for (int s = 1; s <= n; s++) {

            if (!booked[s]
                    && berthType(s).equalsIgnoreCase(preferred)) {

                booked[s] = true;
                return s;
            }
        }

        // Pass 2: Search any free berth
        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {
                booked[s] = true;
                return s;
            }
        }

        // No berth available
        return -1;
    }

    // Cancel booking
    public boolean cancel(int seatNo) {

        // Invalid berth number
        if (seatNo < 1 || seatNo > n) {
            System.out.println("Invalid berth number");
            return false;
        }

        // Berth is already free
        if (!booked[seatNo]) {
            System.out.println("Berth is not booked");
            return false;
        }

        // Cancel booking
        booked[seatNo] = false;

        System.out.println("Berth " + seatNo + " cancelled");

        return true;
    }

    // Count available berths
    public int available() {

        int count = 0;

        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {
                count++;
            }
        }

        return count;
    }

    // Print complete berth chart
    public void printChart() {

        for (int s = 1; s <= n; s++) {

            String status;

            if (booked[s]) {
                status = "X";
            }
            else {
                status = "_";
            }

            System.out.print(
                s + ":" + berthType(s) + ":" + status + "  "
            );
        }

        System.out.println();
    }

    // Count available berths by type
    public void availableByType() {

        int lb = 0;
        int mb = 0;
        int ub = 0;
        int sl = 0;
        int su = 0;

        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {

                String type = berthType(s);

                if (type.equals("LB")) {
                    lb++;
                }
                else if (type.equals("MB")) {
                    mb++;
                }
                else if (type.equals("UB")) {
                    ub++;
                }
                else if (type.equals("SL")) {
                    sl++;
                }
                else {
                    su++;
                }
            }
        }

        System.out.println("LB = " + lb);
        System.out.println("MB = " + mb);
        System.out.println("UB = " + ub);
        System.out.println("SL = " + sl);
        System.out.println("SU = " + su);
    }

    public static void main(String[] args) {

        SleeperCoach coach = new SleeperCoach(16);

        // Already booked: 1, 2, 4, 7
        coach.booked[1] = true;
        coach.booked[2] = true;
        coach.booked[4] = true;
        coach.booked[7] = true;

        System.out.println("Initial Chart:");
        coach.printChart();

        System.out.println();

        // Book LB
        int berth1 = coach.book("LB");

        if (berth1 == -1) {
            System.out.println("Waiting List");
        }
        else {
            System.out.println(
                "book(\"LB\") -> Berth " +
                berth1 + " (" + berthType(berth1) + ")"
            );
        }

        // Book SL
        int berth2 = coach.book("SL");

        if (berth2 == -1) {
            System.out.println("Waiting List");
        }
        else {
            System.out.println(
                "book(\"SL\") -> Berth " +
                berth2 + " (" + berthType(berth2) + ")"
            );
        }

        // Book SL again
        int berth3 = coach.book("SL");

        if (berth3 == -1) {
            System.out.println("Waiting List");
        }
        else {
            System.out.println(
                "book(\"SL\") -> Berth " +
                berth3 + " (" + berthType(berth3) + ")"
            );
        }

        // Cancel berth 4
        coach.cancel(4);

        // Book LB again
        int berth4 = coach.book("LB");

        if (berth4 == -1) {
            System.out.println("Waiting List");
        }
        else {
            System.out.println(
                "book(\"LB\") -> Berth " +
                berth4 + " (" + berthType(berth4) + ")"
            );
        }

        // Available berths
        System.out.println(
            "available() -> " + coach.available() + " berths free"
        );

        System.out.println();

        // Available by type
        System.out.println("Available by Type:");
        coach.availableByType();

        System.out.println();

        // Final chart
        System.out.println("Final Chart:");
        coach.printChart();
    }
}