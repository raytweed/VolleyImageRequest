package application.android.example.com.volleyimagerequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton ins;
    private RequestQueue requestQueue;
    private static Context que;
private  MySingleton(Context context){
    que=context;
    requestQueue=getRequestQueue();
}
    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(que.getApplicationContext());
        }
        return requestQueue;
    }
    public  static synchronized MySingleton getIns(Context context){
    if(ins==null){
        ins=new MySingleton(context);
    }
    return ins;
    }
    public void addTorequest(Request request){
     requestQueue.add(request);
    }
}