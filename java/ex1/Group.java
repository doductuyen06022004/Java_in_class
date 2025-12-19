package ex1;

import java.awt.*;
import java.time.LocalDate;

public class Group {
    public Component accounts;
    Group[] groups = new Group[3];
    int id;
    String name;
    Account creator;
    LocalDate createDate;
}
