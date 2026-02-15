package util.enumUtil;

import Prog1Tools.IOTools;

public class EnumUtils {
    public static <E extends Enum<E>> String formattedString(Class<E> enumClass) {
        StringBuilder sb = new StringBuilder();
        for (E value : enumClass.getEnumConstants()) {
            /*
            if (value instanceof hasSymbol val && value instanceof hasDisplayName valu) {
                sb.append(valu.displayName()).append(" (").append(val.symbol()).append("), ");
            } else {
                sb.append(value).append(" (").append(value.ordinal()).append("), ");
            }
            */
            if (value instanceof hasDisplayName val) {
                sb.append(val.displayName());
            } else {
                sb.append(value);
            }
            sb.append(" (").append(value.ordinal()).append("), ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static <E extends Enum<E>> E getFromUserInput(Class<E> enumClass) {
        while (true) {
            String input = IOTools.readString("Enter the value or the index (" + formattedString(enumClass) + "): ");
            try {
                return enumClass.getEnumConstants()[Integer.parseInt(input)];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter a valid index!");
            } catch (NumberFormatException e) {
                try {
                    return Enum.valueOf(enumClass, input.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    System.out.println("Enter a valid " + enumClass.getSimpleName() +"!");
                }
            }
        }
    }
}

