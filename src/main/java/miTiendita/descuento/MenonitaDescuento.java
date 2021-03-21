package miTiendita.descuento;

import miTiendita.productos.Producto;
import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class MenonitaDescuento implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        // TODO Auto-generated method stub
        System.out.println("Descuento de 10% en lacteos");
        float totalDescuento = 0;
        for(LineaDeDetalle linea: v.getLd()){
            Producto p = linea.getP();
            if ((p.getClave() > 0 && p.getClave() < 4) || p.getClave() == 5){
                totalDescuento += (linea.getCtd() * p.getPunit()) * 0.10;
            }
        }
        return totalDescuento;
    }
}
