package com.vti.backend;

public class SecondaryStudent {


    public static int getIdSecondaryStudent() {
        return idSecondaryStudent;
    }

    public static void setIdSecondaryStudent(int idSecondaryStudent) {
        SecondaryStudent.idSecondaryStudent = idSecondaryStudent;
    }

    public SecondaryStudent() {
        idSecondaryStudent++ ;
    }

    private static int idSecondaryStudent =0 ;

}
