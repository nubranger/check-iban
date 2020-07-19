package lt.mano.iban;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IbanController {

    @PostMapping("/check")
    public String check (@RequestParam(name = "numberIBAN") String numberIBAN) {
        IBAN iban = new IBAN(numberIBAN);
        return "redirect:/?numberIBAN="+iban.getNumberIBAN()+"&statusIBAN="+iban.getStatusIBAN();
    }
}