package miTiendita.descuento;

import miTiendita.productos.Producto;
import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class FrutaDescuento implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        // TODO Auto-generated method stub
        System.out.println("Descuento de 15% en frutas");
        float totalDescuento = 0;
        for(LineaDeDetalle linea: v.getLd()){
            Producto p = linea.getP();
            if (p.getClave() == 6 || p.getClave() == 7){
                totalDescuento += (linea.getCtd() * p.getPunit()) * 0.15;
            }
        }
        return totalDescuento;
    }
}
