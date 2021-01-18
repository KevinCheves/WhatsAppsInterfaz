package com.appmovil.whatsappsinterfaz;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appmovil.whatsappsinterfaz.Adapter.UsuarioAdapter;
import com.appmovil.whatsappsinterfaz.Model.Usuario;
import com.appmovil.whatsappsinterfaz.WebService.Asynchtask;
import com.appmovil.whatsappsinterfaz.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.appmovil.whatsappsinterfaz.Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements Asynchtask {
    RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static com.appmovil.whatsappsinterfaz.Fragment1 newInstance(String param1, String param2) {
        com.appmovil.whatsappsinterfaz.Fragment1 fragment = new com.appmovil.whatsappsinterfaz.Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewF);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://rickandmortyapi.com/api/character/?page=19",
                datos, v.getContext(), this);
        ws.execute("GET");
        return v;
         }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("results");

            lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

            UsuarioAdapter adapatorUsuario = new UsuarioAdapter(this.getContext(), lstUsuarios);
            recyclerView.setAdapter(adapatorUsuario);

        }catch (JSONException e)
        {
            Toast.makeText(this.getContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}