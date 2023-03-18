package in.edu.svecw.samachar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ImageView iv;
    TextView d_t, d_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        iv = findViewById(R.id.details_news_img);
        d_t = findViewById(R.id.details_title_tv);
        d_c = findViewById(R.id.details_content_tv);

        Intent i = getIntent();
        NewsArticle article = (NewsArticle) i.getSerializableExtra("KUY");
        Glide.with(this).load(article.getImageURL()).into(iv);
        d_t.setText(article.getTitle());
        d_c.setText(article.getContent());
    }
}