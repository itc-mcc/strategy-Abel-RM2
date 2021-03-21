package miTiendita.descuento;

import miTiendita.venta.Venta;

public class AdultoMayor implements IDesctoStrategy {
    @Override
    public float getDescto(Venta v) {
        // TODO Auto-generated method stub
        System.out.println("Descuento del 5%");
        return (float)(v.getSubTotal()*0.05);
    }    
}