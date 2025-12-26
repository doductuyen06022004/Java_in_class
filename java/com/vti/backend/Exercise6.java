package com.vti.backend;

import com.vti.entity.Phone;
import com.vti.entity.VietnamesePhone;

public class Exercise6 {
public static void question1() {
    Phone phone = new VietnamesePhone();

    phone.insertContact("Nam", "0901234567");
    phone.insertContact("Lan", "0912345678");

    phone.searchContact("Nam");

    phone.updateContact("Nam", "0988888888");
    phone.searchContact("Nam");

    phone.removeContact("Lan");
    phone.searchContact("Lan");
}
}

