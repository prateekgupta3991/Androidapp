package bitspilani.goa.letsPlay.menu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bitspilani.goa.letsPlay.R;
import bitspilani.goa.letsPlay.retrofit.TemplateService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static android.content.ContentValues.TAG;

/*setting up menu list in app for selection
 * among next activity to perform or
 * in general for use of a list.
 */
public class Menu extends ListActivity {

    String arr[] = {"MainActivity", "TextPlay", "Email", "SnapShot", "GetData",
            "Grafix", "GrafixSurface", "SoundStuff", "Slider", "HorizontalTabs",
            "SimpleBrowser", "Flipp", "SharedPrefData", "DataToInternal",
            "DataToExternal", "DatabaseData"};


    //creating menu
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

//        backend rest calls template
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor())
//                .build();
//
//        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
//                .client(okHttpClient)
//                .addConverterFactory(JacksonConverterFactory.create())
//                .baseUrl("http://13.250.111.164:8098/billshare/");
//        Retrofit retrofit = retrofitBuilder.build();
//        TemplateService billshareService = retrofit.create(TemplateService.class);
//
//        Thread thread = new Thread(() -> {
//            try {
//                Response<String> userResponseDtoResponse = billshareService.getUsers().execute();
//                System.out.println(userResponseDtoResponse.body());
//            } catch (Exception e) {
//                Log.e(TAG, e.getMessage());
//            }
//        });
//        thread.start();

        /*another method of creating intent
         * using class variable method
         * better than the normal way.
         */
        Class mainact;
        try {
            String nxtxt = arr[position];
            mainact = Class.forName("bitspilani.goa.letsPlay.activities." + nxtxt);
            Intent mainactt = new Intent(Menu.this, mainact);
            startActivity(mainactt);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle bun) {
        // TODO Auto-generated method stub
        super.onCreate(bun);

        /*setting the activity as fullscreen
         * Do before setting the content or setting adapter*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*Setting a list adapter because we need to set it up for the
         * menu list. Also setting this list adapter as array adapter.
         * But this array adapter can vary.
         */
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, arr));

    }


    //setting up inflated menu
    //functions related to inflated menu are
    //onCreateOptionsMenu and onOptionsItemSelected
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // TODO Auto-generated method stub
        //remove this statement return super.onCreateOptionsMenu(menu);
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.stdmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        //remove this statement return super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.aus) {
            Intent i = new Intent("bitspilani.goa.letsPlay.ABOUTUS");
            startActivity(i);
        } else if (item.getItemId() == R.id.pref) {
            Intent i = new Intent("bitspilani.goa.letsPlay.PREFERENCE");
            startActivity(i);
        } else {
            finish();
        }
        return true;
    }


}
