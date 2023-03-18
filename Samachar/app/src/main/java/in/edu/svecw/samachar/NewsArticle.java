package in.edu.svecw.samachar;

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
