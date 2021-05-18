package miTiendita.venta;

import miTiendita.descuento.*;
import miTiendita.productos.Producto;
import java.util.*;

public class Venta {
    int diaSemana;
    boolean terceraEdad;
    List<LineaDeDetalle> ld = new ArrayList<LineaDeDetalle>();
    IDesctoStrategy IDescto;


    public Venta(int diaSemana, boolean terceraEdad)
    {
        this.diaSemana = diaSemana;
        this.terceraEdad = terceraEdad;

        addDescto();
    }

    public void addProducto(Producto p, double ctd)
    {
        ld.add(new LineaDeDetalle(p,ctd));
    }

    public void addDescto()
    {
        if (diaSemana == 1 || diaSemana == 7){
            if (terceraEdad)
                IDescto = new AdultoMayor();
            else
                IDescto = new SinDescuento();
        }else{
            switch (diaSemana){
                case 3:
                    IDescto = new MenonitaDescuento();
                    break;
                case 4:
                    IDescto = new FrutaDescuento();
                    break;
                case 5:
                    IDescto = new EmbutidosLacteos();
                    break;
                default:
                    IDescto = new SinDescuento();
            }
        }

    }

    public List<LineaDeDetalle> getLd() {
        return ld;
    }

    public float getSubTotal()
    {
        float subTotal = 0;
        for (LineaDeDetalle linea: ld){
            Producto p = linea.getP();
            System.out.println("cant : "+linea.getCtd()+" precio: "+p.getPunit());
            subTotal += (float) (linea.getCtd() * p.getPunit());
        }
        return subTotal;
    }

    public double getTotal()
    {
        float descuento = IDescto.getDescto(this);
        float subTotal = getSubTotal();
        float total = (float) (subTotal - descuento + ((subTotal - descuento) * 0.16));
        return total;
    }

}