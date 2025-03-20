public class Conversion {
        public static void main(String[] args) {
        System.out.println("     Feet to Meters | Meters to Feet");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s %-10s | %-10s %-10s\n", "Feet", "Meters", "Meters", "Feet");
        
            for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            double meters = footToMeter(i);
            double feet = meterToFoot(j);
            System.out.printf("%-10d %-10.3f | %-10d %-10.3f\n", i, meters, j, feet);
            }
        }
        /** Convert from feet to meters */
        public static double footToMeter(double foot) {
            return 0.305 * foot;
        }

        /** Convert from meters to feet */
        public static double meterToFoot(double meter) {
            return 3.279 * meter;
        }
    }
