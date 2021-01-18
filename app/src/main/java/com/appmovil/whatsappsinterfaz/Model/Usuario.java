package com.appmovil.whatsappsinterfaz.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    private String name;
    private String type;
    private String created;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created.substring(0,10).replace("-", "/");
    }

    public void setCreated(String created) {
        this.created = created;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    private String urlimage;


    public Usuario(JSONObject a) throws JSONException {
        name =  a.getString("name").toString();
        type =  a.getString("type").toString() + " " + a.getString("species").toString() ;
        created =  a.getString("created").toString() ;
        website =  a.getString("image").toString() ;
        urlimage = a.getString("image").toString() ;


    }

    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Usuario(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}