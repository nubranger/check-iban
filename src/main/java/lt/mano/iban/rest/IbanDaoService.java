package lt.mano.iban.rest;

import lt.mano.iban.IBAN;
import lt.mano.iban.IBANValidator;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class IbanDaoService {
    private static List ibanlit = new ArrayList<>();

    public List<IBAN> findAll() {
        return ibanlit;
    }

    public IBAN save(IBAN iban) {
        iban.setStatusIBAN(new IBANValidator().isValid(iban.getNumberIBAN()));
        ibanlit.add(iban);
        return iban;
    }
}
