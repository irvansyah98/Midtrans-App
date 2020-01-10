package com.iervan.belajarmidtrans;

import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.snap.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class DataCustomer {
    public static String NAME = "iervan";
    public static String PHONE = "08989786868685";
    public static String EMAIL = "iervan@gmail.com";
    public static String ADDRESS = "Sby";

    public static List<Product> getListProduct(){
        List<Product> list = new ArrayList<>();
        list.add(new Product("https://s2.bukalapak.com/img/2149162491/w-1000/MOUSE_LOGITECK_MOUSE_LAPTOP_MOUSE_PC_MOUSE_KOMPUTER_MOUSE_OR.png",
                "Mouse", 1, 10000,3));
        list.add(new Product("https://s2.bukalapak.com/img/2149162491/w-1000/MOUSE_LOGITECK_MOUSE_LAPTOP_MOUSE_PC_MOUSE_KOMPUTER_MOUSE_OR.png",
                "Mouse 2", 1, 10000,3));
        return list;
    }

    public static CustomerDetails customerDetails(){
        CustomerDetails cd = new CustomerDetails();
        cd.setFirstName(NAME);
        cd.setPhone(PHONE);
        cd.setEmail(EMAIL);

        return cd;
    }

    public static TransactionRequest transactionRequest(String id, int price, int qty, String name){
        TransactionRequest request = new TransactionRequest(System.currentTimeMillis()+" ", 20000);
        request.setCustomerDetails(customerDetails());
        ItemDetails details = new ItemDetails(id, price, qty, name);

        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        itemDetails.add(details);
        request.setItemDetails(itemDetails);

        CreditCard creditCard = new CreditCard();
        creditCard.setSaveCard(false);
        creditCard.setAuthentication(CreditCard.AUTHENTICATION_TYPE_RBA);
        creditCard.setBank(BankType.MANDIRI);
        request.setCreditCard(creditCard);

        return request;
    }
}
