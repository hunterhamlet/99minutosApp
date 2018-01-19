package com.a99minutos.a99minutoscom.App;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 99minutos on 18/01/18.
 */

public class DonVeloz extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private String tel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
