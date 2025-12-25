package entities;

import java.awt.*;
import java.time.LocalDate;

public class Group {
     public Component accounts;
    public Group[] groups = new Group[3];
    public int id;
    public String name;
    public Account creator;
    public LocalDate createDate;
}
