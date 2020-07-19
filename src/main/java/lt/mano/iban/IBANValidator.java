package lt.mano.iban;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IBANValidator {
    private static Map<String, Integer> countryIBANLength = new HashMap<>();

    public IBANValidator() {

        countryIBANLength.put("AE", 20);
        countryIBANLength.put("AL", 28);
        countryIBANLength.put("AT", 20);
        countryIBANLength.put("AZ", 28);
        countryIBANLength.put("BA", 20);
        countryIBANLength.put("BG", 22);
        countryIBANLength.put("BH", 22);
        countryIBANLength.put("BR", 29);
        countryIBANLength.put("BY", 28);
        countryIBANLength.put("CH", 21);
        countryIBANLength.put("CR", 22);
        countryIBANLength.put("CY", 28);
        countryIBANLength.put("CZ", 24);
        countryIBANLength.put("DE", 22);
        countryIBANLength.put("DK", 18);
        countryIBANLength.put("DO", 28);
        countryIBANLength.put("EE", 20);
        countryIBANLength.put("ES", 24);
        countryIBANLength.put("FI", 18);
        countryIBANLength.put("FO", 18);
        countryIBANLength.put("FR", 27);
        countryIBANLength.put("GB", 22);
        countryIBANLength.put("GE", 22);
        countryIBANLength.put("GI", 23);
        countryIBANLength.put("GL", 18);
        countryIBANLength.put("GR", 27);
        countryIBANLength.put("GT", 28);
        countryIBANLength.put("HR", 21);
        countryIBANLength.put("HU", 28);
        countryIBANLength.put("IE", 22);
        countryIBANLength.put("IL", 23);
        countryIBANLength.put("IS", 26);
        countryIBANLength.put("IT", 27);
        countryIBANLength.put("IQ", 23);
        countryIBANLength.put("JO", 30);
        countryIBANLength.put("KW", 30);
        countryIBANLength.put("KZ", 20);
        countryIBANLength.put("LB", 28);
        countryIBANLength.put("LC", 32);
        countryIBANLength.put("LI", 21);
        countryIBANLength.put("LU", 20);
        countryIBANLength.put("LV", 21);
        countryIBANLength.put("MC", 27);
        countryIBANLength.put("MD", 24);
        countryIBANLength.put("ME", 22);
        countryIBANLength.put("MK", 19);
        countryIBANLength.put("MR", 27);
        countryIBANLength.put("MT", 31);
        countryIBANLength.put("MU", 30);
        countryIBANLength.put("NL", 18);
        countryIBANLength.put("NO", 15);
        countryIBANLength.put("PK", 24);
        countryIBANLength.put("PL", 28);
        countryIBANLength.put("PS", 29);
        countryIBANLength.put("PT", 25);
        countryIBANLength.put("QA", 29);
        countryIBANLength.put("RO", 24);
        countryIBANLength.put("RS", 22);
        countryIBANLength.put("SA", 24);
        countryIBANLength.put("SC", 31);
        countryIBANLength.put("SE", 24);
        countryIBANLength.put("SI", 19);
        countryIBANLength.put("SK", 24);
        countryIBANLength.put("SM", 27);
        countryIBANLength.put("ST", 25);
        countryIBANLength.put("TL", 23);
        countryIBANLength.put("TN", 24);
        countryIBANLength.put("TR", 26);
        countryIBANLength.put("UA", 29);
        countryIBANLength.put("VG", 24);
        countryIBANLength.put("XK", 20);
        countryIBANLength.put("LT", 20);
    }

    private boolean checkLength(String iban) {

        if (iban.length() < 3) return false;

        if ((countryIBANLength.get(iban.substring(0, 2)) != null) && ((countryIBANLength.get(iban.substring(0, 2)) == iban.length()))) {
            return true;
        } else {
            return false;
        }
    }

    private String moveFourCharsToEnd(String iban) {
        return iban.substring(4) + iban.substring(0, 4);
    }


    private String convertToNumbers(String iban) {
        String total = "";
        for (int i = 0; i < iban.length(); i++) {
            int charValue = Character.getNumericValue(moveFourCharsToEnd(iban).charAt(i));
            total += charValue;
        }
        return total;
    }

    private Integer calculateModulus(String convertedIban) {
        BigInteger numberIBAN = new BigInteger(convertedIban);
        int divider = 97;
        return numberIBAN.remainder(BigInteger.valueOf(divider)).intValue();
    }

    public Boolean isValid(String iban) {
        if (checkLength(iban) && isValidFormat(iban)) {
            String numIBAN = convertToNumbers(iban);
            if (calculateModulus(numIBAN) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private Boolean isValidFormat(String iban) {
        String regex = "^[A-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(iban);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
