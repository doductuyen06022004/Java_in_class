package com.vti.backend;

public class PrimaryStudent {
    private static int idPrimaryStudent = 0 ;
    public PrimaryStudent() {
        PrimaryStudent.idPrimaryStudent++ ;
    }


    public static int getIdPrimaryStudent() {
        return idPrimaryStudent;
    }

    public void setIdPrimaryStudent(int idPrimaryStudent) {
        PrimaryStudent.idPrimaryStudent = idPrimaryStudent;
    }

}
