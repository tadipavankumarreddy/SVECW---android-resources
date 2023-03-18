package in.edu.svecw.samachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerview);

        progressBar.setVisibility(View.INVISIBLE);
    }

    public void getNews(View view) {
        progressBar.setVisibility(View.VISIBLE);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://inshorts.deta.dev/news?category=entertainment";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        try {
                            JSONObject root = new JSONObject(response);
                            JSONArray allNews = root.getJSONArray("data");
                            List<NewsArticle> articles = new ArrayList<>();
                            /*tv.setText("");*/
                            for(int i=0; i<allNews.length(); i++){
                                JSONObject item = allNews.getJSONObject(i);
                                String title = item.getString("title");
                                String author = item.getString("author");
                                String content = item.getString("content");
                                String imageURL = item.getString("imageUrl");
                                NewsArticle article = new NewsArticle(title,content,author,imageURL);
                                articles.add(article);
                                /*tv.append(title+"\n");*/
                            }

                            NewsAdapter adapter = new NewsAdapter(getApplicationContext(),articles);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);

            }
        });

        queue.add(stringRequest);
    }
}