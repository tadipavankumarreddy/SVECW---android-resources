# SVECW---android-resources

[Read the ebook here](https://android-app-development-documentation.readthedocs.io/en/latest/index.html)

Bootcamp Video Links Day 1 ->

- [First Half](https://youtube.com/live/MzNfUfR8sHA?feature=share)
- [Second Half](https://youtu.be/r23UPW7OA1Q)

[URL](https://inshorts.deta.dev/news?category=entertainment)


Inshorts News Application
- [Part 1](https://www.youtube.com/watch?v=A8HvhQ4HnAk&t=4s) setting up the project, Doing networking and showing the results to the user.

- [Part 2](https://www.youtube.com/watch?v=acZ_D_BC3ug)

- [part 3](https://youtu.be/oH-9kXdEjH0)

-[Part 4](https://youtu.be/x5dlotdoL-0)

-[Part 5](https://youtu.be/3PGZdF5z_mU)

Code

```java
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
                            tv.setText("");
                            for(int i=0; i<allNews.length(); i++){
                                JSONObject item = allNews.getJSONObject(i);
                                String title = item.getString("title");
                                String author = item.getString("author");
                                String content = item.getString("content");
                                String imageURL = item.getString("imageUrl");
                                NewsArticle article = new NewsArticle(title,content,author,imageURL);
                                articles.add(article);
                                tv.append(title+"\n");
                            }

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                tv.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);
    }
```

```NewsArticle```

```Java
public class NewsArticle {
    String title;
    String content;
    String author;
    String imageURL;

    public NewsArticle() {

    }

    public NewsArticle(String title, String content, String author, String imageURL) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageURL() {
        return imageURL;
    }
}
```
