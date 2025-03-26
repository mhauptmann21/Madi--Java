// Custom Exception for BinaryFormatException
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {

    // Method to convert binary string to decimal
    public static int bin2Dec(String binary) throws BinaryFormatException {
        // Check if the string contains only '0' and '1'
        for (char c : binary.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binary);
            }
        }
        
        // Convert binary to decimal
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal * 2 + (binary.charAt(i) - '0');
        }
        
        return decimal;
    }

    // Test the implementation
    public static void main(String[] args) {
        try {
            String binary = "1101"; // Valid binary string
            System.out.println("Binary: " + binary);
            System.out.println("Decimal: " + bin2Dec(binary));

            String invalidBinary = "1021"; // Invalid binary string
            System.out.println("Binary: " + invalidBinary);
            System.out.println("Decimal: " + bin2Dec(invalidBinary)); // Should throw exception

        } catch (BinaryFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

    