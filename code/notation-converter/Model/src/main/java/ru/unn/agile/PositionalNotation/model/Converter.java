package ru.unn.agile.PositionalNotation.model;

public final class Converter {
    private Converter() {
    }
    public static String convert(final String number,
                                 final String fromNotation, final String toNotation) {
        Integer decimal = null;
        String result = new String("");
        switch (fromNotation) {
            case Notations.BINARY: decimal = ToDecimalConverter.convertBinaryToDecimal(number);
                break;
            case Notations.DECIMAL: decimal = ToDecimalConverter.convertDecimalToDecimal(number);
                break;
            case Notations.HEX: decimal = ToDecimalConverter.convertHexToDecimal(number);
                break;
            case Notations.OCTAL: decimal = ToDecimalConverter.convertOctalToDecimal(number);
                break;
            default: break;
        }
        if (decimal != null) {
            switch (toNotation) {
                case Notations.BINARY:
                    result = FromDecimalConverter.convertToBinary(decimal);
                    break;
                case Notations.DECIMAL:
                    result = FromDecimalConverter.convertToDecimal(decimal);
                    break;
                case Notations.HEX:
                    result = FromDecimalConverter.convertToHex(decimal);
                    break;
                case Notations.OCTAL:
                    result = FromDecimalConverter.convertToOctal(decimal);
                    break;
                default: break;
            }
        }
        return result;
    }
}
