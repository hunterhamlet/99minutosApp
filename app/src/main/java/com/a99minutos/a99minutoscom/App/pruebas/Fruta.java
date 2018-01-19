package com.a99minutos.a99minutoscom.App.pruebas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 99minutos on 16/01/18.
 */

public class Fruta implements Parcelable{
    public String nombre;
    public int unidades;


    protected Fruta(Parcel in) {
        nombre = in.readString();
        unidades = in.readInt();
    }

    public static final Creator<Fruta> CREATOR = new Creator<Fruta>() {
        @Override
        public Fruta createFromParcel(Parcel in) {
            return new Fruta(in);
        }

        @Override
        public Fruta[] newArray(int size) {
            return new Fruta[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(unidades);
    }
}
