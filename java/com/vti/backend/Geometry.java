package com.vti.backend;

public abstract class Geometry {
    private static int count = 0;

    public Geometry() throws GeometryException {
        if (count >= Configs.SO_LUONG_HINH_TOI_DA) {
            throw new GeometryException(
                    "Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA
            );
        }
        count++;
    }

}
